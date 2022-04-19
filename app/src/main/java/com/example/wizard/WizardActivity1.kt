package com.example.wizard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_wizard_1.*

class WizardActivity1 : AppCompatActivity() {
    fun function(){
        next_button.isEnabled = first_name_input.text.isNotEmpty() && last_name_input.text.isNotEmpty()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_1)

        supportActionBar?.hide()

        first_name_input.requestFocus()
        first_name_input.doAfterTextChanged{ text -> this.function() }
        last_name_input.doAfterTextChanged{ text -> this.function() }
        next_button.setOnClickListener {
            val intent = Intent(this, WizardActivity2::class.java)
            intent.putExtra("firstName", first_name_input.text.toString())
            intent.putExtra("lastName", last_name_input.text.toString())
            startActivity(intent)
        }
    }

}