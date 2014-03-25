/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.oscarsalguero.funwithtaxes.Constants;
import com.oscarsalguero.funwithtaxes.util.Utilities;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 270893780017334870L;
	
	public static final int ITEM_TYPE_BOOK = 10;
	public static final int ITEM_TYPE_FOOD = 20;
	public static final int ITEM_TYPE_MEDICINES = 30;
	public static final int ITEM_TYPE_OTHER = 40;
	
	private int id;
	private int type;
	private int quantity;
	private String description;
	private float price;
	private boolean imported;
	
	public Item() {
		super();
	}
	
	public Item(int id, int type, int quantity, String description, float price, boolean imported) {
		super();
		this.id = id;
		this.type = type;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.imported = imported;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getOrigin() {
		return type;
	}

	public void setOrigin(int origin) {
		this.type = origin;
	}

	public boolean isTaxable() {
		return imported;
	}

	public void setTaxable(boolean taxable) {
		this.imported = taxable;
	}
	
	public String getOutput() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(quantity);
		stringBuilder.append(Constants.SPACE);
		stringBuilder.append(description);
		stringBuilder.append(Constants.SPACE);
		stringBuilder.append(":");
		stringBuilder.append(Constants.SPACE);
		stringBuilder.append("$");
		stringBuilder.append(Constants.moneyFormat.format(getPriceWithSalesTax().doubleValue()));
		stringBuilder.append(Constants.LINE_BREAK);
		return stringBuilder.toString();
	}
	
	public BigDecimal getPriceWithSalesTax(){
		return new BigDecimal(price).add(Utilities.roundSalesTax(new BigDecimal(price).multiply(getSalesTax())));
	}
	
	public BigDecimal getSalesTax(){
		BigDecimal salesTax;
		if(type == Item.ITEM_TYPE_BOOK || type == Item.ITEM_TYPE_FOOD || type == Item.ITEM_TYPE_MEDICINES){
			salesTax = new BigDecimal("0.00");
		}else{
			salesTax = Constants.SALES_TAX_BASE;
		}
		if(imported){
			salesTax = salesTax.add(Constants.SALES_TAX_IMPORTED);
		}
		return salesTax;
	}

}
