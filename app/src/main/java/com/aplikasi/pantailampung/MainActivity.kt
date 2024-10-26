package com.aplikasi.pantailampung

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvPantai: RecyclerView
    private lateinit var pantaiList : ArrayList <Pantai>
    private val list: ArrayList<Pantai> = ArrayList()
    private lateinit var myAdapter: PantaiListAdapter
    lateinit var detailFotoList: Array<Int>
    lateinit var detailDeskList: Array<String>

    private fun getPantaiList(): ArrayList<Pantai> {
        val dataNama = resources.getStringArray(R.array.data_namapantai)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsipantai)
        val dataFoto = resources.obtainTypedArray(R.array.data_fotopantai)
        val PantaiList = ArrayList<Pantai>()
        for (i in dataNama.indices) {
            val Pantai = Pantai(
                dataNama[i],
                dataDeskripsi[i],
                dataFoto.getResourceId(i, -1),
                dataNama[i],
                dataFoto.getResourceId(i, -1),
                dataDeskripsi[i]            )
            PantaiList.add(Pantai)
        }
        dataFoto.recycle()
        return PantaiList
    }

    private fun showRecyclerList() {
        rvPantai.layoutManager = LinearLayoutManager(this)
        myAdapter = PantaiListAdapter(pantaiList)
        rvPantai.adapter = myAdapter


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3600)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        detailFotoList = arrayOf(
            R.drawable.pantai_marina,
            R.drawable.sebalang,
            R.drawable.pasirputih,
            R.drawable.setigiheni,
            R.drawable.keduwarna,
            R.drawable.laguna,
            R.drawable.pahawang,
            R.drawable.gigihiu,
            R.drawable.kiluan,
            R.drawable.tanjungsetia,
            R.drawable.mutun,
            R.drawable.sariringgung,
            R.drawable.klara,
            R.drawable.labuhanjukung,
            R.drawable.batulapis,
        )

        detailDeskList = arrayOf(
            getString(R.string.marina),
            getString(R.string.sebalang),
            getString(R.string.pasirputih),
            getString(R.string.kedu),
            getString(R.string.laguna),
            getString(R.string.pahawang),
            getString(R.string.gigihiu),
            getString(R.string.kiluan),
            getString(R.string.tanjung),
            getString(R.string.mutun),
            getString(R.string.sari),
            getString(R.string.klara),
            getString(R.string.labuhan),
            getString(R.string.batulapis),
        )

        rvPantai = findViewById(R.id.rv_pantai)
        rvPantai.setHasFixedSize(true)

        pantaiList = getPantaiList()
        list.addAll(getPantaiList())
        showRecyclerList()

        myAdapter = PantaiListAdapter(pantaiList)
        rvPantai.adapter= myAdapter

        myAdapter.onItemClick= {
            val intent = Intent(this, detailActivity::class.java)
            intent.putExtra("EXTRA_PANTAI",it)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_about -> {
                val intent = Intent(this, AboutPage::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
