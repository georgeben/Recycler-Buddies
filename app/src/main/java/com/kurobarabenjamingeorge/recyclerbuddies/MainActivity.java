package com.kurobarabenjamingeorge.recyclerbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView buddyList;
    private ArrayList<Buddy> buddies;
    private BuddyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buddyList = (RecyclerView) findViewById(R.id.buddy_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        buddyList.setLayoutManager(layoutManager);
        buddyList.setHasFixedSize(true);

        buddies = new ArrayList<>();
        buddies.add(new Buddy("Bambi", "Bambi is a boy", R.drawable.bart));

        adapter = new BuddyListAdapter(buddies, this);

        buddyList.setAdapter(adapter);
    }
}
