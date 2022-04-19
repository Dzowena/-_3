package com.example.wizard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_wizard_5.*


class WizardActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_5)
        supportActionBar?.hide()
        result_text.text = "your name is: ${intent.getStringExtra("firstName")}\n" +
                "your last name is: ${intent.getStringExtra("lastName")}\n" +
                "your age is: ${intent.getStringExtra("age")}\n" +
                "your gender is: ${intent.getStringExtra("gender")}\n" +
                "your phone number is: ${intent.getStringExtra("phone")}\n" +
                "your mail address is: ${intent.getStringExtra("mail")}\n"
    }

}