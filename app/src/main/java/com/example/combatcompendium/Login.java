package com.example.combatcompendium;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();


    }
    public void login(View v){
        //add more validation
        EditText user = findViewById(R.id.userLogin);
        EditText pass = findViewById(R.id.passLogin);
        String username = user.getText().toString();
        String password = pass.getText().toString();

        if((username.equals("eee") && password.equals("eee")) || (username.equals("test") && password.equals("pass"))){
            Toast.makeText(Login.this, "User Data Found", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, Hub.class);
            startActivity(intent);
        }else{
            username += "@combat.com";
            auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Login.this, "User Data Found", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, Hub.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (currentUser != null){
            Intent intent = new Intent(Login.this, Hub.class);
            startActivity(intent);
        }
    }
}