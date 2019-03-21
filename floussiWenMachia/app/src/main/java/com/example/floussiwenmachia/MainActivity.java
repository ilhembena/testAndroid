package com.example.floussiwenmachia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mylist ;
    ArrayList<NewMasrouf> masroufs ;
   DBAdapter dbAdaptor ;
    // ArrayList<NewMasrouf> myarraylist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = findViewById(R.id.listview);

       // myarraylist =new ArrayList<>();
        masroufs = new ArrayList<NewMasrouf>();
        dbAdaptor = new DBAdapter(this);
        masroufs=dbAdaptor.afficher();

         MasroufAdapter masroufAdapter = new MasroufAdapter( this , R.layout.masrouf_item_1, masroufs);
       mylist.setAdapter(masroufAdapter);



     mylist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
            adb.setTitle("Delete?");
            adb.setMessage("Are you sure you want to delete ");

            adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dbAdaptor.remove(masroufs.get(position).getId());
                    masroufs=dbAdaptor.afficher();

                    MasroufAdapter masroufAdapter = new MasroufAdapter(MainActivity.this,R.layout.masrouf_item_1,masroufs );
                    mylist.setAdapter(masroufAdapter);

                }});

            adb.setNegativeButton("cancel", null);
            adb.setIcon(android.R.drawable.ic_dialog_alert);
            adb.show();

        }
    });}

    @Override
    protected void onResume() {
        super.onResume();
        masroufs=dbAdaptor.afficher();

        MasroufAdapter masroufAdapter = new MasroufAdapter( this , R.layout.masrouf_item_1, masroufs);
        mylist.setAdapter(masroufAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.ajout,menu);
        getMenuInflater().inflate(R.menu.total,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);

        if(item.getItemId()==R.id.ajout){
            Intent intent = new Intent( MainActivity.this ,addMasrouf.class);
            startActivity(intent);

            return true;
        }
        if(item.getItemId()==R.id.total){
            String S = Sum().toString();
            String dte;
            if (masroufs.size()!=0){
                dte = masroufs.get(0).getDate().toString();
            }
            else { dte = "null ";}
            //String dte = depences.get(0).getDate().toString();
            Intent intent = new Intent( MainActivity.this ,TotalMasrouf.class);
            intent.putExtra("somme",S);
            intent.putExtra("date",dte);
            startActivity(intent);}
        return true;


    }
    public Float Sum (){
        Float somme = 0f ;
        if ( masroufs.size()!=0){


            for ( int i =0 ; i < masroufs.size() ; i++){
                somme=somme+masroufs.get(i).getValeur();
            } return somme ;}
        else return somme ;
    }}
