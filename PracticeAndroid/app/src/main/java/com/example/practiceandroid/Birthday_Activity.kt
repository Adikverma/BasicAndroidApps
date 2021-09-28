package com.example.practiceandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

//import kotlinx.android.synthetic.main.activity_birthday.*

class Birthday_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        val createBirthdayButton: Button =findViewById(R.id.createBirthdayButton)
        val edtToName: EditText =findViewById(R.id.edtToName)
        val edtFromName: EditText =findViewById(R.id.edtFromName)

        createBirthdayButton.setOnClickListener {
            val to=edtToName.text.toString()
            val from=edtFromName.text.toString()
            Intent(this,greeting_activity::class.java).also {
                it.putExtra("EXTRA_To",to)
                it.putExtra("EXTRA_From",from)
                startActivity(it)
            }
        }
    }
}