package FinalProject.antermakan.adapters;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import FinalProject.antermakan.ClickMakanan;
import FinalProject.antermakan.Dashboard;
import FinalProject.antermakan.R;
import FinalProject.antermakan.models.Makanan;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {
    private ArrayList<Makanan> makanans = new ArrayList<Makanan>();
    public MakananAdapter(ArrayList<Makanan> makanan) {
        this.makanans = makanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_makanan, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.ViewHolder holder, int position) {
        Makanan makanan = makanans.get(position);

        TextView txtNama = holder.txtNama;
        TextView txtInfo = holder.txtInfo;

        txtNama.setText(makanan.getNama());
        txtInfo.setText(makanan.getInfo());

    }

    @Override
    public int getItemCount() {
        return makanans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtNama;
        public TextView txtInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v1 -> {
                Intent intent = new Intent(v1.getContext(), ClickMakanan.class);

                intent.putExtra("nama", txtNama.getText().toString());
                intent.putExtra("info", txtInfo.getText().toString());

                v1.getContext().startActivity(intent);
            });

            txtNama = itemView.findViewById(R.id.txt_nama_makanan);
            txtInfo = itemView.findViewById(R.id.txt_info_makanan);
        }
    }
}
