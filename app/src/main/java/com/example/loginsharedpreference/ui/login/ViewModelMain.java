package com.example.loginsharedpreference.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginsharedpreference.model.Usuario;
import  com.example.loginsharedpreference.request.ApiClient;

public class ViewModelMain extends AndroidViewModel {
    private Context context;
    private Usuario usuario;
    public  ViewModelMain(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
    }
    public boolean buscarUsuario(String mailB,String passwordB){
       usuario = ApiClient.login(context, mailB, passwordB);
       boolean rta=false;
       if(usuario!=null)rta=true;
     return  true;
    }


}
