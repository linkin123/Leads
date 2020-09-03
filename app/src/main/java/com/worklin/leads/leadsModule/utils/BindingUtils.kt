package com.worklin.leads.leadsModule.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("glide")
fun setImage(view: CircleImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).load(url).placeholder(ColorDrawable(Color.BLUE)).into(view)
    }
}