package com.latihangoding.binatang.Media

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latihangoding.binatang.R

class MediaAdapter(var media: IntArray): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MediaHolder(LayoutInflater.from(parent.context).inflate(R.layout.media_binatang, parent, false))
    }

    override fun getItemCount() = media.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mediaHolder = holder as MediaHolder
        mediaHolder.binding(media[position])
        holder.itemView.setOnClickListener() { onItemClickCallback.onItemClicked() }
    }

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked()
    }
}