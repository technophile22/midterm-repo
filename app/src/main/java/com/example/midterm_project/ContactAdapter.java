package com.example.midterm_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    ArrayList <LvItem> arrayList;
    Context context;
    LayoutInflater layoutInflater;

    public ContactAdapter(ArrayList<LvItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view1 = layoutInflater.inflate(R.layout.lvitems, parent, false );
        TextView txtname = view1.findViewById(R.id.txtname);
        TextView txtgender = view1.findViewById(R.id.txtgender);
        TextView txtage = view1.findViewById(R.id.txtage);

        txtname.setText(arrayList.get(position).getName());
        txtgender.setText(arrayList.get(position).getGender());
        txtage.setText(arrayList.get(position).getAge());


        return view1;
    }
}
