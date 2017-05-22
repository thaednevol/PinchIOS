package com.ach.soi.empresarial.liquidacion.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatValues {
	
	
	public static String formatLongvalueCurrency ( Long value ){
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("ES","CO"));
		String moneyString = formatter.format(value);
		return moneyString;
	}
}
