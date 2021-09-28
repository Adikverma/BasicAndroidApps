package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
    /** this activity allows to roll dice and reflect result on screen**/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollDice()
        rollButton.setOnClickListener { rollDice() }
    }
/**this function when called rolls the dice and updates the text on screen**/
    private fun rollDice() {
    /**creating Dice objects**/
        val dice = Dice(6)
        val diceRoll = dice.roll()
    /**accessing the Image View from layout**/
    val diceImg:ImageView=findViewById(R.id.imageView)
    /**updating the image/results on screen**/
    val resId=when(diceRoll){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else ->R.drawable.dice_6
        }
    diceImg.setImageResource(resId)
    /**adding content description to Image View**/
    diceImg.contentDescription=diceRoll.toString()
    }
}
/**dice class with a method to generate random output on dicerolls**/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}