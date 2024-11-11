package com.example.registro_pacientes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PacienteAdapter extends ArrayAdapter<Paciente> {


    public PacienteAdapter(Context context, ArrayList<Paciente> pacientes) {
        super(context, 0, pacientes);
    }

    public PacienteAdapter(Activity_Listas context, ArrayList<Paciente> listaPaciente) {
        super(context, 0, listaPaciente);
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Paciente paciente = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_custon, parent, false);
        }

        TextView nombre = convertView.findViewById(R.id.textView2);
        TextView codigo = convertView.findViewById(R.id.textView3);

        nombre.setText(paciente.getNombre() + " " + paciente.getApellidoPaterno() + " " + paciente.getApellidoMaterno());
        codigo.setText(paciente.Codigo());


        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.parseColor("#FFA500"));
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }
}
