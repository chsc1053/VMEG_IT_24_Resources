package com.android_project.listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MenuFragment extends ListFragment {
    String[] items = new String[] { "Tea","Coffee","Milk","Juice","Green Tea" };
    String[] prices = new String[]{"Rs 10","Rs 15","Rs 20","Rs 30","Rs 10"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_menu, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DetailFragment txt = (DetailFragment)getFragmentManager().findFragmentById(R.id.f2);
        txt.change("Item: "+ items[position],"Price: "+ prices[position]);
        getListView().setSelector(android.R.color.holo_orange_dark);
    }
}