package fpoly.khailnph29864.test_xth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recy;
ArrayList<Car> lst;
DAO dao;
Adapter adapter;
FloatingActionButton fl_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_add=findViewById(R.id.flAdd);
        recy=findViewById(R.id.recy);
        dao=new DAO(this);
        lst=dao.getAllData();
        adapter=new Adapter(lst,this);
        RecyclerView rc =findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rc.setLayoutManager(linearLayoutManager);
        recy.setAdapter(adapter);
        fl_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AddActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}