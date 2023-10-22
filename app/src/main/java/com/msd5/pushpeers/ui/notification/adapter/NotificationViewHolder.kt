package com.msd5.pushpeers.ui.notification.adapter

import androidx.recyclerview.widget.RecyclerView
import com.msd5.pushpeers.databinding.ItemNotificationBinding
import com.msd5.pushpeers.ui.notification.model.Notification

class NotificationViewHolder(var binding: ItemNotificationBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(item: Notification) {
        item.run {
            binding.run {

            }
        }
    }

}