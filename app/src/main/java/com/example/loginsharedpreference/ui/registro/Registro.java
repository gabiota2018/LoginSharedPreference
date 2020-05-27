package com.example.loginsharedpreference.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginsharedpreference.R;
import com.example.loginsharedpreference.model.Usuario;

public class Registro extends AppCompatActivity {
    private EditText etDni,etApellido,etNombre,etMail,etPassword;
    private Button btnGuardar;
    private ViewModelRegistro vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etDni=findViewById(R.id.etDni);
        etApellido=findViewById(R.id.etApellido);
        etNombre=findViewById(R.id.etNombre);
        etMail=findViewById(R.id.etCorreo);
        etPassword=findViewById(R.id.etPassword);
        btnGuardar=findViewById(R.id.btnGuardar);

        vm=new ViewModelRegistro();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario miUsuario=new Usuario();
                miUsuario.setDni(etDni.getText().toString());
                miUsuario.setApellido(etApellido.getText().toString());
                miUsuario.setNombre(etNombre.getText().toString());
                miUsuario.setMail(etMail.getText().toString());
                miUsuario.setPassword(etPassword.getText().toString());
                vm.guardar(miUsuario);
            }
        });

    }

}
