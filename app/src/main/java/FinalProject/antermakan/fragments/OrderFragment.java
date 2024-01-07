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
import FinalProject.antermakan.models.Stall;

public class OrderFragment extends Fragment {
    private ArrayList<Order> order = new ArrayList<Order>();
    private OrderAdapter orderAdapter;
    private RecyclerView rv_orders;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        order.add(new Order("Selera Makan", "(1) Nasi Goreng, (1) Mie Goreng, ", "Rp.55.000", "OnGoing"));
        order.add(new Order("Rumah Makan Jaya", "(1) Mie Goreng", "Rp.40.0000", "OnGoing"));
        order.add(new Order("Warteg Bahari", "(2) Nasi Sayur", "Rp.30.000", "Selesai"));
        order.add(new Order("Rembulan", "(1) Nasi Hainam, (1) Capcay, (2) Bakpao", "Rp.140.000", "Selesai"));
        order.add(new Order("Mari Makan", "(3) Sate Ayam", "Rp.60.000", "Selesai"));
        order.add(new Order("Diner Dash", "(2) Burger, (1) Kentang Goreng", "Rp.65.000", "Selesai"));
        order.add(new Order("Ayam Cepat", "(3) Ayam, (2) Burger, (2) Nasi", "Rp.120.000", "Selesai"));
        order.add(new Order("KPC", "(2) Ayam, (2) Burger, (2) Kentang Goreng", "Rp.150.000", "Selesai"));
        order.add(new Order("Sendok Perak", "(1) Paket Lengkap Keluarga", "RP.400.000", "Selesai"));
        order.add(new Order("Cafe Sudut Jalan", "(1) Nasi Goreng, (1) Kopi Latte", "Rp.50.000", "Selesai"));

        rv_orders = view.findViewById(R.id.rv_order);
        orderAdapter = new OrderAdapter(order);
        rv_orders.setAdapter(orderAdapter);
        rv_orders.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
