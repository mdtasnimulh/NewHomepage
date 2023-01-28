package com.tasnim.chowdhury.newhomepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class GuestUserActivity : AppCompatActivity() {

    private lateinit var guestUserSignInButton: Button

    private lateinit var guestUserHotJobsRecyclerView: RecyclerView
    private lateinit var guestUserHotJobsAdapter: GuestUserHotJobsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_user)

        // Guest User Hot Jobs Recycler View Initialization
        guestUserHotJobsRecyclerView = findViewById(R.id.guestUserHotJobsRV)
        guestUserHotJobsAdapter = GuestUserHotJobsAdapter()
        guestUserHotJobsRecyclerView.layoutManager = GridLayoutManager(this, 2)
        guestUserHotJobsRecyclerView.adapter = guestUserHotJobsAdapter

        guestUserHotJobsAdapter.onItemClick = { position ->
            val bottomSheetFragment = GuestUserBottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

        guestUserSignInButton = findViewById(R.id.guestUserSignInButton)
        guestUserSignInButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}