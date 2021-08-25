package com.sans_systems.consumingapidata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private TextView mPostTitle;
    private TextView mPostBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mPostTitle = findViewById(R.id.post_title_);
        mPostBody = findViewById(R.id.post_body_);

        String post_title = getIntent().getStringExtra("post_title");
        String post_body = getIntent().getStringExtra("post_body");

        mPostTitle.setText(post_title);
        mPostBody.setText(post_body);
    }
}