package com.latihangoding.binatang.Media

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.media_binatang.view.*

class MediaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun binding(media: Int) {
        Glide.with(itemView.context).load(media).into(itemView.media_binatang_img)
    }
}