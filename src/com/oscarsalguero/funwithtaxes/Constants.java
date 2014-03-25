/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Constants {

	public static final String SPACE = " ";
	public static final String LINE_BREAK = "\n";
	public static final BigDecimal SALES_TAX_BASE = new BigDecimal("0.10");
	public static final BigDecimal SALES_TAX_IMPORTED = new BigDecimal("0.05");
	public static final BigDecimal ROUND_TAX_TO = new BigDecimal("0.05");
	public static final DecimalFormat moneyFormat = new DecimalFormat("#0.00");
	public static final String OUTPUT_ITEMS = "OUTPUT_ITEMS";
	public static final String SELECTED_INPUT = "SELECTED_INPUT";
}
