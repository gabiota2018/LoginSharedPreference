package com.example.loginsharedpreference.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginsharedpreference.R;
import com.example.loginsharedpreference.ui.registro.*;

public class MainActivity extends AppCompatActivity {
private EditText etUsuario,etPassword;
private Button btnLogin,btnRegistro;
    private TextView tvMensaje;
private ViewModelMain vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm=new ViewModelMain();
                iniciarVista();
    }
    private void iniciarVista(){
        etUsuario=findViewById(R.id.etCorreo);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegistro=findViewById(R.id.btnRegistro);
        tvMensaje=findViewById(R.id.tvMensajeLogueo);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Boolean rta=vm.logueo(etUsuario.getText().toString(),etPassword.getText().toString());
              /*  if(rta)
                {
                    //Intent i=new Intent(MainActivity.this, Registro.class);
                    //i.putExtra("pertenece",true);
                    //MainActivity.this.startActivity(i);
                }*/
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean rta=vm.logueo(etUsuario.getText().toString(),etPassword.getText().toString());
                if(!rta)
                {
                    Intent i=new Intent(MainActivity.this, Registro.class);
                    i.putExtra("pertenece",false);
                    MainActivity.this.startActivity(i);
                }
            }
        });
    }
}
