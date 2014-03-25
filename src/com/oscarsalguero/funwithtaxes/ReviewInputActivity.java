/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.oscarsalguero.funwithtaxes.adapter.ItemReviewListAdapter;
import com.oscarsalguero.funwithtaxes.fragments.ReviewInputListFragment;
import com.oscarsalguero.funwithtaxes.model.Item;

public class ReviewInputActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review_input);

		Button buttonOutput = (Button) findViewById(R.id.button_output);

		ReviewInputListFragment reviewInputList = (ReviewInputListFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_input_review);

		Intent intent = getIntent();
		final int selectedInput = (int) intent.getLongExtra(
				Constants.SELECTED_INPUT, 1);

		final ArrayList<Item> items = new ArrayList<Item>();
		switch (selectedInput) {
		case 1:
			items.add(new Item(1, Item.ITEM_TYPE_BOOK, 1,
					getString(R.string.mock_data_item_book), 12.49f, false));
			items.add(new Item(2, Item.ITEM_TYPE_OTHER, 1,
					getString(R.string.mock_data_item_music_cd), 14.99f, false));
			items.add(new Item(3, Item.ITEM_TYPE_FOOD, 1,
					getString(R.string.mock_data_item_chocolate_bar), 0.85f,
					false));
			break;
		case 2:
			items.add(new Item(1, Item.ITEM_TYPE_FOOD, 1,
					getString(R.string.mock_data_item_imported_box_chocolates),
					10.00f, true));
			items.add(new Item(
					2,
					Item.ITEM_TYPE_OTHER,
					1,
					getString(R.string.mock_data_item_imported_bottle_of_perfume),
					47.50f, true));
			break;
		case 3:
			items.add(new Item(
					1,
					Item.ITEM_TYPE_OTHER,
					1,
					getString(R.string.mock_data_item_imported_bottle_of_perfume),
					27.99f, true));
			items.add(new Item(2, Item.ITEM_TYPE_OTHER, 1,
					getString(R.string.mock_data_item_bottle_of_perfume),
					18.99f, false));
			items.add(new Item(
					3,
					Item.ITEM_TYPE_MEDICINES,
					1,
					getString(R.string.mock_data_item_packet_of_headache_pills),
					9.75f, false));
			items.add(new Item(4, Item.ITEM_TYPE_FOOD, 1,
					getString(R.string.mock_data_item_imported_box_chocolates),
					11.25f, true));
			break;
		}

		ItemReviewListAdapter adapter = new ItemReviewListAdapter(items, this);
		reviewInputList.setListAdapter(adapter);

		buttonOutput.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), OutputActivity.class);
				intent.putExtra(Constants.OUTPUT_ITEMS, items);
				intent.putExtra(Constants.SELECTED_INPUT, selectedInput);
				startActivity(intent);
			}
		});

	}

}
