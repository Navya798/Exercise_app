package com.example.minor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseAccess {
    private SQLiteOpenHelper openhelper;
    private SQLiteDatabase db;
    private static databaseAccess instances;
    Cursor c=null;

    public databaseAccess(Context context) {
        this.openhelper = new DatabaseOpenHelper(context);

    }
    //to return single instance of database
    public static databaseAccess getInstances(Context context){
        if(instances==null){
            instances=new databaseAccess(context);
        }
        return instances;
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //here you can migrate your data or just drop all tables

    }
    //to open database
    public void open(){


    }
    //to close database
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }
    //method to return names of exercise
    public Cursor getAccess(){
      this.db=openhelper.getReadableDatabase();
      String query="SELECT name from exercise";
      c=db.rawQuery(query,null);
      return c;
    }
    public String getsteps(String v){
        this.db=openhelper.getReadableDatabase();
       Cursor c=db.rawQuery("select step from exercise where name='"+v+"'",new String[]{});
       StringBuffer sf=new StringBuffer();
       while(c.moveToNext()){
          String st=c.getString(0);
          sf.append(st);

       }
       return sf.toString();
    }
    public String getbenf(String v){
        this.db=openhelper.getReadableDatabase();
        Cursor c=db.rawQuery("select benefit from exercise where name='"+v+"'",new String[]{});
        StringBuffer sf=new StringBuffer();
        while(c.moveToNext()){
            String st=c.getString(0);
            sf.append(st);

        }
        return sf.toString();
    }
    public String geturl(String v){
        this.db=openhelper.getReadableDatabase();
        Cursor c=db.rawQuery("select url from exercise where name='"+v+"'",new String[]{});
        StringBuffer sf=new StringBuffer();
        while(c.moveToNext()){
            String st=c.getString(0);
            sf.append(st);

        }
        return sf.toString();
    }
    public int getcal(String v,int col){
        this.db=openhelper.getReadableDatabase();
        Cursor c;
        if(col==0)
         c=db.rawQuery("select cal1 from exercise where name='"+v+"'",new String[]{});
        else if(col==1)
            c=db.rawQuery("select cal2 from exercise where name='"+v+"'",new String[]{});
        else
            c=db.rawQuery("select cal3 from exercise where name='"+v+"'",new String[]{});
        StringBuffer sf=new StringBuffer();
        while(c.moveToNext()){
            String st=c.getString(0);
            sf.append(st);

        }
        return (Integer.parseInt(sf.toString()));
    }
}
