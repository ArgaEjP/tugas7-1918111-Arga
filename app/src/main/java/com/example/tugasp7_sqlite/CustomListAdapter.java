package com.example.tugasp7_sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Museum> movieItems;
    public CustomListAdapter(Activity activity, List<Museum> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView text_namamuseum = (TextView)
                convertView.findViewById(R.id.text_museum);
        TextView text_alamat = (TextView)
                convertView.findViewById(R.id.text_alamat);
        TextView text_email = (TextView)
                convertView.findViewById(R.id.text_email);
        Museum m = movieItems.get(position);
        text_namamuseum.setText("Nama Museum : "+ m.get_namamuseum());
        text_alamat.setText("Alamat : "+ m.get_alamat());
        text_email.setText("email: "+ m.get_email());
        return convertView;
    }
}

