/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oscarsalguero.funwithtaxes.R;

public class ReviewInputListFragment extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_list_review_input, container, false);
	}

}
