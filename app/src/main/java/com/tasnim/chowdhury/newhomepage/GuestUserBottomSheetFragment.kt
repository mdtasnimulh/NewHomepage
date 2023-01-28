package com.tasnim.chowdhury.newhomepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tasnim.chowdhury.newhomepage.databinding.FragmentGuestUserBottomSheetBinding
import kotlin.concurrent.thread

class GuestUserBottomSheetFragment: BottomSheetDialogFragment() {

    private var binding: FragmentGuestUserBottomSheetBinding? = null
    private var guestUserHotJobsCompanyJobsAdapter: GuestUserHotJobsCompanyJobsAdapter = GuestUserHotJobsCompanyJobsAdapter()

    companion object {
        fun newInstance(): GuestUserBottomSheetFragment = GuestUserBottomSheetFragment().apply {}
        val tag: String = GuestUserBottomSheetFragment::class.java.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
    }

    override fun onStart() {
        super.onStart()
        val dialog: BottomSheetDialog? = dialog as BottomSheetDialog?
        dialog?.setCanceledOnTouchOutside(true)
        val bottomSheet: FrameLayout? = dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)
        if (bottomSheet != null) {
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
            thread {
                activity?.runOnUiThread {
                    val dynamicHeight = binding?.guestUserCompanyJobsBottomSheetLayout?.height ?: 500
                    BottomSheetBehavior.from(bottomSheet).peekHeight = dynamicHeight
                }
            }
            with(BottomSheetBehavior.from(bottomSheet)) {
                skipCollapsed = true
                isHideable = true
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentGuestUserBottomSheetBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding?.guestUserHotJobsCompanyJobsRV?.let { recyclerView->
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = guestUserHotJobsCompanyJobsAdapter
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}