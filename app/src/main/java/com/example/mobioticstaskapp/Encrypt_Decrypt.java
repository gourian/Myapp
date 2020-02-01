package com.example.mobioticstaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encrypt_Decrypt extends AppCompatActivity {
    Button btnsubmit;
    EditText editString;
    TextView textoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt__decrypt);
        btnsubmit = findViewById(R.id.btnsubmit);
        editString = findViewById(R.id.editString);
        textoutput = findViewById(R.id.textoutput);

        Intent mIntent = getIntent();
        final int intValue = mIntent.getIntExtra("intVariable", 0);
        if (intValue == 0) {
            Toast.makeText(getApplicationContext(), "Please select a valid button", Toast.LENGTH_SHORT).show();
        } else {
            if (intValue == R.id.btnEncrypt) {


                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = editString.getText().toString();
                        String s1 = encryptdata(s);

                        textoutput.setText(s1);

                    }
                });

            } else if (intValue == R.id.btnDecrypt) {
                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = editString.getText().toString();
                        String s1 = decryptdata(s);
                        //String str=String.valueOf(intValue);
                        textoutput.setText(s1);

                    }
                });

            }




            editString.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String TextString=editString.getText().toString();
                    btnsubmit.setEnabled(!TextString.isEmpty());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }


    }

    public static String encryptdata(String str) {

        final int MAX_CHAR = 256;
        int count[] = new int[MAX_CHAR];

        int len = str.length();
        String s1 = null;
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j])
                    find++;
            }
            s1 = str.charAt(i) + String.valueOf(count[str.charAt(i)]);
        }
        return s1;
    }


    public static String decryptdata(String str){

        {
            String expand = "";
            String temp = "";
            int freq = 0;
            for (int i=0; i < str.length() ; )
            {
                temp = "";
                freq = 0;
                while (i < str.length() && str.charAt(i)>='a'
                        && str.charAt(i)<='z')
                {
                    temp += str.charAt(i);
                    i++;
                }
                while (i < str.length() && str.charAt(i)>='1'
                        && str.charAt(i)<='9')
                {

                    freq = freq*10 + str.charAt(i) - '0';
                    i++;
                }
                for (int j=1; j<=freq; j++)
                    expand += temp;
            }
            if (freq==0)
                expand += temp;

            return expand;
        }



        }

    }
