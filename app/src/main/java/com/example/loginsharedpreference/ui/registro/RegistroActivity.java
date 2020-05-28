package com.example.loginsharedpreference.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginsharedpreference.R;
import com.example.loginsharedpreference.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private EditText etDni,etApellido,etNombre,etMail,etPassword;
    private Button btnActualizar;
    private ViewModelRegistro vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistro.class);
       btnActualizar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Usuario usuario=new Usuario();
               usuario.setDni(etDni.getText().toString());
               usuario.setApellido(etApellido.getText().toString());
               usuario.setNombre(etNombre.getText().toString());
               usuario.setMail(etPassword.getText().toString());
               usuario.setPassword(etPassword.getText().toString());
               vm.guardar(usuario);
           }
       });
vm.getUsuarioMutableLiveData().observe(this, new Observer<Usuario>() {
    @Override
    public void onChanged(Usuario usuario) {
        etDni.setText(usuario.getDni());
        etApellido.setText(usuario.getApellido());
        etNombre.setText(usuario.getNombre());
        etMail.setText(usuario.getMail());
        etPassword.setText(usuario.getPassword());
    }
});
Intent i=getIntent();
vm.traerDatos(i.getBooleanExtra("esta",false));
    }
}
