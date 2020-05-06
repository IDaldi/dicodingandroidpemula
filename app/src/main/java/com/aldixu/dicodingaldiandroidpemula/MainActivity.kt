package com.aldixu.dicodingaldiandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata: RecyclerView
    private var list: ArrayList<Wisata> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "LIST WISATA"
        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)
        list.addAll(WisataInfo.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val ListWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = ListWisataAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, TentangAldi::class.java)
                startActivity(iAbout)
            }
        }
    }
}
