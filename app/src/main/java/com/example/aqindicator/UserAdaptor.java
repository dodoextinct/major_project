package com.example.aqindicator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class UserAdaptor extends ArrayAdapter<User> {
     Context context;
    public UserAdaptor(Context context, int resourceId,
                                 List<User> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView aqi;
        TextView name;
        TextView desc;
        TextView time;
        LinearLayout layout;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        User user = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.junctions, parent, false);


            convertView = mInflater.inflate(R.layout.junctions, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.aqi = (TextView) convertView.findViewById(R.id.indicator);
            holder.imageView = (ImageView) convertView.findViewById(R.id.img);
            holder.desc = (TextView)convertView.findViewById(R.id.desc);
            holder.time = (TextView)convertView.findViewById(R.id.time);
            holder.layout = (LinearLayout) convertView.findViewById(R.id.back);
            convertView.setTag(holder);
            // Populate the data into the template view using the data object
        }
        else
        {holder = (ViewHolder) convertView.getTag();}
        holder.name.setText(user.name);

        holder.aqi.setText(""+user.aqi);

        holder.imageView.setImageResource(user.getImageId());

        holder.desc.setText(user.desc);

        holder.time.setText(user.time);

        holder.layout.setBackgroundColor(Color.parseColor(user.getBack()));

        // Return the completed view to render on screen


        return convertView;
    }
}
