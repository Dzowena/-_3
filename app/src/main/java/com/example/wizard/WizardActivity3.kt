package com.example.wizard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_wizard_2.*
import kotlinx.android.synthetic.main.activity_wizard_3.*
import kotlinx.android.synthetic.main.activity_wizard_3.back_button
import kotlinx.android.synthetic.main.activity_wizard_3.next_button


class WizardActivity3 : AppCompatActivity() {
    fun function(){
        next_button.isEnabled = phone_input.text.isNotEmpty() && mail_input.text.isNotEmpty()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_3)

        supportActionBar?.hide()

        phone_input.requestFocus()
        phone_input.doAfterTextChanged{ text -> this.function() }
        mail_input.doAfterTextChanged{ text -> this.function() }

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        next_button.setOnClickListener {
            val intent = Intent(this, WizardActivity4::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("age", age)
            intent.putExtra("gender", gender)
            intent.putExtra("phone", phone_input.text.toString())
            intent.putExtra("mail", mail_input.text.toString())
            startActivity(intent)
        }
        back_button.setOnClickListener { finish() }
    }

}