package com.example.minor;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class stepexe extends AppCompatActivity {
  private TextView tv,tv2;
  private Button bt;
  String ur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepexe);
        databaseAccess dbac=databaseAccess.getInstances(getApplicationContext());
        String name=getIntent().getStringExtra("exename");
        String step=dbac.getsteps(name);
        tv=(TextView)findViewById(R.id.textView3);
        tv.setText(step);
        String benf=dbac.getbenf(name);
        tv2=(TextView)findViewById(R.id.textView5);
        tv2.setText(benf);
         ur=dbac.geturl(name);
        //tv2.setText(ur);
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Toast.makeText(getApplicationContext(),ur,Toast.LENGTH_SHORT).show();
                Intent in=new Intent(Intent.ACTION_VIEW, Uri.parse(ur));
                startActivity(in); // Do something
            }
        });

        dbac.close();
    }

}
