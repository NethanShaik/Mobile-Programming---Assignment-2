package com.example.assignment_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogueFragment : DialogFragment(R.layout.dialogue_fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val save: Button = view.findViewById(R.id.submitBT)
        val radioGroup = view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
        val text: EditText = view.findViewById(R.id.task_text)

        save.setOnClickListener {
            val task = text.text.toString()
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context, radioButton.text, Toast.LENGTH_SHORT).show()
            val m1:MainActivity = getActivity() as MainActivity;
            m1.receiveFeedback(task,radioButton.text.toString())
            dismiss()
        }
    }
}
