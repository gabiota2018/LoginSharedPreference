package com.example.loginsharedpreference.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private  String dni;
    private  String apellido;
    private  String nombre;
    private  String mail;
    private  String password;

    public Usuario() { }

    public Usuario(String dni, String apellido, String nombre, String mail, String password) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}' ;
    }

    public List<Usuario> listar() {
        List<Usuario> listado = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        usuario.dni = "10100100";
        usuario.nombre = "ana";
        usuario.apellido = "acosta";
        usuario.mail = "a";//"ana@gmail.com";
        usuario.password = "a";//"111";
        listado.add(usuario);



        return listado;
    }
    public  boolean logueo(String mail, String password){
        boolean rta=false;
        List<Usuario> listado = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        listado=usuario.listar();
        for(Usuario p:listado)
        {
            if(p.mail.equals(mail) && p.password.equals(password))
                rta=true;
        }
        return  rta;
    }
    public  Usuario devolverUsuario(String mail){
        List<Usuario> listado = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        listado=usuario.listar();
        for(Usuario p:listado)
        {
            if(p.mail.equals(mail))
                usuario=p;
        }
        return  usuario;
    }
}
