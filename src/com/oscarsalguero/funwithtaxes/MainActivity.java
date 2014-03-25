/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.oscarsalguero.funwithtaxes.adapter.InputListAdapter;
import com.oscarsalguero.funwithtaxes.fragments.InputSelectionListFragment;
import com.oscarsalguero.funwithtaxes.model.Input;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		InputSelectionListFragment selectInputList = (InputSelectionListFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_input_selection);

		final ArrayList<Input> items = new ArrayList<Input>();
		items.add(new Input(1, getString(R.string.mock_data_input_1)));
		items.add(new Input(2, getString(R.string.mock_data_input_2)));
		items.add(new Input(3, getString(R.string.mock_data_input_3)));

		InputListAdapter adapter = new InputListAdapter(items, this);
		selectInputList.setListAdapter(adapter);

	}

}
