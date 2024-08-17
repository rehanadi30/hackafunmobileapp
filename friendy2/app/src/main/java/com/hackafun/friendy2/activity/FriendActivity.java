package com.hackafun.friendy2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hackafun.friendy2.R;
import com.hackafun.friendy2.adapter.FriendAdapter;
import com.hackafun.friendy2.model.Friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 import com.squareup.picasso.Picasso; // If using Picasso

public class FriendActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FriendAdapter friendAdapter;
    private List<Friend> friendList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        // Initialize views
        ImageView mapIcon = findViewById(R.id.map_icon);
        recyclerView = findViewById(R.id.recycler_view);

        // Optionally, set up map icon click listener
        mapIcon.setOnClickListener(v -> {
            // Handle map icon click
            Intent intent = new Intent(FriendActivity.this, MapActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        // Initialize RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create or fetch friend list
        try {
            friendList = getFriendsList(); // Replace with your method to fetch friend data
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        friendAdapter = new FriendAdapter(friendList);
        recyclerView.setAdapter(friendAdapter);
    }

    private List<Friend> getFriendsList() throws ParseException {
        // Replace with your actual data fetching logic
        List<Friend> friends = new ArrayList<>();
        // Example data
        String dateString1 = "17/08/2024";
        String dateString2 = "16/08/2024";
        friends.add(new Friend(1, "Anna Gan", dateString1, 88, "https://media.licdn.com/dms/image/D5603AQEi1ewbgZHzJg/profile-displayphoto-shrink_400_400/0/1722332667738?e=1729123200&v=beta&t=0kBYFsFQszkTwFUNqs6PYbw1BPy8HxQtMk-9NWDwidk"));
        friends.add(new Friend(2, "Lo Xian Wan", dateString2, 34, "https://media.licdn.com/dms/image/v2/D4E35AQETt3dCJXZHMw/profile-framedphoto-shrink_400_400/profile-framedphoto-shrink_400_400/0/1723567397429?e=1724486400&v=beta&t=sUCFYA1j3IH9P1sKaGqcE0_lPrSAkFoyRMtLbzzTTew"));
        // Add more friends
        return friends;
    }
}
