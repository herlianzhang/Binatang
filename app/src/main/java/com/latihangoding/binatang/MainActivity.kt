package com.latihangoding.binatang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihangoding.binatang.About.AboutActivity
import com.latihangoding.binatang.Detail.DetailActivity
import com.latihangoding.binatang.Model.BinatangModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Binatang!!!"
        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode()
        return super.onOptionsItemSelected(item)
    }

    private fun setMode() {
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(aboutIntent)
    }

    private fun initView() {
        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        val binatangAdapter = ListBinatangAdapter()
        binatangAdapter.setBinatangList(generateDummyData())
        mainRecyclerView.adapter = binatangAdapter
        binatangAdapter.setOnItemClickCallBack(object : ListBinatangAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BinatangModel) {
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra(DetailActivity.BINATANG, data)
                startActivity(detailIntent)
            }
        })

    }

    private fun generateDummyData(): List<BinatangModel> {
        val listOfBinatang = mutableListOf<BinatangModel>()
        listOfBinatang.add(
            BinatangModel(
                "Anjing",
                intArrayOf(R.drawable.anjing, R.drawable.anjing2, R.drawable.anjing3),
                "anjing sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Babi",
                intArrayOf(R.drawable.babi),
                "babi sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Ayam",
                intArrayOf(R.drawable.ayam),
                "ayam sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Kuda",
                intArrayOf(R.drawable.kuda),
                "kuda sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Monyet",
                intArrayOf(R.drawable.monyet),
                "Monyet sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Kucing",
                intArrayOf(
                    R.drawable.kucing,
                    R.drawable.kucing2,
                    R.drawable.kucing3,
                    R.drawable.kucing4
                ),
                "Kucing sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel("Tikus", intArrayOf(R.drawable.tikus), "Tikus sekali")
        )
        listOfBinatang.add(
            BinatangModel(
                "Kancil",
                intArrayOf(R.drawable.kancil, R.drawable.kancil2),
                "Kancil sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Kelelawar",
                intArrayOf(R.drawable.kelelawar, R.drawable.kelelawar2),
                "Kelelawar sekali"
            )
        )
        listOfBinatang.add(
            BinatangModel(
                "Beruang",
                intArrayOf(R.drawable.beruang, R.drawable.beruang2),
                "Beruang sekali"
            )
        )

        return listOfBinatang.shuffled()
    }
}
