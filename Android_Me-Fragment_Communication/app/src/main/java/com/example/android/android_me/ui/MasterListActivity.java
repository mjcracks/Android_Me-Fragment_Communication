package com.example.android.android_me.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Created by manishjoshi on 17/5/17.
 */

public class MasterListActivity extends AppCompatActivity implements MasterListFragment.OnImageClick {
    private int bodyIndex;
    private int legsIndex;
    private int headIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masterlistactivity);

    }

    @Override
    public void onImageSelected(int position) {
        int bodypartnumber = position / 12;

        int listIndex = position - 12 * bodypartnumber;
        switch (bodypartnumber) {
            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;

            case 2:
                legsIndex = listIndex;
                break;
        }
        Bundle bundle=new Bundle();
        bundle.putInt("headIndex",headIndex);
        bundle.putInt("bodyIndex",bodyIndex);
        bundle.putInt("legsIndex",legsIndex);

        final Intent intent=new Intent(MasterListActivity.this,AndroidMeActivity.class);
        intent.putExtras(bundle);
        findViewById(R.id.nextbuton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(intent);
            }
        });
    }
}
