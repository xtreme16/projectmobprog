package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import FinalProject.antermakan.helper.DBUserHelper;
import FinalProject.antermakan.models.User;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button onregis;
    private DBUserHelper DB = new DBUserHelper(this);
    private ArrayList<User> users = new ArrayList<User>();
    EditText ETnama, ETemail, ETtelpon, ETalamat, ETpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        onregis = findViewById(R.id.regis_btn);
        onregis.setOnClickListener(this);

        ETnama = findViewById(R.id.regis_name);
        ETemail = findViewById(R.id.regis_email);
        ETtelpon = findViewById(R.id.regis_telp);
        ETalamat = findViewById(R.id.regis_address);
        ETpassword = findViewById(R.id.regis_pass);

        String nama = ETnama.getText().toString();
        String email = ETemail.getText().toString();
        String telpon = ETtelpon.getText().toString();
        String alamat = ETalamat.getText().toString();
        String password = ETpassword.getText().toString();

    }

    public void onLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        DB.insert_user(new User("Christian", "daiwd", "djwaidhwa", "dhawdhwai", "dhawidhwa"));

//        Toast.makeText(this, nama, Toast.LENGTH_LONG).show();

        users = DB.get_users();

        for (User u : users ) {
            u.print();
        }


        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}