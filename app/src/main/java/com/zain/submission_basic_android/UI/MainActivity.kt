package com.zain.submission_basic_android.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.zain.submission_basic_android.Adapter.ListAgentAdapter
import com.zain.submission_basic_android.DataClass.DataAgentValorant
import com.zain.submission_basic_android.DataClass.ValorantAgent
import com.zain.submission_basic_android.R

class MainActivity : AppCompatActivity() {
 lateinit var rvAgent : RecyclerView
 private val list : ArrayList<ValorantAgent> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Valorant Agent"

        rvAgent = findViewById(R.id.rv_agent)
        rvAgent.setHasFixedSize(true)

        list.addAll(DataAgentValorant.listAgentVal)
//        list.addAll(getListAgent())
        rvAgent.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val listAgentAdapter = ListAgentAdapter(list)
        rvAgent.adapter = listAgentAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        goAbout(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun goAbout(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val goAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(goAbout)
            }
        }
    }


//    private fun getListAgent(): ArrayList<ValorantAgent>{
//        val dataName = resources.getStringArray(R.array.data_name)
//        val dataJenis = resources.getStringArray(R.array.jenis_agent)
//        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
//        val listAgentValorant = ArrayList<ValorantAgent>()
//        for (i in dataName.indices){
//            val agent = ValorantAgent(dataPhoto.getResourceId(i, -1), dataName[i], dataJenis[i] )
//            listAgentValorant.add(agent)
//        }
//        return listAgentValorant
//    }

}