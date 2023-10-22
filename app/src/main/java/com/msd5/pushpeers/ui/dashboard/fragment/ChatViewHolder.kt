package com.msd5.pushpeers.ui.dashboard.fragment


import android.view.View
import androidx.recyclerview.widget.RecyclerView

import com.msd5.pushpeers.databinding.SenderChatItemBinding

class ChatViewHolder(var binding: SenderChatItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setData(item: ChatModel) {
        item.run {
            binding.run {
                receiverLayout.visibility = View.GONE
                senderLayout.visibility = View.GONE

                if (item.isSender) {
                    //sender
                    senderLayout.visibility = View.VISIBLE
                    messageText.text = item.text
                } else {
                    //receiver
                    receiverLayout.visibility = View.VISIBLE
                    messageTextReceiver.text = item.text

                }
            }
        }
    }

}