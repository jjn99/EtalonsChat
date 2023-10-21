package com.cours.etalonschat.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.cours.etalonschat.R
import com.cours.etalonschat.adapter.UserRecyclerAdapter
import com.cours.etalonschat.models.User

class UsersSearchActivity : AppCompatActivity() {

    lateinit var rvUsers: RecyclerView
    lateinit var editSearch:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_search)

        rvUsers = findViewById(R.id.rvUsers)
        editSearch = findViewById(R.id.editSearch)

        val users = mutableListOf<User>(
            User("aziz@gmail.com","Aziz KY",""),
            User("traorebr@gmail.com","Bertrand TRAORE",""),
            User("tabsoba@gmail.com","Edmond TABSOBA",""),
            User("dango@gmail.com","Dango OUATTARA",""),
            User("issakb@gmail.com","Issa KABORE",""),
            User("hervekf@gmail.com","Herve KOFFI",""),
            User("issoufoudy@gmail.com","Issoufou DAYO",""),
            User("kiliannk@gmail.com","Kilian NIKIEMA",""),
            User("lassinatr@gmail.com","Lassina TRAORE",""),
            User("blatitr@gmail.com","Blati TOURE","")

        )
        val userRecyclerAdapter = UserRecyclerAdapter()
        rvUsers.apply {
            layoutManager = LinearLayoutManager(this@UsersSearchActivity)
            adapter = userRecyclerAdapter
        }
        userRecyclerAdapter.items = users

        editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userRecyclerAdapter.filter.filter(s.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}