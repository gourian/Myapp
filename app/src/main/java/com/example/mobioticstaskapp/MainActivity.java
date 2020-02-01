package com.example.mobioticstaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button encrypt, decrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encrypt = findViewById(R.id.btnEncrypt);
        decrypt = findViewById(R.id.btnDecrypt);
        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnEncrypt) {
            Intent in = new Intent(MainActivity.this, Encrypt_Decrypt.class);
            in.putExtra("intVariable" ,v.getId());
            startActivity(in);

        } else {
            Intent in = new Intent(MainActivity.this, Encrypt_Decrypt.class);
            in.putExtra("intVariable" ,v.getId());
            startActivity(in);

        }
    }
}