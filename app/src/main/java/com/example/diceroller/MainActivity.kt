package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val diceRoll = rollDice(6)
            updateView(diceRoll)
            Toast.makeText(this, "You rolled $diceRoll",Toast.LENGTH_LONG).show()
        }
        updateView(rollDice(6))
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(numSides: Int): Int {
        val dice = Dice(numSides)
        return dice.roll()
    }

    private fun updateView(diceRoll: Int) {
        val diceImage: ImageView = findViewById(R.id.imageView)
        val imgRes = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imgRes)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}