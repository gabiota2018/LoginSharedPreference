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
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // boolean rta=vm.buscarUsuario(etUsuario.getText().toString(),etPassword.getText().toString());
                // if(rta)
                {
                    Intent i=new Intent(MainActivity.this, RegistroActivity.class);
                    MainActivity.this.startActivity(i);
                }
                //else tvMensaje.setText("Datos incorrectos");
            }
        });
    }
}
