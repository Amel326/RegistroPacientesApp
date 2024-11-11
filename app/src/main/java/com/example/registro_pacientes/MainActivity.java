package com.example.registro_pacientes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText Nombre,ApellidoPaterno,ApellidoMaterno,CodigoPaciente,Direccion;
    RadioGroup radioGroupSexo;
    Button buttonRegistrar,buttonLista;

    ArrayList <Paciente> listaPacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Nombre = findViewById(R.id.editTextNombre);
        ApellidoPaterno = findViewById(R.id.editTextApellidoPaterno);
        ApellidoMaterno = findViewById(R.id.editTextApellidoMaterno);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        CodigoPaciente = findViewById(R.id.editTextCodigoPaciente);
        Direccion = findViewById(R.id.editTextDireccion);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);
        buttonLista = findViewById(R.id.buttonLista);

        listaPacientes = new ArrayList<Paciente>();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void REGISTRAR(View v){

        String nombre = Nombre.getText().toString();
        String apellidoPaterno = ApellidoPaterno.getText().toString();
        String apellidoMaterno = ApellidoMaterno.getText().toString();
        int selectedSexoId = radioGroupSexo.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedSexoId);
        String sexo = selectedRadioButton.getText().toString();
        String codigoPaciente = CodigoPaciente.getText().toString();
        String direccion = Direccion.getText().toString();

        Paciente nuevoPaciente = new Paciente(nombre, apellidoPaterno, apellidoMaterno, sexo, codigoPaciente, direccion);
        listaPacientes.add(nuevoPaciente);
    }

    public void LISTAS(View v){

        Collections.sort(listaPacientes, (p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));

        Intent it = new Intent(MainActivity.this, Activity_Listas.class);
        it.putParcelableArrayListExtra("llave", (ArrayList<? extends Parcelable>) listaPacientes);
        startActivity(it);
    }
}