package com.example.combatcompendium;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.pass);
        EditText rPass = findViewById(R.id.re_pass);



        Button register = (Button) findViewById(R.id.register);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString() + "@combat.com";
                String password = pass.getText().toString();
                String reEnter = rPass.getText().toString();
                Log.d("details", username);
                if (password.equals(reEnter)){
                    auth.createUserWithEmailAndPassword(username, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                User user = new User(username, password);
                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).setValue(user);
                                Toast.makeText(Register.this, "User Data Saved", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, Hub.class);
                                startActivity(intent);

                            }else {
                                Log.d("details", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Register.this, "Failed Registration", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else{
                    Toast.makeText(Register.this, "Passwords don't match", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}