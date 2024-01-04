package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClickMakanan extends AppCompatActivity implements View.OnClickListener {
    private TextView pesan_nama;
    private TextView pesan_info;
    private TextView total_pesan;
    private EditText lokasi_pesan;
    private Button btnpesan;
    private Button plus;
    private Button min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_makanan);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String info = intent.getStringExtra("info");

        pesan_nama = findViewById(R.id.txt_pesan_nama);
        pesan_info = findViewById(R.id.txt_pesan_info);
        pesan_nama.setText(nama);
        pesan_info.setText(info);

        lokasi_pesan = findViewById(R.id.lokasi_pesan);
        btnpesan = findViewById(R.id.pesan_btn);
        btnpesan.setOnClickListener(this);

        total_pesan = findViewById(R.id.total_pesan);
        plus = findViewById(R.id.btn_plus);
        min = findViewById(R.id.btn_min);
        plus.setOnClickListener(v -> {
            int data = Integer.parseInt(total_pesan.getText().toString());
            total_pesan.setText(String.valueOf(data+1));
        });

        min.setOnClickListener(v -> {
            int data = Integer.parseInt(total_pesan.getText().toString());
            total_pesan.setText(String.valueOf(data-1));
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BayarMakanan.class);

        intent.putExtra("pesan_nama", pesan_nama.getText().toString());
        intent.putExtra("pesan_info", pesan_info.getText().toString());
        intent.putExtra("lokasi_pesan", lokasi_pesan.getText().toString());
        intent.putExtra("total_pesan", total_pesan.getText().toString());

        startActivity(intent);
    }
}