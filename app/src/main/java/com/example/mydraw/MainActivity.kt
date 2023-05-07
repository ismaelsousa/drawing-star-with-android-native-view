package com.example.mydraw

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutConstraint: ConstraintLayout = findViewById(R.id.first)

        // Star
        val myStar = Star(this.applicationContext);
        myStar.id = View.generateViewId()
        layoutConstraint.addView(myStar)

        // Text
        val textView = TextView(this)
        textView.text = "Ismael"
        textView.id = View.generateViewId()
        textView.setTextColor(Color.YELLOW)
        textView.textSize = 30f
        layoutConstraint.addView(textView)


        val constraintSet = ConstraintSet()

        constraintSet.constrainWidth(textView.id, ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(textView.id, ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(myStar.id, 500);
        constraintSet.constrainHeight(myStar.id, 500);

        // Constraint for the text
        constraintSet.connect(textView.id, ConstraintSet.TOP, layoutConstraint.id, ConstraintSet.TOP, 20)
        constraintSet.connect(textView.id, ConstraintSet.LEFT, layoutConstraint.id, ConstraintSet.LEFT, 20)

        // Constraints for the star
        constraintSet.connect(myStar.id, ConstraintSet.TOP, textView.id, ConstraintSet.BOTTOM, 100);
        constraintSet.connect(myStar.id, ConstraintSet.LEFT,layoutConstraint.id, ConstraintSet.LEFT, 20);
        constraintSet.applyTo(layoutConstraint)

    }
}