package com.example.ntumobile;


import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends Filter {
    private social_jio_sports_sessionAdapter mAdapter;
    ArrayList<social_jio_sports_session> list;
    ArrayList<social_jio_sports_session> listFull;

    public FilterActivity(social_jio_sports_sessionAdapter mAdapter, ArrayList<social_jio_sports_session> list) {
        super();
        this.mAdapter = mAdapter;
        this.list = list;
        this.listFull = new ArrayList<>(list);
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        List<social_jio_sports_session> filteredList = new ArrayList<>();
        final FilterResults results = new FilterResults();
        // if no input show original array list
        if (constraint.length() == 0 || constraint == null) {
            filteredList.addAll(listFull);
        } else {
            String filterPattern = constraint.toString().toLowerCase();
            // if there is input add filtered items to another array list
            for (social_jio_sports_session item : listFull) {
                if (item.getActivity().toLowerCase().contains(filterPattern)) {
                    filteredList.add(item);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }

    @Override
    protected void publishResults (CharSequence constraint, FilterResults results){
        mAdapter.list.clear();
        mAdapter.list.addAll((ArrayList<social_jio_sports_session>) results.values);
        mAdapter.notifyDataSetChanged();
    }
}
