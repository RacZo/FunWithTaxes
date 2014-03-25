/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oscarsalguero.funwithtaxes.R;
import com.oscarsalguero.funwithtaxes.model.Item;

public class ItemReviewListAdapter extends BaseAdapter {
	private List<Item> items;
	private Context context;
	private int numItems = 0;

	public ItemReviewListAdapter(final List<Item> items, Context context) {
		this.items = items;
		this.context = context;
		this.numItems = items.size();
	}

	public int getCount() {
		return numItems;
	}

	public Item getItem(int position) {
		return items.get(position);
	}

	public long getItemId(int position) {
		return ((Item)items.get(position)).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		final Item item = items.get(position);
		final RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(
				context).inflate(R.layout.list_item_review, parent, false);
		TextView txtLabelQuantity = (TextView) itemLayout
				.findViewById(R.id.text_view_quantity);
		txtLabelQuantity.setText(String.valueOf(item.getQuantity()));
		TextView txtLabelDescription = (TextView) itemLayout
				.findViewById(R.id.text_view_description);
		txtLabelDescription.setText(item.getDescription());
		TextView txtLabelPrice = (TextView) itemLayout
				.findViewById(R.id.text_view_price);
		txtLabelPrice.setText("$" + item.getPrice());
		return itemLayout;
	}

}
