package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static int ADD_REQUEST_CODE=100;
    private Button btn1, btn2,btn3 ,btn4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.this, HomeActivity.class );
                Intent intent = new Intent(MainActivity.this, SoldCurentActivity.class );
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });

        btn2 = findViewById(R.id.bt_TransactionsActivity);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.this, HomeActivity.class );
                Intent intent = new Intent(MainActivity.this, TransactionsActivity.class );
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });
        btn3 = findViewById(R.id.bt_statistics);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.this, HomeActivity.class );
                Intent intent = new Intent(MainActivity.this, StatisticsActivity.class );
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });

//        btn4 = findViewById(R.id.bt_sold);
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SoldCurentActivity.class );
//                startActivityForResult(intent, ADD_REQUEST_CODE);
//            }
//        });

    }


}
