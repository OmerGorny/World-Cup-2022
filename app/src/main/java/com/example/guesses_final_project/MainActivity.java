package com.example.guesses_final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView emailField,passwordField,forgotPass;
    MaterialButton btnLogin,btnSignUp;
    String email,password;
    FirebaseAuth mAuth;
    String adminEmail="admin@gmail.com",adminPass="admin1234admin";
    public static String PREFS_NAME ="MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        initViews();


        initVerbs();
        initBtns();










         


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mFireBaseUser = mAuth.getCurrentUser();
        if (mFireBaseUser!=null )
        {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();

        }
    }

    private void initBtns() {
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

    }

    private void initVerbs() {
        email =emailField.getText().toString().trim();
        password=passwordField.getText().toString();
        mAuth=FirebaseAuth.getInstance();

    }

    private void initViews() {

        emailField=findViewById(R.id.emailField);
        passwordField=findViewById(R.id.password);
        forgotPass=findViewById(R.id.forgotpass);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignUp=findViewById(R.id.btnSignUp);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                loginAction();
                break;

            case R.id.btnSignUp:
                signupAction();
                break;

        }
    }



    private void signupAction() {
        startActivity(new Intent(MainActivity.this,SignUp.class));
    }

    private void loginAction() {
        initVerbs();




        if(email.isEmpty()||password.isEmpty()){
            Toast.makeText(MainActivity.this, " one or more are empty",
                    Toast.LENGTH_SHORT).show();
            return;

        }
        if(email.equals(adminEmail)&&password.equals(adminPass)){
            startActivity(new Intent(MainActivity.this, AdminActivity.class));
            return;




        }

        else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();


                                startActivity(new Intent(MainActivity.this, HomeActivity.class));


                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(MainActivity.this, ""+task.getException(),
                                        Toast.LENGTH_SHORT).show();

                            }


                        }
                    });
        }




    }

}
