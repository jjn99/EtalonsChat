package com.cours.etalonschat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cours.etalonschat.R
import com.cours.etalonschat.adapter.FriendsRecyclerAdapter
import com.cours.etalonschat.models.Friend
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    lateinit var listFriend: RecyclerView
    lateinit var fabChat: FloatingActionButton
    lateinit var friendsRecyclerAdapter: FriendsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        listFriend = findViewById(R.id.listFriend)
        fabChat = findViewById(R.id.fabChat)

        fabChat.setOnClickListener {
            Intent(this, UsersSearchActivity::class.java).also {
                startActivity(it)
            }
        }

        val friends = mutableListOf<Friend>(
            Friend("Bertrand Traore","Salut, tu viens ou pas","",4031431425),
            Friend("Alain Traore","Courage","",5865892),
            Friend("Malo Kambou","Salut, bonne chance","",4031431425)
        )

        friendsRecyclerAdapter = FriendsRecyclerAdapter()
        friendsRecyclerAdapter.items = friends
        listFriend.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = friendsRecyclerAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.itemSettings){
            Intent(this, SettingActivity::class.java).also {
                startActivity(it)
            }
        }
        if(item.itemId == R.id.itemLogout){
            Intent(this, AuthentificationActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}