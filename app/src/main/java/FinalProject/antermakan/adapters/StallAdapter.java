package FinalProject.antermakan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import FinalProject.antermakan.R;
import FinalProject.antermakan.models.Stall;

public class StallAdapter extends RecyclerView.Adapter<StallAdapter.ViewHolder>{
    private ArrayList<Stall> stalls = new ArrayList<Stall>();
    public StallAdapter(ArrayList<Stall> stall) {
        this.stalls = stall;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_stall, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StallAdapter.ViewHolder holder, int position) {
        Stall stall = stalls.get(position);

        TextView txtNama = holder.txtNama;
        TextView txtInfo = holder.txtInfo;
        TextView txtJenis = holder.txtJenis;

        txtNama.setText(stall.getNama());
        txtInfo.setText(stall.getInfo());
        txtJenis.setText(stall.getJenis());
    }

    @Override
    public int getItemCount() {
        return stalls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtNama;
        public TextView txtInfo;
        public TextView txtJenis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            txtNama = itemView.findViewById(R.id.txt_nama_stal);
            txtInfo = itemView.findViewById(R.id.txt_info_stall);
            txtJenis = itemView.findViewById(R.id.txt_jenis_stall);
        }

        @Override
        public void onClick(View v) {
//            int position = getLayoutPosition();
//            makanans.remove(position);
//            notifyDataSetChanged();
        }
    }
}
