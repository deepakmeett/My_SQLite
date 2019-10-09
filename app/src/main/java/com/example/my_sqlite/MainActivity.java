package com.example.my_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView1, textView2;
    Button button;

    Model model1;
    Database database1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        editText1 = findViewById( R.id.edit1 );
        editText2 = findViewById( R.id.edit2 );
        textView1 = findViewById( R.id.text1 );
        textView2 = findViewById( R.id.text2 );
        button = findViewById( R.id.bt );

        database1 = new Database( MainActivity.this );
        model1 = new Model();

        button.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class );
                startActivity( intent );
                return false;
            }
        } );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText1.getText().toString();
                String password = editText2.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText( getApplicationContext(), 
                                    "Please enter Email", Toast.LENGTH_SHORT ).show();
                } else if (password.isEmpty()) {
                    Toast.makeText( getApplicationContext(),
                                    "Please enter Password",Toast.LENGTH_SHORT ).show();
                }else {
                    model1.setEmail( email );
                    model1.setPassword( password );
                    database1.add_user_update_also( model1 );
                    
                        Toast.makeText( getApplicationContext(),
                                    "Registration Successfully",Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}
