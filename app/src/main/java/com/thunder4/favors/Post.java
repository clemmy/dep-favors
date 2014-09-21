package com.thunder4.favors;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by raywan on 2014-09-20.
 */
public class Post
{
    public String titleField;
    public String catField;
    public String descriptField;
    public Bitmap profilePic;


    public Post(String title, String category, String description, Bitmap profile)
    {
        this.titleField = title;
        this.catField = category;
        this.descriptField = description;
        this.profilePic = profile;
    }
}
