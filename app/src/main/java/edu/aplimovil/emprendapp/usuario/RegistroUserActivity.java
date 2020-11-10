package edu.aplimovil.emprendapp.usuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.login.LoginActivity;
import edu.aplimovil.emprendapp.menu.MainActivity;
import edu.aplimovil.emprendapp.menu.PedidosActivity;
import edu.aplimovil.emprendapp.menu.PerfilActivity;

import static edu.aplimovil.emprendapp.R.id.btnBarraNav;

public class RegistroUserActivity extends AppCompatActivity {

    public  EditText textCorreo;
    public  EditText textContrasena;
    public  EditText textNombre;
    public  EditText textApellidos;
    public  EditText textDireccion;
    public  EditText textCiudad;
    public  Button btnRegistrar;
    public  ProgressDialog progressDialog;
    private ImageButton btnAtras;

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_user);

        //Barra superior
        //boton atras
        btnAtras = (ImageButton) findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            onBackPressed();
                                        }
                                    }
        );

        //Barra navegacion
        BottomNavigationView navBar = findViewById(btnBarraNav);

        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.MainActivity:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.PedidosActivity:
                        startActivity(new Intent(getApplicationContext(), PedidosActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.PerfilActivity:
                        startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //Referenciamos los views
        textNombre = (EditText) findViewById(R.id.editText_nombre);
        textApellidos= (EditText) findViewById(R.id.editText_apellido);
        textCiudad = (EditText) findViewById(R.id.editText_ciudad);
        textDireccion = (EditText) findViewById(R.id.editText_direccion);
        textCorreo = (EditText) findViewById(R.id.editText_Correo);
        textContrasena = (EditText) findViewById(R.id.editText_Contrasena);

        btnRegistrar = (Button) findViewById(R.id.button_registrar);

        progressDialog = new ProgressDialog(this);

    }

    public void registrarUsuario(View view) {

        validarCamposUsuario();
        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(textCorreo.getText().toString(),textContrasena .getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            Toast.makeText(RegistroUserActivity.this,"Se ha registrado el usuario con el email: "+ textCorreo.getText(),Toast.LENGTH_LONG).show();
                            registrarUser();
                        }else{
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(RegistroUserActivity.this, "Ese Correo  ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegistroUserActivity.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    public void  registrarUser(){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("nombre", textNombre.getText().toString());
        user.put("apellido", textApellidos.getText().toString());
        user.put("direccion", textDireccion.getText().toString());
        user.put("ciudad", textCiudad.getText().toString());
        user.put("email", textCorreo.getText().toString());
        user.put("pass", textContrasena.getText().toString());
        user.put("foto","https://lh3.googleusercontent.com/proxy/CamnlFET-TcIYy0P30qIDvjgxVKEbFAG7b8MzI6Pyi3fGOxTi22nLlcNOBuJpkpB58OAdVjZHN_JYEpaNxc4u0-EW6Zc6tnaiUPrFBbDYQtU7ck_IUU");


        // Add a new document with a generated ID
        db.collection("usuarios")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // insertarCredenciales(textCorreo.getText().toString(),textContrasena.getText().toString());
                        Log.d("Registro Usuario", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(RegistroUserActivity.this, "Usuario registrado ", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Registro Usuario Error", "Error adding document", e);
                    }
                });
    }

    private void validarCamposUsuario() {

        //Obtenemos el email y la contraseña desde las cajas de texto
        String nombre = textCorreo.getText().toString().trim();
        String apellidos = textCorreo.getText().toString().trim();
        String direccion = textCorreo.getText().toString().trim();
        String ciudad = textCorreo.getText().toString().trim();
        String email = textCorreo.getText().toString().trim();
        String password = textCorreo.getText().toString().trim();


        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(nombre)) {
            Toast.makeText(this, "Se debe ingresar un nombre", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(apellidos)) {
            Toast.makeText(this, "Se debe ingresar un apellido", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(direccion)) {
            Toast.makeText(this, "Se debe ingresar una direccion", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(ciudad)) {
            Toast.makeText(this, "Se debe ingresar una ciudad", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
    }
}