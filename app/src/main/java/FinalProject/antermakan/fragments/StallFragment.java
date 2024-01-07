package FinalProject.antermakan.fragments;

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

import FinalProject.antermakan.R;
import FinalProject.antermakan.adapters.StallAdapter;
import FinalProject.antermakan.models.Stall;

public class StallFragment extends Fragment {
    private ArrayList<Stall> stall = new ArrayList<Stall>();
    private StallAdapter stallAdapter;
    private RecyclerView rv_stalls;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stall, container, false);

        stall.add(new Stall("Selera Makan", "Restoran dengan sajian makanan rumahan yang murah dan enak", "Indonesian Food"));
        stall.add(new Stall("Rumah Makan Jaya", "Rumah makan yang membuat anda merasakan sensasi masakan Ibu", "Indonesian Food"));
        stall.add(new Stall("Warteg Bahari", "Warteg dengan sayur dan lauk lengkap", "Indonesian Food"));
        stall.add(new Stall("Rembulan", "Restoran mewah tapi murah dengan suasana Rembulan", "Chinese Food"));
        stall.add(new Stall("Mari Makan", "Rumah makan sederhana dengan rasa yang berbahaya", "Indonesian Food"));
        stall.add(new Stall("Diner Dash", "Cafe murah tapi mewah dengan pelayanan terbaik", "Western Food"));
        stall.add(new Stall("Ayam Cepat", "Fast Food dengan menu yang melimpah", "Western Food"));
        stall.add(new Stall("KPC", "Kita Pried Chicken dengan rasa juara", "Western Food"));
        stall.add(new Stall("Sendok Perak", "Restoran dengan konsep elegan dan classic", "Chinese Food"));
        stall.add(new Stall("Cafe Sudut Jalan", "Cafe di sudut jalan dengan suasana nyaman dan tenang", "Indonesian Food"));

        rv_stalls = view.findViewById(R.id.rv_stall);
        stallAdapter = new StallAdapter(stall);
        rv_stalls.setAdapter(stallAdapter);
        rv_stalls.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
