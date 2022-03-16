package app.mkv.map.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import app.mkv.map.R;

public class MainActivity extends AppCompatActivity {

    Button btn_line, btn_line_loc, btn_my_loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        buttonClick();

    }

    private void buttonClick() {
        btn_line.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, LineActivity.class));
        });
        btn_line_loc.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, LineLocActivity.class));
        });
        btn_my_loc.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MyLocActivity.class));
        });
    }

    private void initViews() {
        btn_line = findViewById(R.id.btn_line);
        btn_line_loc = findViewById(R.id.btn_line_loc);
        btn_my_loc = findViewById(R.id.btn_my_loc);
    }

}