package com.japo.android.colormyviwes

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textBoxes: List<View> = getTextBoxes()
        setListeners(textBoxes)

        findViewById<Button>(R.id.red_button).setOnClickListener {
            changeAllColor(textBoxes, R.color.red_900)
        }

        findViewById<Button>(R.id.blue_button).setOnClickListener {
            changeAllColor(textBoxes, R.color.blue_900)
        }

        findViewById<Button>(R.id.green_button).setOnClickListener {
            changeAllColor(textBoxes, R.color.green_900)
        }

        findViewById<Button>(R.id.reset_button).setOnClickListener { resetColors(textBoxes) }
    }

    private fun getTextBoxes() : List<View> {
        return listOf(
            findViewById(R.id.one_box_text),
            findViewById(R.id.two_box_text),
            findViewById(R.id.three_box_text),
            findViewById(R.id.four_box_text),
            findViewById(R.id.five_box_text)
        )
    }

    private fun setListeners(views: List<View>) {
        views.forEach { view -> view.setOnClickListener { changeColor(it) } }
    }

    private fun changeColor(view: View){
        val newColor: Int = when(view.id){
            R.id.one_box_text -> R.color.blue_gray_500
            R.id.two_box_text -> R.color.blue_gray_900
            R.id.three_box_text -> R.color.red_500
            R.id.four_box_text -> R.color.blue_500
            R.id.five_box_text -> R.color.green_500
            else -> Color.WHITE
        }

        view.setBackgroundResource(newColor)
    }

    private fun changeAllColor(views: List<View>, color: Int) {
        views.forEach { it.setBackgroundResource(color) }
    }

    private fun resetColors(views: List<View>) {
        views.forEach { it.setBackgroundResource(R.color.blue_gray_100) }
    }

}