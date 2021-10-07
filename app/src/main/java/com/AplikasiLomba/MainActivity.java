 package com.AplikasiLomba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<btnDetail> extends AppCompatActivity {

//  Inisialisasi variabel
    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autocomplete;
    private TextView txtDetail;
    private Button btnDetail;

//  Inisialisasi variabel dan isi untuk judul dan deskripsi di list view
    String mTitle[] = {"Animation", "E-Bussiness", "E-Goverment", "Game Dev", "Hackathon", "Innovation", "IoT", "Security"};
    String mDescription[] = {"Lomba Animasi", "Lomba E-Bussiness", "Lomba E-Goverment", "Lomba Game Dev", "Lomba Hackathon", "Lomba Innovation", "Lomba IoT", "Lomba Security"};
    int images[] = {R.drawable.animasi, R.drawable.bisnis, R.drawable.goverment, R.drawable.game, R.drawable.hackathon, R.drawable.inovasi, R.drawable.iot, R.drawable.security};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

//  Bagian AutoCompleteText
        autocomplete = findViewById(R.id.autocomplete);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, mTitle);
        autocomplete.setAdapter(adapter2);

        //      Set toast (pesan pop up) jika item di klik
        autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String namaLomba = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Anda memilih: " +namaLomba, Toast.LENGTH_SHORT).show();
            }
        });

//  Bagian Spinner
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //      Set toast (pesan pop up) jika item di klik

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String negara = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Anda : " +negara, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//  Bagian ListView
        listView = findViewById(R.id.listView);

        MyAdapter adapter1 = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter1);

        //      Set toast (pesan pop up) jika item di klik

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String negara1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Anda klik lomba: " +negara1, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //      Set Intent untuk pindah activity ke bidanglombaactivity
    //      Set toast (pesan pop up) jika item di klik

    public void bidangLomba(View view) {
        Intent BidangLombaActivity = new Intent(MainActivity.this, BidangLombaActivity.class);
        startActivity(BidangLombaActivity);
        Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
    }




//  Set adapter untuk menampilkan data
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }

    }

