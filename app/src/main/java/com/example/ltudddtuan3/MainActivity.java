package com.example.ltudddtuan3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    int image[] = {R.drawable.iphone, R.drawable.samsung, R.drawable.sony, R.drawable.xiaomi};
    String name[] = {"Điện thoại iphone", "Điện thoại samsung", "Điện thoại sony", "Điện thoại xiaomi"};
    ArrayList mylist;
    MyArrayAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        for (int i=0; i<name.length; i++ ){
            mylist.add(new Phone(image[i], name[i]));
        }
        myadapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, mylist);
        lv.setAdapter(myadapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}