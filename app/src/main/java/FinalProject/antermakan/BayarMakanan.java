package FinalProject.antermakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BayarMakanan extends AppCompatActivity {
    private TextView bayar_nama;
    private TextView bayar_info;
    private TextView bayar_lokasi;
    private TextView bayar_harga;
    private TextView bayar_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar_makanan);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("pesan_nama");
        String info = intent.getStringExtra("pesan_info");
        String lokasi = intent.getStringExtra("lokasi_pesan");
        String total = intent.getStringExtra("total_pesan");

        bayar_nama = findViewById(R.id.bayar_nama);
        bayar_info = findViewById(R.id.bayar_info);
        bayar_lokasi = findViewById(R.id.bayar_lokasi);
        bayar_harga = findViewById(R.id.total_harga);
        bayar_total = findViewById(R.id.bayar_total);

        bayar_nama.setText(nama);
        bayar_info.setText(info);
        bayar_lokasi.setText(lokasi);

        int data = Integer.parseInt(total);
        bayar_harga.setText(String.valueOf(data*30000));

        int total_bayar = Integer.parseInt(bayar_harga.getText().toString());
        bayar_total.setText(String.valueOf(total_bayar + 10000 + 2000));

    }
    public void onBayar(View v){
        Intent intent = new Intent(this, SelesaiBayar.class);
        startActivity(intent);
    }
}