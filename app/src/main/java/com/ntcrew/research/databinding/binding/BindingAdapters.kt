package com.ntcrew.research.databinding.binding

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.ntcrew.research.databinding.R
import com.ntcrew.research.databinding.data.Popularity


//    applies to the app:hideIfZero attribute.
//    can be applied to every View (since the first parameter is a View; you can restrict to certain classes by changing this type)
    @BindingAdapter("app:hideIfZero")
    fun hideIfZero(view : View, number : Int) {
        view.visibility = if(number == 0) View.GONE else View.VISIBLE
    }

    //Binding Adapter with multiple parameters

    @BindingAdapter(value = ["app:progressScaled", "app:maxLikes"], requireAll = true)
    fun setProgress(progressBar: ProgressBar, likes : Int, max : Int) {
        progressBar.progress = (likes * max / 5).coerceAtMost(max)
    }

    @BindingAdapter("app:popularityIcon")
    fun setPopularityIcon(view : ImageView, popularity: Popularity) {
        val color = getAssociatedColor(popularity, view.context)

        ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color))

        view.setImageDrawable(getDrawablePopularity(popularity, view.context))
    }

    private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
        return when (popularity) {
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0, 0x000000)
            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    }

    private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable? {
        return when (popularity) {
            Popularity.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
        }
    }
