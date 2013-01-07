package org.c_base.c_beam;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class C_outListFragment extends ArrayListFragment {
	ArrayList<String> items = new ArrayList<String>();
	ListAdapter adapter;
	C_beam c_beam;
	SharedPreferences sharedPref;
	
	public C_outListFragment() {
		c_beam = new C_beam(this.getActivity());
	}
	
	public void clear() {
		items.clear();
	}
	public void addItem(String item) {
		items.add(item);
		 //((ArrayAdapter)getListView().getAdapter()).notifyDataSetChanged(); 
	}
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        adapter = new C_outAdapter(getActivity(),
                android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
        if (sharedPref.getBoolean("pref_c_theme", true)) getListView().setDividerHeight(0);
		getListView().setHapticFeedbackEnabled(true);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + items.get((int) id));
        c_beam.play(items.get((int) id));
        Toast.makeText(v.getContext(), R.string.c_out_sound_played, Toast.LENGTH_LONG).show();
    }
    
    @SuppressWarnings("rawtypes")
	public class C_outAdapter extends ArrayAdapter {
		private static final String TAG = "C_outAdapter";
		private ArrayList<String> items;
		private Context context;

		@SuppressWarnings("unchecked")
		public C_outAdapter(Context context, int textViewResourceId, ArrayList<String> items) {
			super(context, textViewResourceId, items);
			this.context = context;
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView view = (TextView) super.getView(position, convertView, parent);
			String u = items.get(position);
			if (sharedPref.getBoolean("pref_c_theme", true)) view.setBackgroundResource(R.drawable.listitembg);
			view.setPadding(25, 30, 25, 30);
			Helper.setFont(getActivity(), view);
			return view;
		}
	}
    
   
}	
