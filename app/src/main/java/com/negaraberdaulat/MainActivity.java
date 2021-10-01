package com.negaraberdaulat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Amerika", "Argentina", "Australia", "Belanda", "Belgia", "Brazil", "China", "India", "Indonesia", "Jepang", "Jerman"};
    String sDeskripsi[] = {"Amerika Description", "Argentina Description", "Australia Description", "Belanda Description", "Belgia Description", "Brazil Description", "China Description", "India Description", "Indonesia Description", "Jepang Description", "Jerman Description"};
    int images[] = {R.drawable.amerika, R.drawable.argentina, R.drawable.australia, R.drawable.belanda, R.drawable.belgia, R.drawable.brazil, R.drawable.china, R.drawable.india, R.drawable.indonesia, R.drawable.jepang, R.drawable.jerman,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, sDeskripsi, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Amerika Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Argentina Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Australia Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Belanda Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Belgia Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Brazil Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "China Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "India Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Indonesia Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Jepang Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Jerman Description", Toast.LENGTH_SHORT).show();
                }


        };
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTittle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int img[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTittle = title;
            this.rDescription = description;
            this.rImgs = img;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater lalyoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = lalyoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTittle[position]);
            myDescription.setText(rDescription[position]);



            return super.getView(position, convertView, parent);
        }
    }
    }

