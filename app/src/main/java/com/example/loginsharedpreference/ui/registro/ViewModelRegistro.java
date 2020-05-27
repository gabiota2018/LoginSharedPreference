package com.example.loginsharedpreference.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginsharedpreference.model.Usuario;
import  com.example.loginsharedpreference.request.ApiClient;
import com.example.loginsharedpreference.ui.login.MainActivity;


public class ViewModelRegistro extends ViewModel {
    private Context context;
    private MutableLiveData<String> dni;
    private MutableLiveData<String> apellido;
    private MutableLiveData<String> nombre;
    private MutableLiveData<String> mail;
    private MutableLiveData<String> password;
    private MutableLiveData<Usuario> usuario;

   public LiveData<String> getDni() {
        if(dni==null){
            dni=new MutableLiveData<>();
        }
        return dni;
    }

    public LiveData<String> getApellido() {
        if(apellido==null){
            apellido=new MutableLiveData<>();
        }
        return apellido;
    }
    public LiveData<String> getNombre() {
        if(nombre==null){
            nombre=new MutableLiveData<>();
        }
        return nombre;
    }
   public LiveData<String> getMail() {
        if(mail==null){
            mail=new MutableLiveData<>();
        }
        return mail;
    }
    public LiveData<String> getPassword() {
        if(password==null){
            password=new MutableLiveData<>();
        }
        return password;
    }
    public LiveData<Usuario> getUsuario() {
        if(usuario==null){
            usuario=new MutableLiveData<>();
        }
        return usuario;
    }
    public  void guardar(Usuario miUsuario){
       ApiClient.guardar(context,miUsuario);
        nombre.setValue(miUsuario.getNombre());
        apellido.setValue(miUsuario.getApellido());
        dni.setValue(miUsuario.getDni());
        mail.setValue(miUsuario.getMail());
        password.setValue(miUsuario.getPassword());
       Intent i= new Intent(context,MainActivity.class);
       context.startActivity(i);
    }


}
