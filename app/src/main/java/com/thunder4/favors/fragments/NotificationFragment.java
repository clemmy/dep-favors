package com.thunder4.favors.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thunder4.favors.APostActivity;
import com.thunder4.favors.R;
import com.thunder4.favors.adapters.NotificationAdapter;
import com.thunder4.favors.models.Notification;

/**
 * Created by raywan on 2014-09-20.
 */
public class NotificationFragment extends ListFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        Notification notif1 = new Notification("desc1", null);
        Notification notif2 = new Notification("desc2", null);
        Notification notif3 = new Notification("desc3", null);
        Notification notif4 = new Notification("desc4", null);
        Notification notif5 = new Notification("desc5", null);
        Notification notif6 = new Notification("desc6", null);

        Notification[] notifs = {notif1,notif2,notif3,notif4,notif5,notif6};

        NotificationAdapter adapter = new NotificationAdapter(getActivity(), notifs);
        setListAdapter(adapter);
        return view;
    }


}
