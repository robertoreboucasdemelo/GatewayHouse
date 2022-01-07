package com.riachuelo.house.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
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
	
	public static void activeInterceptor(RestTemplate rest, boolean flag) {
		if (flag) {
			rest.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
		}
	}
	
	public static String recoveryFileName() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		
		return (Constants.OUTPUT_FILE_NAME.concat(date).concat(Constants.OUTPUT_EXTENSION));
	}

}
