package com.mobileye.di.imblockingyou;

import java.io.IOException;
import java.io.InputStream;

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
		InputStream is = getCurrentList();
		
		wv.setWebViewClient(new WebViewClient());
		String text = readListFile(is);
		
		wv.loadData(text, "text/html; charset=UTF-8", null);
		return rootView;
	}


	private String readListFile(InputStream is) {
		byte[] buf;
		try {
			buf = new byte[is.available()];
		} catch (IOException e1) {
			e1.printStackTrace();
			buf = new byte[128];
		}
		try {
			is.read(buf);
		} catch (IOException e) {
			// TODO: We should probably do something here
			e.printStackTrace();
		}
		return renderHtml(new String(buf));
	}

	private String renderHtml(String str) {
		// Turns the list into an HTML string that can be viewed...
		String res;
		res = str.replace("border=&quot;1&quot; cellpadding=&quot;2&quot;", "").replace("{", "<table border=\"1\" cellpadding=\"2\"><tr>")
				.replace("}", "</table>").replace("|-", "</tr><tr>").replace("|", "</td><td>");

		return res;
	}


	private InputStream getCurrentList() {
		return getResources().openRawResource(R.raw.initial_employee_list);
	}
}
