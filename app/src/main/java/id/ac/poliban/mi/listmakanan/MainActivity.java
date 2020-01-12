package id.ac.poliban.mi.listmakanan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Makanan> makanans = new  ArrayList<>();
    private ListView lvMakanan;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //koneksikan object dengan view
        lvMakanan = findViewById(R.id.listview);

        //ambil data dari MakananData dan berikan ke object Makanans
        makanans.addAll(MakananData.getAllMakanans());

        //buat object adapter dan kirim data makanans sebagai
        //parameter di konstruktor MakananAdapter()
        adapter = new MakananAdapter(makanans);
        //pasang object adapter sebagai adapter lvMakanan
        lvMakanan.setAdapter(adapter);

        //menambahkan kejadian ketika user mengklik salah satu item
        lvMakanan.setOnItemClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(makanans.get(position).toString())
                    .setPositiveButton("OK", null).show();
        });
    }
}
