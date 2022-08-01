package com.example.day0111;

import android.content.Context;
import android.os.strictmode.CleartextNetworkViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Listviewitem> data;
    LayoutInflater inflater;

    // 생성자(1, 2, 3)
    // 에러 public Listviewitem() {    }
    public ListviewAdapter(Context context, int layout, ArrayList<Listviewitem> data) {
        this.context = context;
        this.layout = layout;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    public ListviewAdapter(Context context, int layout, ArrayList<Listviewitem> data, LayoutInflater inflater) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        this.inflater = inflater;
    }

    // 4개 추상메소드 구현
    @Override
    public int getCount() {
        return data.size();
    } // end

    @Override
    public Object getItem(int i) {
        return data.get(i);
    } // end

    @Override
    public long getItemId(int i) {
        return i;
    } // end

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        // 기본값으로 제공 // 동물, 안내문 출력되도록 해야합니다
        if (convertView == null) {
            convertView = inflater.inflate(layout, viewGroup, false);
        }
        Listviewitem listviewitem = data.get(pos); // ArrayList<Listviewitem> data;

        ImageView icon = (ImageView)convertView.findViewById(R.id.imageview);
        icon.setImageResource(listviewitem.getIcon());
        TextView name = (TextView) convertView.findViewById(R.id.textview);
        name.setText(listviewitem.getName());

        return convertView;
    } // end
} // class END
