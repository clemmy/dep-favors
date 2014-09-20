package com.thunder4.favors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by raywan on 2014-09-20.
 */
public class PostAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public PostAdapter(Context context, String[] values) {
        super(context, R.layout.post_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.post_layout, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.post_title);
        TextView description = (TextView) rowView.findViewById(R.id.post_description);
        title.setText(values[position]);
        return rowView;
    }
}
