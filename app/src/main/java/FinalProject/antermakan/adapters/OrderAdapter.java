package FinalProject.antermakan.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import FinalProject.antermakan.ClickMakanan;
import FinalProject.antermakan.ClickOrder;
import FinalProject.antermakan.R;
import FinalProject.antermakan.models.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
    private ArrayList<Order> orders = new ArrayList<Order>();
    public OrderAdapter(ArrayList<Order> order) {
        this.orders = order;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);

        TextView txtNama = holder.txtNama;
        TextView txtList = holder.txtList;
        TextView txtTotal = holder.txtTotal;

        txtNama.setText(order.getOrder_stall());
        txtList.setText(order.getOrder_list());
        txtTotal.setText(order.getTotal());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtNama;
        public TextView txtList;
        public TextView txtTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v1 -> {
                Intent intent = new Intent(v1.getContext(), ClickOrder.class);
                v1.getContext().startActivity(intent);
            });

            txtNama = itemView.findViewById(R.id.txt_order_stall);
            txtList = itemView.findViewById(R.id.txt_list_order);
            txtTotal = itemView.findViewById(R.id.txt_total_harga);
        }
    }
}
