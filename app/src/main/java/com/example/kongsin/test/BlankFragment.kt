package com.example.kongsin.test

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.*
import com.kongsin.OnToggleKeyboardListener
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edt.showKeyboard()
        edt.listenToKeboard(object : OnToggleKeyboardListener {
            override fun onKeyboardShow() {

            }

            override fun onKeyboardHide() {
                dismiss()
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}
