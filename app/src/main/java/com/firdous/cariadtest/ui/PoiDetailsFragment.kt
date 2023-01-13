package com.firdous.cariadtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.firdous.cariadtest.R
import com.firdous.cariadtest.domain.model.PoiResponseItemEntity
import com.firdous.cariadtest.databinding.FragmentPoiDetailsBinding

class PoiDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPoiDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_poi_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poiModel: PoiResponseItemEntity? = arguments?.getParcelable(POI_MODEL)
        poiModel?.let {
            binding.poiModel = it
        }
}

companion object {
    const val POI_MODEL = "poiModel"
}

}