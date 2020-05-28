package com.example.loginsharedpreference.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginsharedpreference.R;
import com.example.loginsharedpreference.model.Usuario;
import com.example.loginsharedpreference.request.ApiClient;
import com.example.loginsharedpreference.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etPassword;
    private Button btnEnviar;
    private Button btnRegistrar;
    private TextView tvMensaje;
    private ViewModelMain vm;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMain.class);

        iniciarVista();
    }
    private void iniciarVista(){
        etUsuario=findViewById(R.id.etMailLogueo);
        etPassword=findViewById(R.id.etPasswordLogueo);
        tvMensaje=findViewById(R.id.tvMensajeLogueo);
        btnEnviar=findViewById(R.id.btnEnviarLogueo);
        btnRegistrar=findViewById(R.id.btnRegistro);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si el usuario existe
                boolean rta=vm.buscarUsuario(etUsuario.getText().toString(),etPassword.getText().toString());
                if(rta)
                {
                    Intent i=new Intent(MainActivity.this, RegistroActivity.class);
                    //aviso que existe, para que se carguen los datos
                    i.putExtra("esta", true);
                    MainActivity.this.startActivity(i);
                }
                else tvMensaje.setText("Datos incorrectos");
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verifico que el usuario NO existe
                //para que no se registre mas de una vez
                boolean rta=vm.buscarUsuario(etUsuario.getText().toString(),etPassword.getText().toString());
                if(!rta)
                {
                    Intent i=new Intent(MainActivity.this, RegistroActivity.class);
                    //aviso que no se carguen los datos
                    i.putExtra("esta", false);
                    MainActivity.this.startActivity(i);
                }
                else tvMensaje.setText("Ya está registrado");
            }
        });
    }
}
