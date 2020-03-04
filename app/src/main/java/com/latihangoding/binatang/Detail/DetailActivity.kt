package com.latihangoding.binatang.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.latihangoding.binatang.Media.MediaAdapter
import com.latihangoding.binatang.Model.BinatangModel
import com.latihangoding.binatang.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        var BINATANG = "binatang"
    }

    private lateinit var data: BinatangModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        data = intent.getSerializableExtra(BINATANG) as BinatangModel

        title = "Detail dari Binatang bernama ${data.name}"

        detail_media_layout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val detailAdapter = MediaAdapter(data.photo)
        detail_media_layout.adapter = detailAdapter

        PagerSnapHelper().attachToRecyclerView(detail_media_layout)

        detail_text.text = "Sepertinya anda mirip dengan ${data.name}"
    }
}
