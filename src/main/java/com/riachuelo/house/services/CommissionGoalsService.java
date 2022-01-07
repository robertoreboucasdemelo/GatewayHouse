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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.riachuelo.house.components.Inconsistency;
import com.riachuelo.house.constants.Constants;
import com.riachuelo.house.exceptions.ResourceNotFoundException;
import com.riachuelo.house.models.CommissionGoals;
import com.riachuelo.house.models.ItemError;
import com.riachuelo.house.utils.Util;

@Service
public class CommissionGoalsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommissionGoalsService.class);
	
	@Autowired
	private Inconsistency inconsistency;
	
	@Value("${app.house.file.goal.path}")
    private String path;
	private String registration;
	private String salesman;
	List<CommissionGoals> list = new ArrayList<>();
	
	
	public List<CommissionGoals> read() {
		
		LOGGER.info(Constants.STEP_READER_GOALS);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			line = br.readLine();
			line = br.readLine();
			
			while(line != null) {				
				this.loadLine(line);		
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new ResourceNotFoundException(Constants.FILE_NOT_FOUND);
		} catch (IOException e) {
			throw new ResourceNotFoundException(Constants.IO_ERROR);
		}
			
		return list;
		
	}
	
	private void loadLine(String line) {
		
		String[] vector = line.split(";");
		try {
			
			this.loadData(vector[2],vector[3]);
			
			CommissionGoals commissionGoals = new CommissionGoals.CommissionGoalsBuilder()
					.store(Long.parseLong(vector[0]))
					.saleMonth(vector[1])
					.registration(Long.parseLong(vector[2]))
					.salesman(vector[3])
					.individualGoal(Util.formatAmount(vector[4]))
					.individualSale(Util.formatAmount(vector[5]))
					.totalGoal(Util.formatAmount(vector[6]))
					.totalSale(Util.formatAmount(vector[7]))
					.build();
			
			list.add(commissionGoals);
		} catch (NumberFormatException | ParseException e) {
			this.loadError();
		}
	}
	
	private void loadData(String registration , String salesman) {
		this.registration = registration;
		this.salesman = salesman; 
	}
	
	private void loadError() {
		
		ItemError error = new ItemError.ItemErrorBuilder()
				.file(Constants.FILE_GOALS)
				.registration(registration)
				.salesman(salesman)
				.description(Constants.ERROR_GOALS)
				.build();
		
		inconsistency.addInconsistency(error);
	}

}
