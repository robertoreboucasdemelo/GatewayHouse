package com.riachuelo.house.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.riachuelo.house.constants.Constants;
import com.riachuelo.house.models.CommissionSales;
import com.riachuelo.house.utils.Util;

@Service
public class CommissionSalesService {
	
	public void read() {
		
		List<CommissionSales> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(Constants.PATH))){
			
			String line = br.readLine();
			line = br.readLine();
			
			while(line != null) {
				
				String[] vector = line.split(";");
				
				CommissionSales commissionSales = new CommissionSales.CommissionSalesBuilder()
						.store(Long.parseLong(vector[0]))
						.corporateName(vector[1])
						.registration(Long.parseLong(vector[2]))
						.salesman(vector[3])
						.amount(Util.formatAmount(Util.removeMonetarySymbol(vector[4])))
						.indicator(vector[5])
						.build();
				
				list.add(commissionSales);
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for (CommissionSales sc : list) {
			System.out.println(sc);
		}
		
	}

}
