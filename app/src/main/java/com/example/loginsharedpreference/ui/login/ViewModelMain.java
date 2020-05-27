package com.example.loginsharedpreference.ui.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import  com.example.loginsharedpreference.model.Usuario;
import com.example.loginsharedpreference.request.ApiClient;

public class ViewModelMain extends ViewModel {
    private Context context;
    private MutableLiveData<String>  tvMensaje;


    public LiveData<String> getTvMensaje() {
        if(tvMensaje==null){
            tvMensaje=new MutableLiveData<>();
        }
        return tvMensaje;
    }

    public Boolean logueo(String mailBuscado, String passwordBuscado){
        boolean rta=false;
     /*   Usuario miUsuario=new Usuario();
        if(mailBuscado.equals("") || passwordBuscado.equals(""))
            tvMensaje.setValue("Complete los datos");
        else
        {
            miUsuario= ApiClient.login(context,mailBuscado,passwordBuscado);
            if(miUsuario!=null) rta=true;
            else tvMensaje.setValue("Datos incorrectos");
        }*/
        tvMensaje.setValue("entro a logueo");
        return  rta;
    }

}
