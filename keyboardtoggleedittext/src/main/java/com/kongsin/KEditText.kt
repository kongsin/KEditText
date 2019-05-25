package com.kongsin

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

class KEditText : AppCompatEditText, View.OnLayoutChangeListener {

    override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
        val r = Rect()
        rootView.rootView.getWindowVisibleDisplayFrame(r)
        val heightDiff = rootView.rootView.height - (r.bottom - r.top)
        val dp = heightDiff / 1
        val isShowingKeyboard = dp > 250
        if (isShowingKeyboard) {
            mListener?.onKeyboardShow()
        } else {
            mListener?.onKeyboardHide()
        }
    }

    private var mListener : OnToggleKeyboardListener? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun setUpListener() {
        post {
            addOnLayoutChangeListener(this)
        }
    }

    override fun onDetachedFromWindow() {
        removeOnLayoutChangeListener(this)
        super.onDetachedFromWindow()
    }

    fun listenToKeboard(listener: OnToggleKeyboardListener) {
        mListener = listener
        setUpListener()
    }

    fun showKeyboard() {
        post {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                showSoftInputOnFocus = true
                requestFocus()
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
            } else {
                requestFocus()
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
            }
        }
    }

}

interface OnToggleKeyboardListener {
    fun onKeyboardShow()
    fun onKeyboardHide()
}
