package com.mobileye.di.imblockingyou;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Dror Kronstein
 * @copyright (C) 2014 Mobileye Ltd.
 */
public class EmployeeCarsFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public EmployeeCarsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.wiki_view, container, false);
		WebView wv = (WebView) rootView.findViewById(R.id.emplyee_cars_wiki);
		wv.setWebViewClient(new WebViewClient());
		wv.loadUrl("http://wiki.me-corp.lan/mw/index.php/Employee_Cars_New");
		return rootView;
	}
}
