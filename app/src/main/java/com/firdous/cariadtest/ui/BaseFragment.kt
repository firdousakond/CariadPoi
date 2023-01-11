package com.firdous.cariadtest.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.firdous.cariadtest.R
import com.firdous.cariadtest.util.NetworkUtil
import com.firdous.cariadtest.util.showToast

open class BaseFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!NetworkUtil.isInternetConnected(requireContext())) {
            activity?.showToast(getString(R.string.msg_no_internet))
        }
    }
}