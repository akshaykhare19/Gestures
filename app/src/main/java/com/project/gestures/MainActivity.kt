package com.project.gestures

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity() {

    lateinit var detector: GestureDetectorCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //detector which detects some common gestures
        detector = GestureDetectorCompat(this, MyGestureDetector(this))
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        detector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    private class MyGestureDetector(context: Context): GestureDetector.SimpleOnGestureListener(){
        val interiorContext = context

        override fun onLongPress(event: MotionEvent?) {
            super.onLongPress(event)
            Toast.makeText(interiorContext, "Long Pressed", Toast.LENGTH_SHORT).show()
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            Toast.makeText(interiorContext, "Scroll: X - $distanceX : Y - $distanceY", Toast.LENGTH_SHORT).show()
            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            Toast.makeText(interiorContext, "Fling: X - $velocityX : Y - $velocityY", Toast.LENGTH_SHORT).show()
            return super.onFling(e1, e2, velocityX, velocityY)
        }

        override fun onDoubleTap(event: MotionEvent?): Boolean {
            Toast.makeText(interiorContext, "Double Tapped", Toast.LENGTH_SHORT).show()
            return super.onDoubleTap(event)
        }
    }



}