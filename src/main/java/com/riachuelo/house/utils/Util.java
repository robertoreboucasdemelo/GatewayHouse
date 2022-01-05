package com.riachuelo.house.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;

import org.springframework.web.client.RestTemplate;

import com.riachuelo.house.constants.Constants;

public class Util {
	
	public static String removeMonetarySymbol(String param){
		return param.replace(Constants.MONETARY_SYMBOL, "").trim();
	}
	
	public static BigDecimal formatAmount(String param) throws ParseException {
		 NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
		 return new BigDecimal(nf.parse(param).toString());
	}
	
	public static void ativaInterceptor(RestTemplate rest, boolean flag) {
		if (flag) {
			rest.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
		}
	}

}
