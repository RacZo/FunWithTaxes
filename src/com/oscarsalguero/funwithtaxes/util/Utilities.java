/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes.util;

import java.math.BigDecimal;

import com.oscarsalguero.funwithtaxes.Constants;

public class Utilities {
	
	public static BigDecimal roundSalesTax(BigDecimal salesTax) { 
		BigDecimal roundedSalesTax = salesTax.divide(Constants.ROUND_TAX_TO);  
		roundedSalesTax = new BigDecimal(Math.ceil(roundedSalesTax.doubleValue()));  
		roundedSalesTax = roundedSalesTax.multiply(Constants.ROUND_TAX_TO);  
        return roundedSalesTax;  
    }
	
}
