package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ClickMakanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_makanan);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String info = intent.getStringExtra("info");

        Toast.makeText(this, nama, Toast.LENGTH_LONG).show();
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();

        TextView txt = findViewById(R.id.txt_abc);
        txt.setText(nama);

    }
}