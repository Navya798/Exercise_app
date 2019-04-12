package com.example.minor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc extends AppCompatActivity {
  private EditText et1,et2,et3;
  private TextView tv;
  private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        final databaseAccess dbac=databaseAccess.getInstances(getApplicationContext());
        et1=(EditText)findViewById(R.id.editText7);
        et2=(EditText)findViewById(R.id.editText5);
        et3=(EditText)findViewById(R.id.editText6);
        tv=(TextView)findViewById(R.id.textView6);
        bt=(Button)findViewById(R.id.button3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {   String exname=et1.getText().toString();
                String wei=et2.getText().toString();
                int we=Integer.valueOf(wei);
                String ti=et3.getText().toString();
                int t=Integer.parseInt(ti);
                int c1=0;
                if(we<=57)
                    c1=0;
                else if(we>57 && we<=70)
                    c1=1;
                else
                    c1=2;
                int calorie=dbac.getcal(exname,c1);
                calorie=calorie*(t/30);
                tv.setText("Total Calorie Burned: "+Integer.toString(calorie));

            }
        });

    }
}
