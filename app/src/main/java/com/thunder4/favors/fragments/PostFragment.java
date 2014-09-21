package com.thunder4.favors.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thunder4.favors.APostActivity;
import com.thunder4.favors.models.Post;
import com.thunder4.favors.adapters.PostAdapter;
import com.thunder4.favors.R;

/**
 * Created by raywan on 2014-09-20.
 */
public class PostFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        //test posts please ignore
        Post post1 = new Post("post1","category", "description", null);
        Post post2 = new Post("post2","category", "description", null);
        Post post3 = new Post("post3","category", "description", null);
        Post post4 = new Post("post4","category", "description", null);
        Post post5 = new Post("post5","category", "description", null);
        Post post6 = new Post("post6","category", "description", null);
        Post post7 = new Post("post7","category", "description", null);

        Post[] posts = {post1, post2, post3, post4,post5,post6,post7};
        //TODO: populate posts with dal


        PostAdapter adapter = new PostAdapter(getActivity(),posts);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(),APostActivity.class);
        startActivity(intent);

    }
}
