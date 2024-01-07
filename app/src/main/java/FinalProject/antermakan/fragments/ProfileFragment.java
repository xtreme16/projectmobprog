package FinalProject.antermakan.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import FinalProject.antermakan.Dashboard;
import FinalProject.antermakan.MainActivity;
import FinalProject.antermakan.R;
import FinalProject.antermakan.UpdateData;

public class ProfileFragment extends Fragment {
    private TextView profile_name, profile_alamat, profile_telp, profile_email;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference database;
    private Button btnupdate, btndelete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profile_name = (TextView) view.findViewById(R.id.txt_profile_name);
        profile_alamat = (TextView) view.findViewById(R.id.alamat_profile);
        profile_telp = (TextView) view.findViewById(R.id.telpon_profile);
        profile_email = (TextView) view.findViewById(R.id.email_profile);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://project-mobprog-35ac0-default-rtdb.asia-southeast1.firebasedatabase.app/");

        FirebaseUser currentUser = mAuth.getCurrentUser();
        database = firebaseDatabase.getReference().child("users").child(currentUser.getUid());

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nama = snapshot.child("nama").getValue().toString();
                String alamat = snapshot.child("alamat").getValue().toString();
                String telpon = snapshot.child("telpon").getValue().toString();
                String email = snapshot.child("email").getValue().toString();

                profile_name.setText(nama);
                profile_alamat.setText(alamat);
                profile_telp.setText(telpon);
                profile_email.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnupdate = (Button) view.findViewById(R.id.btn_change_data);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UpdateData.class);
                startActivity(intent);
            }
        });

        btndelete = (Button) view.findViewById(R.id.btn_delete_acc);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.child("users").child(mAuth.getCurrentUser().getUid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getActivity(), "Akun Sudah Dihapus, Silahkan Masuk Kembali!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getActivity(), MainActivity.class));
                        }else {
                            Toast.makeText(getActivity(), "Hapus Akun Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        return view;
    }
}

