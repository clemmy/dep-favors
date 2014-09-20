package com.thunder4.favors;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by raywan on 2014-09-20.
 */
public class PostFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        String[] values = {"asdf", "asdkfjaksd", "asdfjkj"};
        PostAdapter adapter = new PostAdapter(getActivity(),values);
        setListAdapter(adapter);
        return view;
    }
}
