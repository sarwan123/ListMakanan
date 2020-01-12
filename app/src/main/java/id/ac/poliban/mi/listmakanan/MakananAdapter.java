package id.ac.poliban.mi.listmakanan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MakananAdapter extends BaseAdapter {
    //data berupa object List dari kelas POJO Makanan
    private List<Makanan> data = new ArrayList<>();

    public MakananAdapter(List<Makanan> data){
        //parameter konsturktor berupa data object List dari kelas Makanan
        this.data = data;
    }

    @Override
    public int getCount() {
        //kembalikan jumlah item dalam data
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        //mengembalikan object data pada posisi
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        //mengembalikan ID baris data jika ada
        //disini cuma mengembalikan nilai position
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img_gambar;
        TextView tvManakanName;
        TextView tvMakananDesc;

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_makanan, parent, false);

        //deklarasikan View
        img_gambar = convertView.findViewById(R.id.img_gambar);
        tvManakanName = convertView.findViewById(R.id.tv_makanan_name);
        tvMakananDesc = convertView.findViewById(R.id.tv_makanan_description);

        //isi data
        Glide.with(parent.getContext())
                .load(data.get(position).getGambar())
                .apply(new RequestOptions().override(60, 60))
                .into(img_gambar);
        tvManakanName.setText(data.get(position).getMakananName());
        tvMakananDesc.setText(data.get(position).getMakananDesc());

        return convertView;
    }
}
