package com.demo.qvcreplicate;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> mListDataHeader;
    private HashMap<String, List<String>> mListDataChild;
    ExpandableListView expandableListView;

    public MyExpandableListAdapter (Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild, ExpandableListView view){
        this.mContext = context;
        this. mListDataHeader = listDataHeader;
        this.mListDataChild = listDataChild;
        this.expandableListView = view;
    }


    @Override
    public int getGroupCount() {
        return mListDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        int childCount = 0;
        if(i != 2){
            childCount = this.mListDataChild.get(this.mListDataHeader.get(i)).size();
        }
        return childCount;
    }

    @Override
    public Object getGroup(int i) {
        return mListDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.mListDataChild.get(this.mListDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
//        ExpandedMenuModel expandedMenuModel = (ExpandedMenuModel)getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menulist_header, null);
        }
        TextView tvMenuText = view.findViewById(R.id.tvMenuText);
        tvMenuText.setText(String.valueOf(getGroup(i)));
        tvMenuText.setTypeface(null, Typeface.BOLD);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater= (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menulist_sub, null);
        }

        TextView tvMenuText = view.findViewById(R.id.tvMenuText);
        tvMenuText.setText(String.valueOf(getChild(i, i1)));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
