package com.example.proga.urbanhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ochered extends AppCompatActivity {
    int[] images = {R.drawable.magnit,
            R.drawable.patorka,
            R.drawable.perekrestok,
            R.drawable.billa,
            R.drawable.ashan,
            R.drawable.azbuka,
            R.drawable.victory
            };

    String[] MagNames = new String[]{
            "Магнит",
            "Пятерочка",
            "Перекресток",
            "Billa",
            "Ашан",
            "Азбука-Вкуса",
            "Виктория"
            };
    String[] Products = new String[]{
            "100","56","79","64","86","15","34"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ochered);

        ListView listView = (ListView)findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0) {Intent magnit = new Intent(ochered.this,magnit.class); startActivity(magnit);}
                else if (i==1){Intent patorka = new Intent(ochered.this,patorka.class); startActivity(patorka);}
                else if (i==2){Intent perek = new Intent(ochered.this,perek.class); startActivity(perek);}
                else if (i==3){Intent billa = new Intent(ochered.this,billa.class); startActivity(billa);}
                else if (i==4){Intent ashan = new Intent(ochered.this,ashan.class); startActivity(ashan);}
                else if (i==5){Intent azbuka = new Intent(ochered.this,azbuka.class); startActivity(azbuka);}
                else if (i==6){Intent victoria = new Intent(ochered.this,victoria.class); startActivity(victoria);}

            }
        });
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView mim = view.findViewById(R.id.imageView2);
            TextView mtext = view.findViewById(R.id.text);
            TextView mtext1 = view.findViewById(R.id.text1);

            mim.setImageResource(images[i]);
            mtext.setText(MagNames[i]);
            mtext1.setText("Доступно: "+Products[i]+"продуктов");
            return view;
        }
    }
}
