package com.example.wizard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_wizard_2.*
import kotlinx.android.synthetic.main.activity_wizard_4.*
import kotlinx.android.synthetic.main.activity_wizard_4.back_button
import kotlinx.android.synthetic.main.activity_wizard_4.next_button


class WizardActivity4 : AppCompatActivity() {
    fun function(){
        next_button.isEnabled = checkBox.isChecked
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_4)

        supportActionBar?.hide()

        checkBox.setOnCheckedChangeListener { compoundButton, b -> function() }

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val phone = intent.getStringExtra("phone")
        val mail = intent.getStringExtra("mail")
        next_button.setOnClickListener {
            val intent = Intent(this, WizardActivity5::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("age", age)
            intent.putExtra("gender", gender)
            intent.putExtra("phone", phone)
            intent.putExtra("mail", mail)
            startActivity(intent)
        }
        back_button.setOnClickListener { finish() }
    }

}