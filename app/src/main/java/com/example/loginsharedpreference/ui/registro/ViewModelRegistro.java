package com.example.loginsharedpreference.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.loginsharedpreference.model.Usuario;
import com.example.loginsharedpreference.request.ApiClient;
import com.example.loginsharedpreference.ui.login.MainActivity;

public class ViewModelRegistro extends AndroidViewModel  {
    private MutableLiveData<Usuario> usuarioMutableLiveData;
    private Context context;
    private Usuario usuario;

      public ViewModelRegistro(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Usuario> getUsuarioMutableLiveData() {
        if(usuarioMutableLiveData==null){
            usuarioMutableLiveData=new MutableLiveData<>();
        }
        return usuarioMutableLiveData;
    }


public  void guardar(Usuario usuario){
    ApiClient.guardar(context,usuario);
    Intent i=new Intent(context, MainActivity.class);
    context.startActivity(i);
}

    public void traerDatos(String correoBuscado){
        if(!correoBuscado.equals("vacio")) {
            usuario = ApiClient.leer(context, correoBuscado);
            usuarioMutableLiveData.setValue(usuario);
        }
    }
}
