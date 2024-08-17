package com.hackafun.friendy2.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hackafun.friendy2.R;
import com.hackafun.friendy2.adapter.ChatAdapter;
import com.hackafun.friendy2.model.Chat;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Sample data
        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("John Doe", "Hey there!"));
        chatList.add(new Chat("Jane Smith", "How's it going?"));
        // Add more sample chats here...

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.chat_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChatAdapter adapter = new ChatAdapter(chatList, chat -> {
            Intent intent = new Intent(ChatActivity.this, ChatDetailActivity.class);
            // Pass chat information to ChatDetailActivity
            intent.putExtra("CHAT_NAME", chat.getName());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
