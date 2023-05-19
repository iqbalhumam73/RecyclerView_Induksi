package com.mandiri.recyclerview2_induksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.recyclerview2_induksi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var albumRecyclerView: RecyclerView
    lateinit var albumAdapter: AlbumAdapter
    private var albumList = mutableListOf<Album>()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        //initiate list
        val addAlbum = listOf<Album>(
            Album("https://cms.disway.id/uploads/fb145051b01d30d1e98d694c62052302.jpeg", "Speak Now (Taylor's Version", "2023"),
            Album("https://lh3.googleusercontent.com/YT8q7RwmbNVf7EcjSii-T5vm7FZI7_mSb_KYvhfKqvKRWdCTB-mzr2jLZCPwYqER3wHFXhuEQKTKmUCJ=w544-h544-l90-rj", "Midnights (3am Edition)", "2022"),
            Album("https://lh3.googleusercontent.com/YT8q7RwmbNVf7EcjSii-T5vm7FZI7_mSb_KYvhfKqvKRWdCTB-mzr2jLZCPwYqER3wHFXhuEQKTKmUCJ=w544-h544-l90-rj", "Midnights", "2022"),
            Album("https://upload.wikimedia.org/wikipedia/id/4/47/Taylor_Swift_-_Red_%28Taylor%27s_Version%29.png", "Red (Taylor's Version)", "2022"),
            Album("https://i.scdn.co/image/ab67616d0000b273a48964b5d9a3d6968ae3e0de", "Fearless (Taylor's Version)", "2021"),
            Album("https://upload.wikimedia.org/wikipedia/id/0/0a/Taylor_Swift_-_Evermore.png", "evermore", "2020"),
            Album("https://upload.wikimedia.org/wikipedia/id/thumb/4/4e/Folklore-_The_Long_Pond_Studio_Sessions_Album.jpg/220px-Folklore-_The_Long_Pond_Studio_Sessions_Album.jpg", "folklore: the long pond", "2020"),
            Album("https://upload.wikimedia.org/wikipedia/id/f/f8/Taylor_Swift_-_Folklore.png", "folklore", "2020"),
            Album("https://upload.wikimedia.org/wikipedia/id/c/cd/Taylor_Swift_-_Lover.png", "Lover", "2019"),
            Album("https://upload.wikimedia.org/wikipedia/id/f/f2/Taylor_Swift_-_Reputation.png", "Reputation Stadium Tour", "2017"),
            Album("https://upload.wikimedia.org/wikipedia/id/f/f2/Taylor_Swift_-_Reputation.png", "Reputation", "2017"),
            Album("https://pyxis.nymag.com/v1/imgs/5a1/58c/580de90bf142c7660dcbaf8faa789a61b1-20-taylor-swift-1989.2x.w710.png", "1989", "2014"),
            Album("https://i1.sndcdn.com/artworks-000108296031-w17bak-t500x500.jpg", "Red", "2012"),
            Album("https://upload.wikimedia.org/wikipedia/id/8/8f/Taylor_Swift_-_Speak_Now_cover.png", "Speak Now", "2010"),
            Album("https://m.media-amazon.com/images/I/71Ut3fJWopL._UF1000,1000_QL80_.jpg", "Fearless", "2008"),
            Album("https://people.com/thmb/-CFk2SUsPbgYeOcrtvMGO35IWOc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(999x0:1001x2)/taylor-swift-albums-1-93026ca98408417097660e117a10a6a9.jpg", "Taylor Swift", "2006")
            )
        albumList.addAll(addAlbum)

        //init UI
        albumRecyclerView = binding.rvContent
        val layoutManager = LinearLayoutManager(baseContext)
        albumRecyclerView.layoutManager = layoutManager

        //subscribe
        albumAdapter = AlbumAdapter(albumList)
        albumRecyclerView.adapter = albumAdapter

        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener(){
                if (etAlbumImageLink.text.isNotEmpty() && etAlbumName.text.isNotEmpty() && etAlbumYear.text.isNotEmpty()){
                    albumList.add(Album(etAlbumImageLink.text.toString(), etAlbumName.text.toString(), etAlbumYear.text.toString()))
                    albumAdapter.notifyItemInserted(albumList.size-1)
                    Toast.makeText(this@MainActivity,
                        etAlbumName.text.toString() + " album successfully added",
                        Toast.LENGTH_SHORT).show()

                    etAlbumName.text.clear()
                    etAlbumYear.text.clear()
                    etAlbumImageLink.text.clear()
                }
                else {
                    Toast.makeText(this@MainActivity,
                        "Lengkapin dulu bg",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}