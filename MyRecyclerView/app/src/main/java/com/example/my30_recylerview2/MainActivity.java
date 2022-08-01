package com.example.my30_recylerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Ctrl + p를 누르면 받아야할 매개 변수가 무엇인지 보여준다.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        final PersonAdapter adapter = new PersonAdapter();
        adapter.addItem(new PersonDTO("가수1", "010-1111-1111", R.drawable.singer1));
        adapter.addItem(new PersonDTO("가수2", "010-2222-2222", R.drawable.singer2));
        adapter.addItem(new PersonDTO("가수3", "010-3333-3333", R.drawable.singer3));
        adapter.addItem(new PersonDTO("가수4", "010-4444-4444", R.drawable.singer4));
        adapter.addItem(new PersonDTO("가수5", "010-5555-5555", R.drawable.singer5));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonDTOItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holderm, View view, int position) {
                PersonDTO item = adapter.getItem(position);

                Log.d(TAG, "onItemClick: " + item.getName());
            }
        });

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonDTO item = new PersonDTO("가수6", "010-6666-6666", R.mipmap.ic_launcher);
                adapter.addItem(item);

                adapter.notifyDataSetChanged();
            }
        });
    }
}