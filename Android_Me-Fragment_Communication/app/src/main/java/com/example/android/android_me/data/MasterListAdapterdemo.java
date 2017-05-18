package com.example.android.android_me.data;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by manishjoshi on 17/5/17.
 */

public class MasterListAdapterdemo extends ArrayAdapter {
    List<Integer> androidImageAssetses = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    int layoutResourceID;
    Activity activity;
    Bitmap bm;

    public MasterListAdapterdemo(Activity context, int resource, List<Integer> androidImageAssetses) {
        super(context, resource, androidImageAssetses);
        this.layoutResourceID = resource;
        this.activity = context;
        this.androidImageAssetses=androidImageAssetses;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyViewHolder myViewHolder;
        View rowrootview=convertView;

        if (rowrootview == null) {
            myViewHolder=new MyViewHolder();
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            rowrootview = layoutInflater.inflate(layoutResourceID, parent, false);
            myViewHolder.imageView= (ImageView) rowrootview.findViewById(R.id.iv_masterlist);
            rowrootview.setTag(myViewHolder);
        }
        else{
            myViewHolder= (MyViewHolder) rowrootview.getTag();
        }
         bm = BitmapFactory.decodeResource(activity.getResources(),androidImageAssetses.get(position));

        myViewHolder.imageView.setImageBitmap(Bitmap.createScaledBitmap(bm, 130, 80, false));


        return rowrootview;
    }
     class MyViewHolder{
        ImageView imageView;
    }

}
