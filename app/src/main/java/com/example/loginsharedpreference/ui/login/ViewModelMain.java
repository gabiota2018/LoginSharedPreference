package com.example.loginsharedpreference.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginsharedpreference.model.Usuario;
import  com.example.loginsharedpreference.request.ApiClient;

public class ViewModelMain extends AndroidViewModel {
    private Context context;
    public  ViewModelMain(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
    }
    public Boolean buscarUsuario(String mailB,String passwordB){
        Usuario usu=new Usuario("30400500","perez","ana","a","123");
        ApiClient.guardar(context,usu);
        boolean rta=true;
        Usuario usuario=ApiClient.login(context,mailB,passwordB);
        if(usu!=null) rta=true;
        return rta;
    }


}
