package com.example.myprt

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_PRT = "key_prt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val prt = intent.getParcelableExtra<PRT>("KEY_PRT")

        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvAge: TextView = findViewById(R.id.tv_detail_age)
        val tvRating: TextView = findViewById(R.id.tv_detail_rating)
        val tvResume: TextView = findViewById(R.id.tv_resume)

        prt?.let {
            imgPhoto.setImageResource(it.photo)
            tvName.text = it.name
            tvLocation.text = ": ${it.location}"
            tvAge.text = ": ${it.age}"
            tvRating.text = ": ${it.rating}"
            tvResume.text = it.resume
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                shareDetails()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun shareDetails() {
        val prt = intent.getParcelableExtra<PRT>("KEY_PRT")
        prt?.let {
            val shareText = "Informasi tentang ${it.name}: ${it.description}"
            val mimeType = "text/plain"

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = mimeType
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }
}