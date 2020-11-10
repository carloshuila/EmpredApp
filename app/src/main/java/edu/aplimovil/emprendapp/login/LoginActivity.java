package edu.aplimovil.emprendapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.usuario.RegistroUserActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    //defining view objects
    private EditText TextEmail;
    private EditText TextPassword;
    private Button btnLogin;
    private ProgressDialog progressDialog;

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //Referenciamos los views
        TextEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        TextPassword = (EditText) findViewById(R.id.editTextNumberPassword);

        btnLogin = (Button) findViewById(R.id.button_iniciar_sesion);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        btnLogin.setOnClickListener(this);
    }

    private void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Toast.makeText(LoginActivity.this, "Bienvenido: " + TextEmail.getText(), Toast.LENGTH_LONG).show();
                           // Intent intencion = new Intent(getApplication(), WellcomeActivity.class);
                            //intencion.putExtra(WellcomeActivity.user, user);
                          //  startActivity(intencion);


                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(LoginActivity.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Usuario o contraseña invalidos ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    @Override
    public void onClick(View v) {
        //Invocamos al método:
        loguearUsuario();
    }


    public void registroUserActivity(View view) {
        Intent intent = new Intent(this, RegistroUserActivity.class);
        startActivity(intent);
    }
}