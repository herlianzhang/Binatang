package com.latihangoding.binatang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latihangoding.binatang.Model.BinatangModel


class ListBinatangAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    private var listOfBinatang = listOf<BinatangModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BinatangHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_cell, parent, false))
    }

    override fun getItemCount() = listOfBinatang.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         holder as BinatangHolder
        holder.binding(listOfBinatang[position], onItemClickCallback)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listOfBinatang[holder.adapterPosition])}
    }

    fun setBinatangList(listOfBinatang: List<BinatangModel>) {
        this.listOfBinatang = listOfBinatang
        notifyDataSetChanged()
    }

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: BinatangModel)
    }
}

