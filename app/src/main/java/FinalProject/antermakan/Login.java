package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText inputemail, inputpass;
    Button btnlogin;
    FirebaseAuth mAuth;
    FirebaseApp firebaseApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputemail = findViewById(R.id.login_email);
        inputpass = findViewById(R.id.login_pass);
        btnlogin = findViewById(R.id.login_btn);

        firebaseApp = FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputemail.getText().toString();
                String pass = inputpass.getText().toString();

                if(email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(Login.this, "Ada Data Yang Masih Kosong!!!", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(Login.this, task -> {
                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                            Log.e("Login Gagal", "onCancelled", task.getException());
                        }else{
                            startActivity(new Intent(Login.this, Dashboard.class));
                            finish();
                        }
                    });
                }
            }

        });

    }

    public void onRegister(View v){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}