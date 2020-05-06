package com.aldixu.dicodingaldiandroidpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListWisataAdapter(val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_wisata, viewGroup,false )
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listWisata.size
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,location, photo, overview, identity) = listWisata[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvLocation.text = location
        val mContext = holder.itemView.context
        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailWisata::class.java)
            moveDetail.putExtra(DetailWisata.EXTRA_LOCATION, location)
            moveDetail.putExtra(DetailWisata.EXTRA_NAME, name)
            moveDetail.putExtra(DetailWisata.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailWisata.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(DetailWisata.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}