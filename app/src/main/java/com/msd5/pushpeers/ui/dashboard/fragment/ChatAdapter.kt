package com.msd5.pushpeers.ui.dashboard.fragment



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.msd5.pushpeers.databinding.SenderChatItemBinding

class ChatAdapter : RecyclerView.Adapter<ChatViewHolder>() {

    private lateinit var binding: SenderChatItemBinding

    var data: MutableList<ChatModel>? = arrayListOf()

    fun updateItems(newItems: List<ChatModel>?)
    {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = SenderChatItemBinding.inflate(inflater, parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        data?.get(position)?.let {
            holder.setData(it)
        }
    }

    override fun getItemCount(): Int = (data?.size) ?: 0

}