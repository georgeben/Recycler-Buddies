package com.kurobarabenjamingeorge.recyclerbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BuddyListAdapter.BuddyListItemClickListener{

    private RecyclerView buddyList;
    private ArrayList<Buddy> buddies;
    private BuddyListAdapter adapter;

    private String[] buddyNames;
    private String[] buddyDesc;
    private int[] buddyImg = {R.drawable.bambie, R.drawable.bart, R.drawable.donald,
    R.drawable.goofy, R.drawable.homer, R.drawable.jerry, R.drawable.micky, R.drawable.simba,
    R.drawable.tom};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buddyNames = getResources().getStringArray(R.array.buddy_names);
        buddyDesc = getResources().getStringArray(R.array.buddy_desc);

        buddyList = (RecyclerView) findViewById(R.id.buddy_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        buddyList.setLayoutManager(layoutManager);
        buddyList.setHasFixedSize(true);

        buddies = new ArrayList<>();
        //buddies.add(new Buddy("Bambi", "Bambi is a boy", R.drawable.bart));
        for(int i = 0; i < buddyNames.length; i++){
            buddies.add(new Buddy(buddyNames[i], buddyDesc[i], buddyImg[i]));
            //Log.i("Image res", Integer.toString(buddyImg[i]));
        }

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
