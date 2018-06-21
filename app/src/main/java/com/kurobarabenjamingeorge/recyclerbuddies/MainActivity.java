package com.kurobarabenjamingeorge.recyclerbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BuddyListAdapter.BuddyListItemClickListener{

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

        adapter = new BuddyListAdapter(buddies, this, this);

        buddyList.setAdapter(adapter);
    }

    @Override
    public void OnBuddyImageClick(int position) {
        Toast.makeText(this, "Image "+position+" tapped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnBuddyTitleClick(int position) {
        Toast.makeText(this, "Title "+position+" tapped", Toast.LENGTH_SHORT).show();
    }
}
