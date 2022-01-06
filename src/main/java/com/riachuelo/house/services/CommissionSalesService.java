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
import com.riachuelo.house.constants.Constants;
import com.riachuelo.house.exceptions.ResourceNotFoundException;
import com.riachuelo.house.models.CommissionSales;
import com.riachuelo.house.models.ItemError;
import com.riachuelo.house.utils.Util;

@Service
public class CommissionSalesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommissionSalesService.class);
	
	@Value("${app.house.file.sale.path}")
    private String path;
	private Long registration;
	private String salesman;
	
	List<CommissionSales> list = new ArrayList<>();
	
	public List<CommissionSales> read(Inconsistency inconsistency) {
		
		LOGGER.info(Constants.STEP_READER_SALES);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			line = br.readLine();
			
			while (line != null) {
				this.loadLine(line, inconsistency);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new ResourceNotFoundException(Constants.FILE_NOT_FOUND);
		} catch (IOException e) {
			throw new ResourceNotFoundException(Constants.IO_ERROR);
		} 
		
		return list;
		
	}
	
	private void loadLine(String line, Inconsistency inconsistency) {
		
		String[] vector = line.split(";");
		try {
			
			this.loadData(Long.parseLong(vector[2]),vector[3]);
			
			CommissionSales commissionSales = new CommissionSales.CommissionSalesBuilder()
					.store(Long.parseLong(vector[0]))
					.corporateName(vector[1])
					.registration(Long.parseLong(vector[2]))
					.salesman(vector[3])
					.amount(Util.formatAmount(Util.removeMonetarySymbol(vector[4])))
					.indicator(vector[5])
					.build();

			list.add(commissionSales);
		} catch (NumberFormatException | ParseException e) {
			this.loadError(inconsistency);
		}
	}
	
	private void loadData(Long registration , String salesman) {
		this.registration = registration;
		this.salesman = salesman; 
	}
	
	private void loadError(Inconsistency inconsistency) {
		
		ItemError error = new ItemError.ItemErrorBuilder()
				.file(Constants.FILE_GOALS)
				.registration(registration)
				.salesman(salesman)
				.description(Constants.ERROR_GOALS)
				.build();
		
		inconsistency.addInconsistency(error);
	}

}
