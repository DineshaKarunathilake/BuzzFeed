package me.projects.buzzfeed.ui

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.teaser.view.*
import me.projects.buzzfeed.R
import me.projects.buzzfeed.data.Teaser

class TeaserAdapter(private var listItems: List<Teaser>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val PAID_CONTENT = "paid content"
    val FREE_CONTENT = "free content"

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataItem = listItems[position]

        if (holder is ItemViewHolder) {
            holder.setTextFields(dataItem)
            holder.itemView.setOnClickListener {
                holder.updateOnClick(dataItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.teaser,
                parent,
                false
            )

        return ItemViewHolder(v)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var teaserTitle = itemView.teaserTitle
        private var teaserText = itemView.teaserText
        private var paidOrFreeStatus = itemView.paidOrFreeStatusText
        private var buySubscriptionText = itemView.buySubscriptionText

        fun setTextFields(item: Teaser) {
            this.teaserTitle.text = item.title
            this.teaserText.text = item.text
        }

        fun updateOnClick(item: Teaser) {

            this.paidOrFreeStatus.visibility = View.VISIBLE

            when {
                item.isPaid -> {
                    this.paidOrFreeStatus.text = PAID_CONTENT
                    this.buySubscriptionText.visibility = View.VISIBLE
                }
                else -> this.paidOrFreeStatus.text = FREE_CONTENT
            }

        }


    }

}