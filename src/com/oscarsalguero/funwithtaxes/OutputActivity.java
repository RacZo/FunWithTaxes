/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes;

import java.math.BigDecimal;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

import com.oscarsalguero.funwithtaxes.model.Item;
import com.oscarsalguero.funwithtaxes.util.Utilities;

public class OutputActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output);
		EditText editTextOutput = (EditText) findViewById(R.id.edit_text_output);
		Intent intent = getIntent();
		int selectedInput = intent.getIntExtra(Constants.SELECTED_INPUT, 1);
		@SuppressWarnings("unchecked")
		ArrayList<Item> items = (ArrayList<Item>) intent
				.getSerializableExtra(Constants.OUTPUT_ITEMS);

		editTextOutput.append("Output " + selectedInput + ": ");
		editTextOutput.append(Constants.LINE_BREAK);
		for (Item item : items) {
			editTextOutput.append(item.getOutput());
		}
		double salesTaxes = calculateSalesTaxes(items);
		editTextOutput.append("Sales Taxes: "
				+ Constants.moneyFormat.format(salesTaxes));
		editTextOutput.append(Constants.LINE_BREAK);
		editTextOutput.append("Total: "
				+ Constants.moneyFormat
						.format(calculateTotal(items, salesTaxes)));
	}

	private double calculateSalesTaxes(ArrayList<Item> items) {
		double salesTaxes = 0.0;
		for (Item item : items) {
			salesTaxes = salesTaxes
					+ Utilities.roundSalesTax(
							new BigDecimal(item.getPrice()).multiply(item
									.getSalesTax())).doubleValue();
		}
		return salesTaxes;
	}

	private double calculateTotal(ArrayList<Item> items, double salesTaxes) {
		double total = 0.0;
		for (Item item : items) {
			total = (total + item.getPriceWithSalesTax().doubleValue());
		}
		return total;
	}

}
