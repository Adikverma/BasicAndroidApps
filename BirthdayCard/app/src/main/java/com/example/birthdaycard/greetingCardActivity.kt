package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_greeting_card.*

class greetingCardActivity : AppCompatActivity() {
//    companion object{
//        const val Name_Extra="name_extra"
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_card)
        val to=intent.getStringExtra("EXTRA_To")
        val from=intent.getStringExtra("EXTRA_From")

        txtTo.text="Happy Birthday,$to"
        txtFrom.text="From $from"
    }
}