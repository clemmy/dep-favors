package com.thunder4.favors;

import android.graphics.Bitmap;

/**
 * Created by Guozhen on 2014-09-20.
 */
public class Notification {
    public String descriptField;
    public Bitmap profilePic;

    public Notification(String description, Bitmap profile)
    {
        this.descriptField = description;
        this.profilePic = profile;
    }
}
