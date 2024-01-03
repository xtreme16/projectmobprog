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
import FinalProject.antermakan.adapters.OrderAdapter;
import FinalProject.antermakan.models.Order;

public class OrderFragment extends Fragment {
    private ArrayList<Order> order = new ArrayList<Order>();
    private OrderAdapter orderAdapter;
    private RecyclerView rv_orders;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        for(int i=1 ; i<=10; i++){
            int status = (int)(Math.random()*2 + 1);   //1 atau 2
            if( status == 1 ){
                order.add(new Order("Stall " + i, "Makanan " + i + ", " + "Makanan" + (i+1), "Rp.100.000"));
            }
            else{
                order.add(new Order("Stall " + i, "Makanan " + i, "Rp.130.000"));
            }
        }

        rv_orders = view.findViewById(R.id.rv_order);
        orderAdapter = new OrderAdapter(order);
        rv_orders.setAdapter(orderAdapter);
        rv_orders.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
