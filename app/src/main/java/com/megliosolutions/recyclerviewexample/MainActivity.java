package com.megliosolutions.recyclerviewexample;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerViewAdapter adapter;
    public RecyclerView recyclerView;
    public List<Item> mItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItemsList = new ArrayList<Item>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        adapter = new RecyclerViewAdapter(mItemsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.addItem:
                addItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addItem() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy-hh-mm-ss");
        String date = simpleDateFormat.format(new Date());
        mItemsList.add(new Item(date));


        Log.i("Item: ", date);
        Log.i("Item Count: ", mItemsList.size()+"");
        adapter.notifyDataSetChanged();

    }
}
