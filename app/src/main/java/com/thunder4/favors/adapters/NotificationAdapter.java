package com.thunder4.favors.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thunder4.favors.R;
import com.thunder4.favors.models.Notification;

/**
* Created by Guozhen on 2014-09-20.
*/
public class NotificationAdapter extends ArrayAdapter<Notification> {
    private final Context context;
    private final Notification[] notifs;

    public NotificationAdapter(Context context, Notification[] notifications) {
        super(context, R.layout.notification_layout, notifications);
        this.context = context;
        this.notifs = notifications;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.post_layout, parent, false);
        TextView description = (TextView) rowView.findViewById(R.id.notification_description);
        ImageView profile = (ImageView) rowView.findViewById(R.id.notification_profile);
        description.setText(notifs[position].descriptField);
        profile.setImageBitmap(notifs[position].profilePic);
        return rowView;
    }
}
