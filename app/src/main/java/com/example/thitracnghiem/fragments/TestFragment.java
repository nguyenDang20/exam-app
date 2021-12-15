package com.example.thitracnghiem.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.thitracnghiem.R;
import com.example.thitracnghiem.TestActivity;
import com.example.thitracnghiem.activity.adapters.CustomAdapter;
import com.example.thitracnghiem.model.CustomItem;

import java.util.ArrayList;

public class TestFragment extends Fragment implements View.OnClickListener {
    private View v;
    private Button btnStart,btnStart1,btnStart2;
    private String tmp;

    Spinner customSpinner;
    ArrayList<CustomItem> customList;
    private String dethi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_test, container, false);
        btnStart=v.findViewById(R.id.btn_start);
//        btnStart1=v.findViewById(R.id.btn_start1);
//        btnStart2=v.findViewById(R.id.btn_start2);

        btnStart.setOnClickListener(this);
//        btnStart1.setOnClickListener(this);
//        btnStart2.setOnClickListener(this);

//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(v.getContext(), TestActivity.class);
//                getActivity().startActivity(intent);
//            }
//        });
        customList = getCustomList();
        CustomAdapter adapterC=new CustomAdapter(v.getContext(),customList);
        customSpinner=v.findViewById(R.id.dropListT);
        if (customSpinner!=null) {
            customSpinner.setAdapter(adapterC);
            customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    CustomItem item=(CustomItem)adapterView.getSelectedItem();
                    dethi=item.getSpinnerItemName();

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        return v;


    }

    private ArrayList<CustomItem> getCustomList() {
        customList=new ArrayList<>();
        customList.add(new CustomItem("LuyThua"));
        customList.add(new CustomItem("Loga"));
        customList.add(new CustomItem("HamsoLoga"));
        return customList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start://Logarit-LuyThua
                tmp="LuyThua";
                break;
//            case R.id.btn_start1://Logarit-Loga
//                tmp="Loga";
//                break;
//            case R.id.btn_start2://Logarit-Hàm số Loga
//                tmp="HamsoLoga";
//                break;
        }
        Intent intent=new Intent(v.getContext(), TestActivity.class);
        intent.putExtra(dethi,dethi);
        getActivity().startActivity(intent);
    }

}