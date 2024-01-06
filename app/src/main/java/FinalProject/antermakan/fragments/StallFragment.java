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

        for(int i=1 ; i<=10; i++){
            int status = (int)(Math.random()*2 + 1);   //1 atau 2
            if( status == 1 ){
                stall.add(new Stall("Stall " + i, "Ini Stall " + i, "Indonesian Food"));
            }
            else{
                stall.add(new Stall("Stall " + i, "Ini Stall " + i, "Chinese Food"));
            }
        }

        rv_stalls = view.findViewById(R.id.rv_stall);
        stallAdapter = new StallAdapter(stall);
        rv_stalls.setAdapter(stallAdapter);
        rv_stalls.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
