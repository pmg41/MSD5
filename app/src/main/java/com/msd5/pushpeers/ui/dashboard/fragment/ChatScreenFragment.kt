package com.msd5.pushpeers.ui.dashboard.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.msd5.pushpeers.databinding.FragmentChatScreenBinding

class ChatScreen : Fragment() {

    var chats: MutableList<ChatModel> = ArrayList()
    var binding: FragmentChatScreenBinding? = null
    var isSending = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentChatScreenBinding.inflate(layoutInflater)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var chatModel1: ChatModel = ChatModel()
        chatModel1.text = "Hello"
        chatModel1.isSender = true
        chats.add(chatModel1)

        var chatModel2: ChatModel = ChatModel()
        chatModel2.text = "Hi"
        chatModel2.isSender = false
        chats.add(chatModel2)

        var chatModel3: ChatModel = ChatModel()
        chatModel3.text = "How are you?"
        chatModel3.isSender = true
        chats.add(chatModel3)

        var chatModel4: ChatModel = ChatModel()
        chatModel4.text = "Good! How are you?"
        chatModel4.isSender = false
        chats.add(chatModel4)

        var chatModel5: ChatModel = ChatModel()
        chatModel5.text = "I am good too!"
        chatModel5.isSender = true
        chats.add(chatModel5)

        var chatAdapter = ChatAdapter()
        chatAdapter.data = chats

        binding!!.recyclerView.adapter = chatAdapter


        binding!!.sendBtn.setOnClickListener(View.OnClickListener {
            if (!binding!!.messageEt.text.equals("")) {

//                chatAdapter.data!!.clear()
                var chatModel6 = ChatModel()
                chatModel6.text = binding!!.messageEt.text.toString()
                chatModel6.isSender = false
                chats.add(chatModel6)

//                chatAdapter.data = chats
                chatAdapter.notifyItemInserted(chats.count())

                binding!!.messageEt.setText("")
            }
        })
    }
}