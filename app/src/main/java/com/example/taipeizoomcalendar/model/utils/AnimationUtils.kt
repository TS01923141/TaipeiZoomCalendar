package com.example.taipeizoomcalendar.model.utils

import android.app.Activity
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.util.Log

private const val TAG = "AnimationUtils"
object AnimationUtils {
    fun init(activity: Activity, type: String) {
        when (type) {
            "explode" -> {
                val explodeTransition = Explode()
                explodeTransition.duration = 2000
                activity.window.enterTransition = explodeTransition
                activity.window.exitTransition = explodeTransition
            }

            "slide" -> {
                val slideTransition = Slide()
                slideTransition.duration = 2000
                activity.window.enterTransition = slideTransition
                activity.window.exitTransition = slideTransition
            }

            "fade" -> {
                val fadeTransition = Fade()
                fadeTransition.duration = 2000
                activity.window.enterTransition = fadeTransition
                activity.window.exitTransition = fadeTransition
            }
        }
    }
}