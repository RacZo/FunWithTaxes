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
import com.oscarsalguero.funwithtaxes.model.Input;

public class InputListAdapter extends BaseAdapter {
	private List<Input> items;
	private Context context;
	private int numItems = 0;

	public InputListAdapter(final List<Input> items, Context context) {
		this.items = items;
		this.context = context;
		this.numItems = items.size();
	}

	public int getCount() {
		return numItems;
	}

	public Input getItem(int position) {
		return items.get(position);
	}

	public long getItemId(int position) {
		return ((Input)items.get(position)).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		final Input item = items.get(position);
		final RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(
				context).inflate(R.layout.list_item_input, parent, false);
		TextView txtLabelQuantity = (TextView) itemLayout
				.findViewById(R.id.text_view_name);
		txtLabelQuantity.setText(String.valueOf(item.getName()));
		return itemLayout;
	}

}
