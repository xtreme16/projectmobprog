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

        for(int i=1 ; i<=10; i++){
            int status = (int)(Math.random()*2 + 1);   //1 atau 2
            if( status == 1 ){
                makanan.add(new Makanan("Nasi Goreng " + i, "Ini adalah Nasi Goreng"));
            }
            else{
                makanan.add(new Makanan("Mie Goreng " + i, "Ini adalah Mie Goreng"));
            }
        }

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
