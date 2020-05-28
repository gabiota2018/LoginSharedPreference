package com.example.loginsharedpreference.request;
import android.content.Context;
import android.content.SharedPreferences;
import  com.example.loginsharedpreference.model.Usuario;
import com.example.loginsharedpreference.model.Usuario;

public class ApiClient {
    private  static SharedPreferences sp;

    private  static SharedPreferences conectar(Context context){
        if(sp==null){
            sp=context.getSharedPreferences("datos",0);
        }
    return sp;
    }

    public  static  void guardar(Context context, Usuario usuario){
        SharedPreferences sp=conectar(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("dni",usuario.getDni());
        editor.putString("apellido",usuario.getApellido());
        editor.putString("nombre",usuario.getNombre());
        editor.putString("mail",usuario.getMail());
        editor.putString("pasword",usuario.getPassword());
        editor.commit();
    }
    public  static  Usuario leer(Context context){
        SharedPreferences sp=conectar(context);
        String dni=sp.getString("dni","-");
        String apellido=sp.getString("apellido","-");
        String nombre=sp.getString("nombre","-");
        String mail=sp.getString("mail","-");
        String password=sp.getString("password","-");
        Usuario usuario=new Usuario(dni,apellido,nombre,mail,password);
        return  usuario;
    }
    public  static  Usuario login(Context context,String correo,String pass){

        Usuario usuario=null;
        SharedPreferences sp=conectar(context);
        String dni=sp.getString("dni","-");
        String apellido=sp.getString("apellido","-");
        String nombre=sp.getString("nombre","-");
        String mail=sp.getString("mail","-");
        String password=sp.getString("password","-");

        if(correo.equals(mail) && pass.equals(password)){
        usuario=new Usuario(dni,apellido,nombre,mail,password);
        }
        return  usuario;
    }
}
