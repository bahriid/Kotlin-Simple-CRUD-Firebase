package com.modulbahri.crudapi.ModulRead

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.modulbahri.crudapi.Data
import com.modulbahri.crudapi.R

class Adapter (
    private var data: List<Data>,
    private val listener: (Data) -> Unit
)
: RecyclerView.Adapter<Adapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_data, parent, false)

        return LeagueViewHolder(inflatedView)
    }


    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)

    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nama: TextView = view.findViewById(R.id.nama)
        private val nohp: TextView = view.findViewById(R.id.nohp)
        private val alamat: TextView = view.findViewById(R.id.alamat)
        private val email: TextView = view.findViewById(R.id.email)
        private val token: TextView = view.findViewById(R.id.textView4)
        private val gambar: ImageView = view.findViewById(R.id.gambar)


        fun bindItem(data: Data, listener: (Data) -> Unit, context: Context, position: Int) {

            nama.text = data.nama
            nohp.text = data.nohp
            alamat.text = data.alamat
            email.text = data.email
            token.text = data.randomid
            token.setVisibility(View.INVISIBLE)


            Glide.with(context)
                .load(data.gambar)
                .into(gambar);

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }



}

