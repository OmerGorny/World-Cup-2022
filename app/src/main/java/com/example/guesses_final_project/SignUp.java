package com.example.guesses_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp<FireBaseAuth> extends AppCompatActivity implements View.OnClickListener {



    EditText emailInput,fullNameInput,phoneNumInput,passInput,rePassInput;
    Spinner spinnerCountryPick,spinnerPlayerPick;
    Button btnSignUp;
    FirebaseAuth mAuth;
    String email,password,repass,country,player ,fullName,phoneNum;
    ImageView football;
    DatabaseReference myRef,scoreRef;
    FirebaseDatabase database;
    String [] arrOfPlayer= {""};








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        intViews();
        initBtn();
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignUp:
                regCheck();
                break;
        }


    }

    private void initBtn() {
        btnSignUp.setOnClickListener(this);
    }


    private void intViews() {
        football=findViewById(R.id.football);
        emailInput=findViewById(R.id.emailInput);
        fullNameInput=findViewById(R.id.fullNameInput);
        InitSpinnerView();
        passInput=findViewById(R.id.passInput);
        rePassInput=findViewById(R.id.rePassInput);
        btnSignUp=findViewById(R.id.btnSignUp);

    }
  //// Drop Down For picking Country and Player
    private void InitSpinnerView() {
        //// Drop Down For picking Country
         spinnerCountryPick=findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.countrys, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCountryPick.setAdapter(adapter);

        //// Drop Down For picking Player
         spinnerPlayerPick=findViewById(R.id.spinnerPlayers);
        ArrayAdapter<CharSequence> adapterP=ArrayAdapter.createFromResource(this, R.array.player, android.R.layout.simple_spinner_item);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerPlayerPick.setAdapter(adapterP);
    }


    private void regCheck() {
        intVerbs();


        if(email.isEmpty()|| password.isEmpty()||repass.isEmpty())
        {
            Toast.makeText(SignUp.this, "one or more fields are empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.equals(repass)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                User user =new User(fullName);   //// obj that taking the full name/Nickname by strings
                                Score score = new Score(country,player);   //// obj that taking country and player by strings
                                // Sign in success, update UI with the signed-in user's information

                                // FirebaseUser user = mAuth.getCurrentUser();
                                myRef.child(mAuth.getUid()).child("User").setValue(user);



                                 // writing the Score Obj In Firebase
                                myRef.child(mAuth.getUid()).child("Score").setValue(score);




                                //save user to the firebase data


                                startActivity(new Intent(SignUp.this, MainActivity.class));

                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(SignUp.this, ""+task.getException(),
                                        Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
        }
        else{
            Toast.makeText(SignUp.this, "password dosent match.",
                    Toast.LENGTH_SHORT).show();

        }


    }

    private void intVerbs() {
        mAuth =  FirebaseAuth.getInstance();
        email=emailInput.getText().toString().trim();
        password=passInput.getText().toString();
        repass=rePassInput.getText().toString();
        country=spinnerCountryPick.getSelectedItem().toString();
        player=spinnerPlayerPick.getSelectedItem().toString();
        fullName= fullNameInput.getText().toString();



    }
}