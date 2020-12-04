package com.example.provasub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText produtos, quantidades;
    private EditText datas;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtos = (EditText) findViewById(R.id.cad_produto);
        quantidades = (EditText) findViewById(R.id.cad_quantidade);
        datas = (EditText) findViewById(R.id.cad_data);
    }

    @Override//Mudança de Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}