package com.mandiri.recyclerview2_induksi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mandiri.recyclerview2_induksi.databinding.AlbumCardBinding

class AlbumAdapter(private var albums: List<Album>): RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(val recyclerBinding: AlbumCardBinding): RecyclerView.ViewHolder(recyclerBinding.root) {
        var albumImage = recyclerBinding.ivPhoto
        var albumName = recyclerBinding.tvAlbumName
        var albumYear = recyclerBinding.tvAlbumYear
    }

    // bikin viewholder -> dia itu nangkep satu card tersebut. di-hold sama mereka, mereka mengantongi . balikannya adalah item view holder.
    // view = view class, xml itu satu class tersendiri. yang dipake di view
    // view group = dia nampung view-nya. jadi dia di atasnya. satu layar itu view group
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(AlbumCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]

        val albumImageUrl = album.image
        Log.d("Image URL: ", albumImageUrl)

        holder.albumName.text = album.name
        holder.albumYear.text = album.year
        Glide.with(holder.albumImage)
            .load(albumImageUrl)
            .into(holder.albumImage)
    }


}