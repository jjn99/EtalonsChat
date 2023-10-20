package com.cours.etalonschat.activities

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cours.etalonschat.R
import com.cours.etalonschat.adapter.ChatRecyclerAdapter
import com.cours.etalonschat.models.Message
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatActivity : AppCompatActivity() {

    lateinit var fabSendMessage: FloatingActionButton
    lateinit var editMessage: EditText
    lateinit var rvChatList: RecyclerView

    lateinit var chatRecyclerAdapter:ChatRecyclerAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        rvChatList = findViewById(R.id.rvChatList)
        editMessage = findViewById(R.id.editMessage)
        fabSendMessage = findViewById(R.id.fabSendMessage)
        chatRecyclerAdapter = ChatRecyclerAdapter()

        val messages =  mutableListOf<Message>(
            Message(sender = "Edmond", receiver = "Bertrand Traore", text = "Salut", isReceived = false, timestamp = 12345789),
            Message(sender = "Bertrand Traore", receiver = "Edmond", text = "cava?", isReceived = true, timestamp = 12345789),
            Message(sender = "Edmond", receiver = "Bertrand Traore", text = "Bien et toi", isReceived = false, timestamp = 12345789),
            Message(sender = "Bertrand Traore", receiver = "Edmond", text = "Bien", isReceived = true, timestamp = 12345789),
            Message(sender = "Edmond", receiver = "Bertrand Traore", text = "Tu ne pourra pas y aller", isReceived = false, timestamp = 12345789),
            Message(sender = "Bertrand Traore", receiver = "Edmond", text = "Malheureusement non?", isReceived = true, timestamp = 12345789),
            Message(sender = "Edmond", receiver = "Bertrand Traore", text = "J'espere que ce n'es pas trop grave. Prompt ratablissement!!", isReceived = false, timestamp = 12345789),
            Message(sender = "Bertrand Traore", receiver = "Edmond", text = "Merci", isReceived = true, timestamp = 12345789)
        )

        fabSendMessage.setOnClickListener {
            //send message
            val message = editMessage.text.toString()
            if(message.isNotEmpty()){
                messages.add(
                    Message(sender = "Edmond", receiver = "Bertrand Traore", text = message, isReceived = false, timestamp = System.currentTimeMillis())
                )
                chatRecyclerAdapter.notifyDataSetChanged()
                editMessage.setText("")
                //hide keyboard
                val inputMethodeManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodeManager.hideSoftInputFromWindow(editMessage.windowToken,0)
            }
        }




        rvChatList.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = chatRecyclerAdapter
        }
        chatRecyclerAdapter.items = messages

    }
}