package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manishjoshi on 17/5/17.
 */

public class FragmentLegs extends Fragment {
    ImageView imageviewlegs;
    private List<Integer> mImageIds = AndroidImageAssets.getLegs();
    private int mListIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_legs, container, false);
        imageviewlegs = (ImageView) view.findViewById(R.id.imageviewlegs);
        if(savedInstanceState!=null){
            mListIndex=savedInstanceState.getInt("mListIndex");
            mImageIds=savedInstanceState.getIntegerArrayList("mImageIds");
        }
        imageviewlegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListIndex < mImageIds.size() - 1) {
                    mListIndex++;
                } else {
                    mListIndex = 0;
                }
                imageviewlegs.setImageResource(mImageIds.get(mListIndex));

            }
        });
        if (mImageIds != null) {
            imageviewlegs.setImageResource(mImageIds.get(mListIndex));
        }
        return view;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mListIndex", mListIndex);
        outState.putIntegerArrayList("mImageIds", (ArrayList<Integer>) mImageIds);
    }
}