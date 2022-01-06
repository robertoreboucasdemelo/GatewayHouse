package com.riachuelo.house.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.riachuelo.house.components.Inconsistency;
import com.riachuelo.house.components.ItemError;
import com.riachuelo.house.constants.Constants;
import com.riachuelo.house.exceptions.ResourceNotFoundException;
import com.riachuelo.house.models.CommissionSales;
import com.riachuelo.house.utils.Util;

@Service
public class CommissionSalesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommissionSalesService.class);
	
	@Value("${app.house.file.sale.path}")
    private String path;
	
	public List<CommissionSales> read(Inconsistency inconsistency) {
		
		LOGGER.info(Constants.STEP_READER_SALES);
		
		List<CommissionSales> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
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
			throw new ResourceNotFoundException(Constants.FILE_NOT_FOUND);
		} catch (IOException e) {
			throw new ResourceNotFoundException(Constants.IO_ERROR);
		} catch (NumberFormatException| ParseException e) {
			// Create a process to write a file trough a list
			e.printStackTrace();
		}
		
		ItemError error = new ItemError();		
		error.setId(1);
		error.setDescription("Erro 1");
		
		inconsistency.addInconsistency(error);
		
		ItemError error2 = new ItemError();		
		error2.setId(2);
		error2.setDescription("Erro 2");
		
		inconsistency.addInconsistency(error2);
	
		return list;
		
	}

}
