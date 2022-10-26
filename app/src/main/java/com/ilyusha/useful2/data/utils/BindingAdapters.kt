package com.ilyusha.useful2.data.utils

import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.ilyusha.useful2.data.api.models.weather.Condition

class BindingAdapters {
    companion object {

        @JvmStatic
        @BindingAdapter("android:sourceImg")
        fun setImage(view: ImageView, condition: Condition?) {
            if (condition != null) {
                view.setImageResource(condition.conditionImageId)
            }
        }

    }
}