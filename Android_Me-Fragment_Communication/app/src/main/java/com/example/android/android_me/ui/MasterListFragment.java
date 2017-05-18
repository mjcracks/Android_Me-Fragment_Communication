package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.*;

/**
 * Created by manishjoshi on 17/5/17.
 */

public class MasterListFragment extends Fragment {
    GridView gridview;
    OnImageClick onImageClick;
    MasterListAdapterdemo masterListAdapter;
    MasterListAdapter masterListAdapter1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.master_list_fragment,container,false);
        gridview= (GridView) view.findViewById(R.id.gridview);
        masterListAdapter=new MasterListAdapterdemo(getActivity(),R.layout.master_list,AndroidImageAssets.getAll());
        masterListAdapter1=new MasterListAdapter(getActivity(),AndroidImageAssets.getAll());
        gridview.setAdapter(masterListAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onImageClick.onImageSelected(position);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onImageClick= (OnImageClick) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    interface OnImageClick{
        void onImageSelected(int position);
    }
}
