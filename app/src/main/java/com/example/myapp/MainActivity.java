package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    final int COLOR_RED = 1;
    final int COLOR_GREEN = 2;
    final int COLOR_BLUE = 3;
    final int SIZE_16 = 4;
    final int SIZE_20 = 5;
    final int SIZE_26 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);

        registerForContextMenu(tv1);
        registerForContextMenu(tv2);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        int res = v.getId();
        if (res == R.id.textView) getMenuInflater().inflate(R.menu.context_menu_color, menu);
        else if (res == R.id.textView2) getMenuInflater().inflate(R.menu.context_menu_size, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int res = item.getItemId();

        if (res == R.id.color_red) {
            tv1.setTextColor(Color.RED);
            tv1.setText("Text color red");
        }
        else if (res == R.id.color_green) {
            tv1.setTextColor(Color.GREEN);
            tv1.setText("Text color green");
        }
        else if (res == R.id.color_blue) {
            tv1.setTextColor(Color.BLUE);
            tv1.setText("Text color blue");
        }
        else if (res == R.id.text_size_20) {
            tv2.setTextSize(20);
            tv2.setText("Text size 20");
        }
        else if (res == R.id.text_size_26) {
            tv2.setTextSize(26);
            tv2.setText("Text size 26");
        }
        else if (res == R.id.text_size_30) {
            tv2.setTextSize(30);
            tv2.setText("Text size 30");
        }
        return super.onContextItemSelected(item);
    }
}