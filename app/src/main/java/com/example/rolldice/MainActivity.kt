package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.BTN)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!",Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
        rollDice()
    }

    // This class give you random number from 1 for arg (numSide) you set him
    class Dice(private val numSide: Int) {
        fun roll(): Int {
            return (1..numSide).random()
        }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()

        val diceImage: ImageView = findViewById(R.id.Dice_1)
        val diceImage2: ImageView = findViewById(R.id.Dice_2)


        val drawableResource1 = when (dice1Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (dice2Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

    }

}