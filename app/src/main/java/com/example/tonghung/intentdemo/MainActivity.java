package com.example.tonghung.intentdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et;
    private Button btnCall, btnContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        btnCall = (Button) findViewById(R.id.buttonCall);
        btnContact = (Button) findViewById(R.id.buttonContacts);

        btnCall.setOnClickListener(this);
        btnContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnCall) {
            String number = et.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));
            startActivity(intent);
        }else if(view == btnContact){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")));
        }
    }
}
