package com.example.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button CreateDatabase = (Button)findViewById(R.id.create_database);
        Button addData = (Button)findViewById(R.id.add_data);
        Button updateDate = (Button)findViewById(R.id.update_data);
        Button deleteDate = (Button)findViewById(R.id.delete_data);
        Button queryData = (Button)findViewById(R.id.query_data);
        CreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });
        updateDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?","The Lost Symbol","Dan Brown");
            }
        });
        deleteDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"price < ?","15");
            }
        });
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for(Book book : books){
                    Log.d(TAG,"---------------------------------------");
                    Log.d(TAG,"book name is " + book.getName());
                    Log.d(TAG,"book author is " + book.getAuthor());
                    Log.d(TAG,"book page is " + book.getPages());
                    Log.d(TAG,"book price is " + book.getPrice());
                    Log.d(TAG,"book press is " + book.getPress());
                    Log.d(TAG,"---------------------------------------");
                }
                Book firstbook = LitePal.findFirst(Book.class);
                Book lastbook = LitePal.findLast(Book.class);
                Log.d(TAG,"---------------------------------------");
                Log.d(TAG,"book name is " + firstbook.getName());
                Log.d(TAG,"book author is " + firstbook.getAuthor());
                Log.d(TAG,"book page is " + firstbook.getPages());
                Log.d(TAG,"book price is " + firstbook.getPrice());
                Log.d(TAG,"book press is " + firstbook.getPress());
                Log.d(TAG,"---------------------------------------");
                Log.d(TAG,"---------------------------------------");
                Log.d(TAG,"book name is " + lastbook.getName());
                Log.d(TAG,"book author is " + lastbook.getAuthor());
                Log.d(TAG,"book page is " + lastbook.getPages());
                Log.d(TAG,"book price is " + lastbook.getPrice());
                Log.d(TAG,"book press is " + lastbook.getPress());
                Log.d(TAG,"---------------------------------------");
            }
        });
    }

}
