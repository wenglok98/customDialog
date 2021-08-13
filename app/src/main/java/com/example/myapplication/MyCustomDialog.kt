package com.example.myapplication

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyCustomDialog : DialogFragment() {

    lateinit var send_BT: Button
    lateinit var close_ImBT: ImageButton
    lateinit var msg_EDT: EditText



    lateinit var listener: CustomDialogListener // Listener for button and edit text

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Set round dialog, can change value/ radius from the file round_dialog
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_dialog);

        var view = inflater.inflate(R.layout.dialoglayout, container, false)


        send_BT = view.findViewById(R.id.send_BT)
        close_ImBT = view.findViewById(R.id.close_ImBT)
        msg_EDT = view.findViewById(R.id.getMessage_EDT)

        close_ImBT.setOnClickListener {
            dismiss() // Close button
        }
        send_BT.setOnClickListener {

            //Apply text to bring data to your activity
            listener.applytext(msg_EDT.text.toString().trim())

            dismiss()//Dismiss the dialog after press send
        }


        return view
    }

    override fun dismiss() {
        msg_EDT.text = null //Make default dismiss will clear the edit text
        super.dismiss()
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        dialog!!.setCanceledOnTouchOutside(true) // Set touch on background

    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            listener = activity as CustomDialogListener
        } catch (e: Exception) {
        }
    }

    interface CustomDialogListener {
        fun applytext(value: String)
    }


}