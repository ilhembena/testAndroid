package com.example.floussiwenmachia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class addMasrouf extends AppCompatActivity {

    Button b ;
    EditText E1 ;
    EditText E2,E3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DBAdapter dbAdapter = new DBAdapter(this);
        setContentView(R.layout.activity_add_masrouf);
        b = findViewById(R.id.btn);
        E1 = findViewById(R.id.edt1);
        E2 = findViewById(R.id.edt2);
        E3 = findViewById(R.id.edt3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String depense = E1.getText().toString();
               // String date = E2.getText().toString();

                Float valeur = Float.valueOf(E3.getText().toString());
                NewMasrouf masrouf = new NewMasrouf(depense,valeur);


                dbAdapter.ajoutdepense(masrouf);
               // masroufs=dbAdaptor.afficher();
              //  Toast.makeText(addMasrouf.this, masroufs.get(0).getDepense(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(addMasrouf.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
