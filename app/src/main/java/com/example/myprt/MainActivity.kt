package com.example.myprt

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPRT: RecyclerView
    private val list = ArrayList<PRT>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPRT = findViewById(R.id.myPRT)
        rvPRT.setHasFixedSize(true)

        list.addAll(getListPRT())
        showRecyclerList()
    }

    private fun getListPRT(): ArrayList<PRT> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataResume = resources.getStringArray(R.array.data_resume)
        val listPRT = ArrayList<PRT>()
        for (i in dataName.indices) {
            val prt = PRT(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataResume[i])
            listPRT.add(prt)
        }
        return listPRT
    }

    private fun showRecyclerList() {
        rvPRT.layoutManager = LinearLayoutManager(this)
        val listPRTAdapter = ListPrtAdapter(list)
        rvPRT.adapter = listPRTAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intentAbout = Intent(this, AboutActivity::class.java)
                startActivity(intentAbout)
                return true
            }
            // Handle other menu items if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }
}