package com.example.practiceandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//import android.widget.*

class CountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/** Declaring a count variable initially to 0 */
        var count=0
        /** Creating instances of views so that we can access their values and methods*/
        val edtCountTo:EditText=findViewById(R.id.edtCountTo)
        val txtCount:TextView=findViewById(R.id.txtCount)
        val btnCount:Button=findViewById(R.id.btnCount)
        /** Declared a variable for storing and compare the current state of limit with previous one*/
        var limitMinus=0
        /** On Button Click the count int Text View will update according to the conditions*/
        btnCount.setOnClickListener{
            /** Getting the limit form the Edit Text in the Beginning of every button click*/
            val limit:Int=Integer.parseInt(edtCountTo.text.toString())
            /** If Nothing is Entered then show Toast Message, requesting to Enter, Trying to find a way to achieve this*/
//            if(edtCountTo.text.toString().isEmpty()){
//                Toast.makeText(this, "Please Enter a Limit", Toast.LENGTH_SHORT).show()
//            }
            /** If Current Limit is NOT same as previous one, Do the following: Set CountActivity to zero again and update Display + update limit limitMinus */
            if(limit!=limitMinus){
                count=0
                txtCount.setText("${count++}")
                limitMinus=limit
            }
            /** Else if when count reaches the limit show a toast message*/
            else if(count==limit+1) Toast.makeText(this, "Reached $limit", Toast.LENGTH_SHORT).show()
            /** Normally update count and Display in TestView*/
            else txtCount.setText("${count++}")
        }
        /**On Clicking Next: Move Transfer to BirthDay CArd Activity*/
        val buttonNext:Button=findViewById(R.id.btnNext1)
        buttonNext.setOnClickListener {
            Intent(this,DiceRollActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}
