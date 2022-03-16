package app.mkv.map.Activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import app.mkv.map.R;

public class MyLocActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // starting app in full screen
        setContentView(R.layout.activity_my_loc);

    }


    private void initViews() {

    }


}