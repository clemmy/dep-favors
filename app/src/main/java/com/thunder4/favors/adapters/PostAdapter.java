package com.thunder4.favors.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thunder4.favors.R;
import com.thunder4.favors.models.Post;

/**
 * Created by raywan on 2014-09-20.
 */
public class PostAdapter extends ArrayAdapter<Post> {
    private final Context context;
    private final Post[] posts;

    public PostAdapter(Context context, Post[] posts) {
        super(context, R.layout.post_layout, posts);
        this.context = context;
        this.posts = posts;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.post_layout, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.post_title);
        TextView description = (TextView) rowView.findViewById(R.id.post_description);
        TextView category = (TextView) rowView.findViewById(R.id.post_category);
        ImageView profile = (ImageView) rowView.findViewById(R.id.post_profile);
        title.setText(posts[position].titleField);
        category.setText(posts[position].catField);
        description.setText(posts[position].descriptField);
        profile.setImageBitmap(posts[position].profilePic);
        return rowView;
    }
}
