package com.example.practiceandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class greeting_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val txtFrom:TextView=findViewById(R.id.txtFrom)
        val txtTo:TextView=findViewById(R.id.txtTo)
        val to=intent.getStringExtra("EXTRA_To")
        val from=intent.getStringExtra("EXTRA_From")

        txtTo.text="Happy Birthday,$to"
        txtFrom.text="From $from"
    }
}