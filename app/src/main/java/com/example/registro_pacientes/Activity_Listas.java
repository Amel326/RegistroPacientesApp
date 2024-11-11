package com.example.registro_pacientes;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Activity_Listas extends AppCompatActivity {

    ListView lista;

    ArrayList<Paciente> listaPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaPaciente = getIntent().<Paciente>getParcelableArrayListExtra("llave");

        if (listaPaciente != null) {

            lista = findViewById(R.id.lv_lista);

            PacienteAdapter adapter = new PacienteAdapter(this, listaPaciente);
            lista.setAdapter(adapter);
        }


    }
}