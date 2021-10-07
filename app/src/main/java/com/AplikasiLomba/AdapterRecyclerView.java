package com.AplikasiLomba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.viewHolder> {

    private ArrayList<ItemModel> dataItem;
    private Context context;

    AdapterRecyclerView(Context context, ArrayList<ItemModel> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TextView textTittle = holder.textTittle;
        TextView textSubTittle = holder.textSubTittle;
        ImageView imageIcon = holder.imageIcon;

        textTittle.setText(dataItem.get(position).getName());
        textSubTittle.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

//        Mengatur isi konten untuk recyclerview
//        Set Toast untuk memunculkan pop up pesan
        holder.parentLayout.setOnClickListener(view -> {
            Toast.makeText(context, "Anda memilih lomba: "+dataItem.get(position).getName(), Toast.LENGTH_SHORT).show(); // memberi pesan

//            Mengatur isi konten beberapa bidang lomba seperti judul dan deskripsi
            if (dataItem.get(position).getName().equals("Animation")) { // akan berjalan jika salah satu list berjalan, membaca berdasarkan nama lombanya yang dicek pada data di file Data.java
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.animasi);
                i.putExtra("TEXT_DEFAULT", "Animation");
                i.putExtra("TEXT_DEFAULT2", "Animation");
                i.putExtra("TEXT_DESKRIPSI", "Animation adalah lomba membuat animasi dengan tema yang sudah ditentukan.");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("E-Bussiness")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.bisnis);
                i.putExtra("TEXT_DEFAULT", "E-Bussiness");
                i.putExtra("TEXT_DEFAULT2", "E-Bussiness");
                i.putExtra("TEXT_DESKRIPSI", "E-Bussiness adalah lomba untuk menciptakan karya berupa proposal bisnis dengan mengikuti perkembangan teknologi terkini.");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("E-Goverment")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.goverment);
                i.putExtra("TEXT_DEFAULT", "E-Goverment");
                i.putExtra("TEXT_DEFAULT2", "E-Goverment");
                i.putExtra("TEXT_DESKRIPSI", "E-Goverment adalah lomba menciptakan karya berupa proposal yang bisa di implementasikan di pemerintahan.");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Game Developer")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.game);
                i.putExtra("TEXT_DEFAULT", "Game Developer");
                i.putExtra("TEXT_DEFAULT2", "Game Developer");
                i.putExtra("TEXT_DESKRIPSI", "Game Developer adalah lomba untuk mengembangkan software game.");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Hackathon")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.hackathon);
                i.putExtra("TEXT_DEFAULT", "Hackathon");
                i.putExtra("TEXT_DEFAULT2", "Hackathon");
                i.putExtra("TEXT_DESKRIPSI", "Hackathon adalah lomba dalam bidang programming dengan waktu terbatas.");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Innovation")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.inovasi);
                i.putExtra("TEXT_DEFAULT", "Innovation");
                i.putExtra("TEXT_DEFAULT2", "Innovation");
                i.putExtra("TEXT_DESKRIPSI", "Innovation adalah lomba menciptakan sebuah ide inovasi diberbagai bidang sesuai yang dilombakan.");
                context.startActivity(i);
            }else if (dataItem.get(position).getName().equals("IoT")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.iot);
                i.putExtra("TEXT_DEFAULT", "IoT");
                i.putExtra("TEXT_DEFAULT2", "IoT");
                i.putExtra("TEXT_DESKRIPSI", "IoT adalah lomba menciptakan sebuah karya yang berupa alat fisik di bidang teknologi.");
                context.startActivity(i);
            }else if (dataItem.get(position).getName().equals("Security")) {
                Intent i = new Intent(context, DetailLombaActivity.class);
                i.putExtra("IMAGE_DEFAULT", R.drawable.security);
                i.putExtra("TEXT_DEFAULT", "Security");
                i.putExtra("TEXT_DEFAULT2", "Security");
                i.putExtra("TEXT_DESKRIPSI", "Security adalah lomba untuk untuk menguji kemampuan analisa dan troubleshooting peserta mengenai jaringan komputer dengan simulasi Packet Tracer.");
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textTittle, textSubTittle;
        ImageView imageIcon;
        LinearLayoutCompat parentLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textTittle = itemView.findViewById(R.id.textTittle);
            textSubTittle = itemView.findViewById(R.id.textSubTitle);
            imageIcon = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
