package FinalProject.antermakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import FinalProject.antermakan.databinding.ActivityUpdateDataBinding;
import FinalProject.antermakan.models.User;

public class UpdateData extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    private Button btnUpdate;
    private EditText editnama, editemail, edittelp, editalamat, editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        editnama = findViewById(R.id.update_nama);
        editemail = findViewById(R.id.update_email);
        edittelp = findViewById(R.id.update_telp);
        editalamat = findViewById(R.id.update_address);
        editpassword = findViewById(R.id.update_pass);
        btnUpdate = findViewById(R.id.update_btn);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editnama.getText().toString();
                String email = editnama.getText().toString();
                String telpon = editnama.getText().toString();
                String alamat = editnama.getText().toString();
                String password = editnama.getText().toString();

                updateData(nama, email, telpon, alamat, password);
            }
        });
    }

    private void updateData(String nama, String email, String telpon, String alamat, String password){
        HashMap<String, Object> hash = new HashMap<>();
        hash.put("nama", nama);
        hash.put("email", email);
        hash.put("telpon", telpon);
        hash.put("alamat", alamat);
        hash.put("password", password);

        firebaseDatabase = FirebaseDatabase.getInstance("https://project-mobprog-35ac0-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();
        databaseReference.child("users").child(mAuth.getCurrentUser().getUid()).updateChildren(hash).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    Toast.makeText(UpdateData.this, "Data Sudah Terupdate!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateData.this, Dashboard.class));
                }else {
                    Toast.makeText(UpdateData.this, "Update Data Gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}