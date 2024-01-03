package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import FinalProject.antermakan.helper.DBUserHelper;
import FinalProject.antermakan.models.User;

public class Register extends AppCompatActivity {
    private DBUserHelper DB = new DBUserHelper(this);
    private ArrayList<User> users = new ArrayList<User>();
    EditText ETnama, ETemail, ETtelpon, ETalamat, ETpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ETnama = findViewById(R.id.regis_name);
        ETemail = findViewById(R.id.regis_email);
        ETtelpon = findViewById(R.id.regis_telp);
        ETalamat = findViewById(R.id.regis_address);
        ETpassword = findViewById(R.id.regis_pass);

    }

    public void onLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void onDashboard(View v){
//        String nama = ETnama.getText().toString();
//        String email = ETemail.getText().toString();
//        String telpon = ETtelpon.getText().toString();
//        String alamat = ETalamat.getText().toString();
//        String password = ETpassword.getText().toString();
//
//        DB.insert_user(new User("Christian", "daiwd", "djwaidhwa", "dhawdhwai", "dhawidhwa"));
//
////        Toast.makeText(this, nama, Toast.LENGTH_LONG).show();
//
//        users = DB.get_users();
//
//        for (User u : users ) {
//            u.print();
//        }


        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

}