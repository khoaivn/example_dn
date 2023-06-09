package com.example.example_dn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Item> items = Arrays.asList(new Item("AAAA", 6,7, 8),
            new Item("BBBB", 3, 5,9));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        List<Item> items = Arrays.asList(new Item("AAAA", 6,7, 8),
                new Item("BBBB", 3, 5,9));
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.item_for_listview, items);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(customAdapter);

    }
}


class CustomAdapter extends ArrayAdapter<Item> {
    private Context context;
    private int layoutResourceId;
    private List<Item> data = null;

    public CustomAdapter(Context context, int layoutResourceId, List<Item> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.imageView = row.findViewById(R.id.imageView);
            holder.titleTextView = row.findViewById(R.id.titleTextView);
            holder.descriptionTextView = row.findViewById(R.id.descriptionTextView);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Item item = data.get(position);
//        holder.imageView.setImageResource(item.getImageResource());
        holder.titleTextView.setText(item.getFull_name());
        holder.descriptionTextView.setText(Float.toString(item.getDTB()));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DetailActivity.class);
                myIntent.putExtra("position", position); //Optional parameters
                view.getContext().startActivity(myIntent);
            }
        });

        return row;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;
    }
}

