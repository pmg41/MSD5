package com.msd5.pushpeers.ui.notification.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.msd5.pushpeers.databinding.ItemNotificationBinding
import com.msd5.pushpeers.ui.notification.model.Notification

class NotificationAdapter : RecyclerView.Adapter<NotificationViewHolder>() {

    private lateinit var binding: ItemNotificationBinding

    var data: MutableList<Notification>? = arrayListOf()

    fun updateItems(newItems: List<Notification>?) {
        val oldItems = ArrayList(this.data!!)
        this.data!!.clear()
        if (newItems != null) {
            this.data!!.addAll(newItems)
        }
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return oldItems.size
            }

            override fun getNewListSize(): Int {
                return data!!.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldItems[oldItemPosition] == newItems!![newItemPosition]
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldItems[oldItemPosition] == newItems!![newItemPosition]
            }
        }).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemNotificationBinding.inflate(inflater, parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        data?.get(position)?.let {
            holder.setData(it)
        }
    }

    override fun getItemCount(): Int = (data?.size) ?: 0

}