package com.example.provasub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import Entidade.Produto;

public class MainActivity extends AppCompatActivity {

    private EditText produtos, quantidades;
    private EditText datas;
    private ListView lista;

    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        produtos = (EditText) findViewById(R.id.cad_produto);
        quantidades = (EditText) findViewById(R.id.cad_quantidade);
        datas = (EditText) findViewById(R.id.cad_data);
        lista = (ListView) findViewById(R.id.cad_Lista);

        inicializarFirebase();
    }
    //Inicializar o FireBase
    public void inicializarFirebase(){
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override//Mudança de Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Salvar Dados no Firebase
    private void salvar(){
        Produto prod = new Produto();

        prod.setProduto(produtos.getText().toString());
        prod.setQuantidade(quantidades.getText().toString());
        prod.setData(datas.getText().toString());
        prod.setId(1);

        databaseReference.child("PRODUTO").child(prod.getId()+"").setValue(prod);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuNovo) {
            salvar();
        }
        return true;
    }

    //criação da Lista

}