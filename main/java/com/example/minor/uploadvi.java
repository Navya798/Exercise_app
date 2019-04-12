package com.example.minor;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class uploadvi extends AppCompatActivity {
   //String[] listitem= {"hello", "hi"};
   ArrayList<String> listitem=new ArrayList<String>();
   ArrayAdapter<String> adapter;
   ListView userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadvi);
        userlist=(ListView)findViewById(R.id.user);
        databaseAccess dbac=databaseAccess.getInstances(getApplicationContext());
        Cursor c=dbac.getAccess();
        while(c.moveToNext()){
            listitem.add(c.getString(0));

        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listitem);
        userlist.setAdapter(adapter);
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
               // Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(uploadvi.this,stepexe.class);
                i.putExtra("exename",value);
                startActivity(i);

            }
        });



    }
}
