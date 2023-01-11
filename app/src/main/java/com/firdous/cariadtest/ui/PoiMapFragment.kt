package com.firdous.cariadtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.firdous.cariadtest.R
import com.firdous.cariadtest.data.Resource
import com.firdous.cariadtest.data.response.PoiResponse
import com.firdous.cariadtest.databinding.FragmentPoiMapBinding
import com.firdous.cariadtest.ui.delegate.ReloadApi
import com.firdous.cariadtest.ui.delegate.ReloadApiImpl
import com.firdous.cariadtest.util.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PoiMapFragment : BaseFragment(), OnMapReadyCallback, ReloadApi by ReloadApiImpl() {

    private lateinit var binding: FragmentPoiMapBinding
    private lateinit var gMap: GoogleMap
    private val viewModel: PoiViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_poi_map, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        viewModel.getPoiList()
        callApiEveryXDuration(DELAY_30_SECOND) {
            viewModel.getPoiList()
        }
        setupObserver()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        gMap = googleMap
        gMap.setOnInfoWindowClickListener { marker ->
            val bundle = bundleOf(PoiDetailsFragment.POI_MODEL to marker.tag)
            findNavController().navigate(R.id.poiDetailsFragment, bundle)
        }
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.poiStateFlow.collectLatest {
                when (it) {
                    is Resource.Loading -> {
                        binding.progressBar.show()
                    }
                    is Resource.Success -> {
                        binding.progressBar.hide()
                        updatePoiOnMap(it.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.hide()
                        Timber.e(it.message)
                    }
                }
            }
        }
    }

    private fun updatePoiOnMap(pois: PoiResponse) {
        if (this::gMap.isInitialized) {
            gMap.clear()
            val builder = LatLngBounds.Builder()
            pois.forEach { item ->
                val latLng =
                    LatLng(item.AddressInfo?.Latitude ?: 0.0, item.AddressInfo?.Longitude ?: 0.0)
                builder.include(latLng)
                val markerOptions = MarkerOptions()
                    .position(latLng)
                    .title(item.OperatorInfo?.Title)
                gMap.addMarker(markerOptions)?.tag = item
            }
            val bounds = builder.build()
            val paddingFromEdgeAsPX = 150
            val cu = CameraUpdateFactory.newLatLngBounds(bounds, paddingFromEdgeAsPX)
            gMap.moveCamera(cu)
        }
    }

}