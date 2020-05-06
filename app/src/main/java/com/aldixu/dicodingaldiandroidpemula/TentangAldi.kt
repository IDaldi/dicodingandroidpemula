package com.aldixu.dicodingaldiandroidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TentangAldi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)
        val actionbar = supportActionBar
        actionbar!!.title = "TentangKu"
        actionbar.setDisplayHomeAsUpEnabled(true)
        val imgMe: ImageView = findViewById(R.id.foto)
        val tImg = "https://www.dicoding.com/images/small/avatar/20181001084419d11b3e1b6f5c40383f9add1e62cc34df.jpg"
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
