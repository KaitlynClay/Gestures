package com.example.gestures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null
    lateinit var getGestureText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getGestureText = findViewById(R.id.getGestureTxt)

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            this.gDetector?.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent): Boolean {
//        getGestureText.text = "onDown"
        return true
    }

    override fun onShowPress(e: MotionEvent) {
//        getGestureText.text = "onShowPress"
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
//        getGestureText.text = "onSingleTapUp"
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
//        getGestureText.text = "onScroll"
        return true
    }

    override fun onLongPress(e: MotionEvent) {
//        getGestureText.text = "onLongPress"
    }

//    Works!!!
    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            Toast.makeText(applicationContext, "Did you mean to tap?", Toast.LENGTH_SHORT).show().toString()
        return true
    }

    override fun onDoubleTap(e: MotionEvent): Boolean {
//        getGestureText.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
        getGestureText.text = "You are double tapping. Is there something I can help you with?"
        return true
    }
}