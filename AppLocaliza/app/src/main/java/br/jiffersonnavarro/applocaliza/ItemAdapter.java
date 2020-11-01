package br.jiffersonnavarro.applocaliza;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter <Item> {
    private int layout;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.layout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater infater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=infater.inflate(this.layout,parent,false);
        }

        TextView tvCidadeUF=convertView.findViewById(R.id.tvCidadeUF);
        TextView tvLocal=convertView.findViewById(R.id.tvLocal);
        TextView tvLat=convertView.findViewById(R.id.tvLat);
        TextView tvLong=convertView.findViewById(R.id.tvLong);

        Item item=this.getItem(position);
        tvCidadeUF.setText(""+item.getTvCidadeUF());
        tvLocal.setText(String.format("%.2f",item.getTvLocal()));
        tvLat.setText(String.format("%.2f",item.getTvLat()));
        tvLong.setText(String.format("%.2f",item.getTvLong()));

        return convertView;
    }
}
