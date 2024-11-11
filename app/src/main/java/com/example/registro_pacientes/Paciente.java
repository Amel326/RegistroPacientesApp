package com.example.registro_pacientes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Paciente implements Parcelable {
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String sexo;
    String codigoPaciente;
    String direccion;

    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, String codigoPaciente, String direccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.codigoPaciente = codigoPaciente;
        this.direccion = direccion;
    }

    protected Paciente(Parcel in) {
        nombre = in.readString();
        apellidoPaterno = in.readString();
        apellidoMaterno = in.readString();
        sexo = in.readString();
        codigoPaciente = in.readString();
        direccion = in.readString();
    }

    public static final Creator<Paciente> CREATOR = new Creator<Paciente>() {
        @Override
        public Paciente createFromParcel(Parcel in) {
            return new Paciente(in);
        }

        @Override
        public Paciente[] newArray(int size) {
            return new Paciente[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCodigoPaciente() {

        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String letra() {
        return getNombre().substring(0, 1).toUpperCase();
    }

    public String Codigo() {

        String inicialNombre = getNombre().substring(0, 1).toUpperCase();
        String inicialApellidoPaterno = getApellidoPaterno().substring(0, 1).toUpperCase();
        String inicialApellidoMaterno = getApellidoMaterno().substring(0, 1).toUpperCase();

        return inicialNombre + inicialApellidoPaterno + inicialApellidoMaterno+"_"+getCodigoPaciente();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidoPaterno);
        dest.writeString(apellidoMaterno);
        dest.writeString(sexo);
        dest.writeString(codigoPaciente);
        dest.writeString(direccion);
    }
}
