package com.example.aplicaciondialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnDialogYesNo;
    private Button btnDialogList;

    String [] Languages = {"Español","Ingles"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialogYesNo=findViewById(R.id.btnDialogYesNo);
        btnDialogList=findViewById(R.id.btnDialogList);

        btnDialogYesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        btnDialogList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogList();
            }
        });
    }



    private void openDialog(){
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage("¿Seguro que quieres salir de la aplicacion?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //System.out.println("Se ha ejecutado correctamente");

                        Log.d("CLICK", "Has clicado el boton Yes");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("CLICK", "Has clicado el boton No");
                    }
                })
                .show();
    }

    private void openDialogList() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Escoge un idioma");
        builder.setItems(Languages, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this,"Tu escogistes: "+Languages[i],Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}