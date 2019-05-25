package com.example.kongsin.test

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomSheetDialogFragment
import android.view.*
import android.widget.Toast
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
        //Auto show keyboard
        edt.showKeyboard()

        //Subscribe to keyboard show/hide event.
        edt.listenToKeboard(object : OnToggleKeyboardListener {
            override fun onKeyboardShow() {
                Toast.makeText(context, "Show keyboard", Toast.LENGTH_SHORT).show()
            }

            override fun onKeyboardHide() {
                Toast.makeText(context, "Hide keyboard", Toast.LENGTH_SHORT).show()
                dismiss()
            }
        })

        //Auto hide keyboard after 3 sec.
        Handler().postDelayed({
            edt.hideKeyboard()
        }, 3000)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}
