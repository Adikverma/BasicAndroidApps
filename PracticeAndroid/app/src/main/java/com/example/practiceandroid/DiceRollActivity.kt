package com.example.practiceandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

/** this activity allows to roll dice and reflect result on screen based on your Lucky Number**/
class DiceRollActivity : AppCompatActivity() {
    private var state=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roll)
        /**Button,TextView,EditText Instance to use for the click listener or roll action */
        val rollButton: Button = findViewById(R.id.btnRoll)
        val txtChanceRecord: TextView =findViewById(R.id.txtRecordChances)
        val edtLuckyNumber: EditText =findViewById(R.id.edtLuckyNumber)

        /**setting default image and values at start*/
        val diceImg: ImageView = findViewById(R.id.imvDice)
        diceImg.setImageResource(R.drawable.dice_1)
        var luckyPrev=edtLuckyNumber.text.toString().toInt()
        var chances=6
        /**calling rollDice on click for rolling action*/
        rollButton.setOnClickListener {
            val luckyNumber=edtLuckyNumber.text.toString().toInt()
            if(luckyNumber<1 || luckyNumber>6){
                Toast.makeText(this, "Enter Lucky Number b/w 1-6", Toast.LENGTH_SHORT).show()
                state=1
            }else if(luckyPrev!=luckyNumber) {
                chances = 6
                state=0
                txtChanceRecord.setText("You Have ${chances--} Chances")
            }else if(state==1){
                Toast.makeText(this, "Now Enter New Number", Toast.LENGTH_SHORT).show()
            }else if(chances<1){
                txtChanceRecord.setText("${chances} Chances left ;-)")
                Toast.makeText(this, "Time Out ;-(", Toast.LENGTH_SHORT).show()
            }else {
                rollDice(luckyNumber)
                if(state==0){
                    txtChanceRecord.setText("${chances--} chances are Remaining")
                }else{
                    Toast.makeText(this, "Hurray! Your Lucky Number is Rolled", Toast.LENGTH_SHORT).show()

                }
            }
            luckyPrev=luckyNumber
        }
        /**move to Birthday card activity on Button Click*/
        val nextButton:Button=findViewById(R.id.btnNext2)
        nextButton.setOnClickListener {
            Intent(this,Birthday_Activity::class.java).also {
                startActivity(it)
            }
        }

    }
    /**this function when called rolls the dice and updates the text on screen**/
    private fun rollDice(luckyNumber:Int){
            /**creating Dice objects**/
            val dice = Dice(6)
            val diceRoll = dice.roll()

            if(diceRoll==luckyNumber){
                state=1
            }
            /**accessing the Image View from layout**/
            val diceImg: ImageView = findViewById(R.id.imvDice)

            /**updating the image/results on screen**/
            val resId = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImg.setImageResource(resId)
            /**adding content description to Image View**/
            diceImg.contentDescription = diceRoll.toString()
    }
}
/**dice class with a method to generate random output on diceRoll**/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}