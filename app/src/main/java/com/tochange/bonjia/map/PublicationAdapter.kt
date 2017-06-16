package com.tochange.bonjia.map

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tochange.bonjia.R
import com.tochange.bonjia.entity.Publication
import com.tochange.bonjia.utils.loadUrl
import kotlinx.android.synthetic.main.item_publication.view.*

/**
 * Created by juanfrancisco on 10-06-17.
 */
class PublicationAdapter(var c: Context, var publications: List<Publication>): RecyclerView.Adapter<PublicationAdapter.Item>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Item {
        var v = LayoutInflater.from(c).inflate(R.layout.item_publication, parent, false)
        return Item(v)
    }

    override fun getItemCount(): Int {
        return publications.size
    }

    override fun onBindViewHolder(holder: Item, position: Int) {
        holder.bindData(publications[holder.adapterPosition])
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(publication: Publication) {
            itemView.vUser.text = publication.user
            itemView.vDate.text = "hace 5 minutos"
            itemView.vPhoto.loadUrl(publication.photo)
        }
    }
}

//var pico : String = ""
//set(value) { field = value.toUpperCase() }