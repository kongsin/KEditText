# KEditText
Keyboard show hide callback edittext

```xml

    <com.kongsin.KEditText
        android:id="@+id/edt"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_gravity="bottom"
        android:hint="Name"/>

```

```java

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

```