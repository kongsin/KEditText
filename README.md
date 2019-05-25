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

    edt.showKeyboard()
    edt.listenToKeboard(object : OnToggleKeyboardListener {
         override fun onKeyboardShow() {
         
         }
    
        override fun onKeyboardHide() {
            dismiss()
        }
    })

```