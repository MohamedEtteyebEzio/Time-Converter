package com.example.timeconverter.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.timeconverter.R;
import com.example.timeconverter.controller.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 1;
    private EditText etSecondes;
    private Button btnConvertir;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnConvertir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               // boolean verif = false;
                if (etSecondes.getText().toString().isEmpty() ||( Long.parseLong(etSecondes.getText().toString())<0) )
                    Toast.makeText(MainActivity.this, "verfiee le Secondes ", Toast.LENGTH_SHORT).show();

               /* else if (secondes<0) {
                    Toast.makeText(MainActivity.this, "verfiee le Secondes Positive ", Toast.LENGTH_SHORT).show();
                    */else {
                    long secondes = Long.parseLong(etSecondes.getText().toString());
                    controller=Controller.getInstance();
                    controller.createTimeConvertion(secondes);
                    Intent intent =new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra( "TMP",controller.getTemps());
                    intent.putExtra( "SEC",String.valueOf(secondes));
                    startActivityForResult(intent,REQUEST_CODE);

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_CANCELED)
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    private void init()
    {
        etSecondes=(EditText)findViewById(R.id.etSecondes);
        btnConvertir=(Button) findViewById(R.id.btnConvertir);

    }
}