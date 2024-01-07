package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import FinalProject.antermakan.helper.DBUserHelper;
import FinalProject.antermakan.models.User;

public class Register extends AppCompatActivity {
    private Button onregis;
//    private DBUserHelper DB = new DBUserHelper(this);
//    private ArrayList<User> users = new ArrayList<User>();
    private DatabaseReference database;
    private FirebaseApp firebaseApp;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    EditText ETnama, ETemail, ETtelpon, ETalamat, ETpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        onregis = findViewById(R.id.regis_btn);

        ETnama = findViewById(R.id.regis_name);
        ETemail = findViewById(R.id.regis_email);
        ETtelpon = findViewById(R.id.regis_telp);
        ETalamat = findViewById(R.id.regis_address);
        ETpassword = findViewById(R.id.regis_pass);

        firebaseApp = FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://project-mobprog-35ac0-default-rtdb.asia-southeast1.firebasedatabase.app/");


        onregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = ETnama.getText().toString();
                String email = ETemail.getText().toString();
                String telpon = ETtelpon.getText().toString();
                String alamat = ETalamat.getText().toString();
                String password = ETpassword.getText().toString();

                if(nama.isEmpty() || email.isEmpty() || telpon.isEmpty() || alamat.isEmpty() || password.isEmpty()){
                    Toast.makeText(Register.this, "Ada Data Yang Masih Kosong!!!", Toast.LENGTH_SHORT).show();
                }else {
                    if(nama.length() < 4){
                        Toast.makeText(Register.this, "Nama harus lebih dari 3 karakter!", Toast.LENGTH_SHORT).show();
                    }else if(!email.contains("@") || !email.endsWith(".com")){
                        Toast.makeText(Register.this, "Email harus mengandung '@' dan diakhiri dengan '.com'", Toast.LENGTH_SHORT).show();
                    } else if(password.length() < 7){
                        Toast.makeText(Register.this, "Password harus lebih dari 6 karakter!", Toast.LENGTH_SHORT).show();
                    }else {
                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, task -> {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Register.this, "Register Gagal!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "Register Berhasil!", Toast.LENGTH_SHORT).show();
                                database = firebaseDatabase.getReference().child("users").child(mAuth.getCurrentUser().getUid());
                                database.setValue(new User(nama, email, telpon, alamat, password));
                                Intent intent = new Intent(Register.this, Dashboard.class);
                                startActivity(intent);
                            }

                        });
                    }
                }
            }
        });

    }

    public void onLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}