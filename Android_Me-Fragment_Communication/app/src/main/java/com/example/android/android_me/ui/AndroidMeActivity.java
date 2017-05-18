/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {
    FragmentBodyPart fragmentBodyPart;
    FragmentHead fragmentHead;
    FragmentLegs fragmentLegs;
    private int bodyIndex;
    private int legsIndex;
    private int headIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        Bundle bundle=getIntent().getExtras();
        bodyIndex=bundle.getInt("bodyIndex");
        legsIndex=bundle.getInt("legsIndex");
        headIndex=bundle.getInt("headIndex");

            fragmentHead = new FragmentHead();
            fragmentBodyPart = new FragmentBodyPart();
            fragmentLegs = new FragmentLegs();
            fragmentHead.setmImageIds(AndroidImageAssets.getHeads());
            fragmentHead.setmListIndex(headIndex);
            fragmentBodyPart.setmListIndex(bodyIndex);
            fragmentLegs.setmListIndex(legsIndex);
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentHead).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.container1, fragmentBodyPart).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.container2, fragmentLegs).commit();


    }
}
