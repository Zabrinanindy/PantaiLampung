package com.aplikasi.pantailampung

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PantaiListAdapter(private val PantaiList: ArrayList<Pantai>) : RecyclerView.Adapter<PantaiListAdapter.ListViewHolder>() {
    var onItemClick: ((Pantai) -> Unit)? = null

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvFoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val rvNama: TextView = itemView.findViewById(R.id.tv_item_name)
        val rvDeskripsi: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pantai_view, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = PantaiList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = PantaiList[position]
        holder.rvFoto.setImageResource(currentItem.foto)
        holder.rvNama.text = currentItem.nama
        holder.rvDeskripsi.text = currentItem.deskripsi
        holder.itemView.setOnClickListener { onItemClick?.invoke(currentItem) }
    }
}
