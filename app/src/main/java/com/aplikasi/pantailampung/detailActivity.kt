package com.aplikasi.pantailampung

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class detailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val shareButton: Button = findViewById(R.id.action_share)
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Ini adalah teks yang ingin dibagikan.")
                type = "text/plain" }
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }

        val pantai = intent.getParcelableExtra<Pantai>("EXTRA_PANTAI")

        if (pantai !=null){
            val detailNama = findViewById<TextView>(R.id.detail_nama)
            val detailFoto = findViewById<ImageView>(R.id.detail_foto)
            val detailDesk = findViewById<TextView>(R.id.detail_deskripsi)

            detailNama.text = pantai.nama
            detailFoto.setImageResource(pantai.foto)
            detailDesk.text = pantai.detailDesk
        }
    }
}