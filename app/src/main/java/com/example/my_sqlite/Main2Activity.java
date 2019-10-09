package com.example.my_sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    EditText editText3, editText4;
    TextView textView3, textView4;
    Button button1;

    Database database2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        editText3 = findViewById( R.id.ledit1 );
        editText4 = findViewById( R.id.ledit2 );
        textView3 = findViewById( R.id.ltext1 );
        textView4 = findViewById( R.id.ltext2 );
        button1 = findViewById( R.id.bt1 );

        database2 = new Database( Main2Activity.this );

        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText3.getText().toString();
                String password = editText4.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText( getApplicationContext(),
                                    "Please enter Email", Toast.LENGTH_SHORT ).show();
                } else if (password.isEmpty()) {
                    Toast.makeText( getApplicationContext(),
                                    "Please enter Password", Toast.LENGTH_SHORT ).show();
                } else {
                    boolean all = database2.checkUser( email, password );

                    if (all) {
                        Toast.makeText( Main2Activity.this,
                                        "Login Successfully", Toast.LENGTH_SHORT ).show();

                    } else {
                        Toast.makeText( Main2Activity.this,
                                        "Login Unsuccessfully", Toast.LENGTH_SHORT ).show();
                    }
                }
            }
        } );
    }
}
