package com.example.wizard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_wizard_2.*


class WizardActivity2 : AppCompatActivity() {
    fun function(){
        next_button.isEnabled = age_input.text.isNotEmpty() && (male_button.isChecked || female_button.isChecked)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_2)

        supportActionBar?.hide()

        age_input.requestFocus()
        age_input.doAfterTextChanged{ text -> this.function() }
        male_button.setOnCheckedChangeListener { compoundButton, b -> function() }
        female_button.setOnCheckedChangeListener { compoundButton, b -> function() }

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        next_button.setOnClickListener {
            val intent = Intent(this, WizardActivity3::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("age", age_input.text.toString())
            if(male_button.isChecked)
                intent.putExtra("gender", "male")
            else
                intent.putExtra("gender", "female")
            startActivity(intent)
        }
        back_button.setOnClickListener { finish() }
    }

}