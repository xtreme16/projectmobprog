package FinalProject.antermakan.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import FinalProject.antermakan.Dashboard;
import FinalProject.antermakan.R;
import FinalProject.antermakan.adapters.MakananAdapter;
import FinalProject.antermakan.models.Makanan;

public class HomeFragment extends Fragment {
    private ArrayList<Makanan> makanan = new ArrayList<Makanan>();
    private MakananAdapter makananAdapter;
    private RecyclerView rv_makanans;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        makanan.add(new Makanan("Mie Goreng", "Hidangan mie yang dimasak dengan digoreng tumis"));
        makanan.add(new Makanan("Nasi Goreng", "Nasi yang digoreng dengan kecap manis, bawang merah, bawang putih, telur, daging ayam, dan kerupuk."));
        makanan.add(new Makanan("Sate Ayam", "Daging ayam yang dipanggang menggunakan arang dan disajikan dengan bumbu kacang atau bumbu kecap."));
        makanan.add(new Makanan("Rendang", "Daging yang dimasak di suhu rendah dalam waktu lama dengan menggunakan aneka rempah-rempah dan santan."));
        makanan.add(new Makanan("Ketoprak", "Bumbu kacang yang dipadukan dengan lontong, bihun, dan taoge."));
        makanan.add(new Makanan("Sayur Asam", "Sayuran yang berisi labu siam, kacang panjang, jagung manis, kubis, melinjo, dan kacang tanah."));
        makanan.add(new Makanan("Gado-Gado", "Makanan yang berisi sayur-sayuran, kentang, tempe, tahu, telur rebus dengan bumbu kacang."));
        makanan.add(new Makanan("Ayam Goreng", "Ayam yang digoreng dalam minyak goreng."));
        makanan.add(new Makanan("Gudeg", "Nangka muda yang dimasak dengan santan."));
        makanan.add(new Makanan("Bakso Sapi", "Campuran daging sapi giling yang dicampur tepung tapioca dan dibentuk mirip bola-bola kecil"));

        rv_makanans = view.findViewById(R.id.rv_makanan);
        makananAdapter = new MakananAdapter(makanan);
        rv_makanans.setAdapter(makananAdapter);
        rv_makanans.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    public void onClick(View v){
        Intent intent = new Intent(getActivity(), Dashboard.class);
        startActivity(intent);
    }
}
