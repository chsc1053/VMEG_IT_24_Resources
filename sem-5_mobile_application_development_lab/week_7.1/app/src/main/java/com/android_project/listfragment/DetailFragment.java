package com.android_project.listfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class DetailFragment extends Fragment {
    TextView item, price;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        item = (TextView) view.findViewById(R.id.item);
        price = (TextView) view.findViewById(R.id.price);
        return view;
    }
    public void change(String items, String prices) {
        item.setText(items);
        price.setText(prices);
    }
}