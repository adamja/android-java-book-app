package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        RecyclerView recView = findViewById(R.id.favouriteRecView);
        BookRecViewAdapter adapter = new BookRecViewAdapter(this, "favourite");
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getInstance(this).getFavouriteBooks());
    }

    @Override
    public void onBackPressed() {
        // When the back button is press navigate back to the home screen
        Intent intent = new Intent(this, MainActivity.class);

        // Clear the back stack and define this intent as a new task
        // This means that when back is selected from this screen it will treat the back logic
        // as if the app has just opened for the first time
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}