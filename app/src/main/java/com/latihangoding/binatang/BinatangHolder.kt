package com.latihangoding.binatang

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.latihangoding.binatang.Media.MediaAdapter
import com.latihangoding.binatang.Model.BinatangModel
import kotlinx.android.synthetic.main.main_cell.view.*

class BinatangHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val rv  = itemView.findViewById<RecyclerView>(R.id.media_layout)

    init {
        PagerSnapHelper().attachToRecyclerView(rv)
        rv.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }
    fun binding(binatangModel: BinatangModel, onItemClickCallback: ListBinatangAdapter.OnItemClickCallback) {
        itemView.nama_binatang.text = "Nama Binatang: ${binatangModel.name}"
        val mediaAdapter = MediaAdapter(binatangModel.photo)
        itemView.media_layout.adapter = mediaAdapter

        mediaAdapter.setOnItemClickCallBack(object: MediaAdapter.OnItemClickCallback {
            override fun onItemClicked() {
                onItemClickCallback.onItemClicked(binatangModel)
            }
        })

//        if (itemView.media_layout.onFlingListener == null) {
  //      }
    }
}