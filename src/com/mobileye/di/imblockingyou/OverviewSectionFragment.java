package com.mobileye.di.imblockingyou;

import com.mobileye.di.imblockingyou.OverviewActivity.SectionsPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class OverviewSectionFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public OverviewSectionFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.overview_blocked_fragment, container, false);
		
		Button button = (Button) rootView.findViewById(R.id.add_blocked_button);		
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "add",  Toast.LENGTH_LONG).show();
            }
        });
		button = (Button) rootView.findViewById(R.id.unblock_action_button);
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "unblock",  Toast.LENGTH_LONG).show();
            }
        });
		
		button = (Button) rootView.findViewById(R.id.block_action_button);
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "block",  Toast.LENGTH_LONG).show();
            }
        });
		
		return rootView;
	}
}