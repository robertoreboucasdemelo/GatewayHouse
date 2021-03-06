package com.riachuelo.house.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.riachuelo.house.models.ItemError;

@Component
public class Inconsistency implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ItemError> inconsistencies = new ArrayList<>();

	public List<ItemError> getInconsistencies() {
		return inconsistencies;
	}
	
	public void addInconsistency(ItemError itemError) {
		inconsistencies.add(itemError);
	}

	@Override
	public String toString() {
		return "Inconsistency [inconsistencies=" + inconsistencies + "]";
	}
	
	public ItemError loadError(String registration, String salesman, String file, String description) {

		return new ItemError.ItemErrorBuilder()
				.file(file)
				.registration(registration)
				.salesman(salesman)
				.description(description)
				.build();

	}
	
	

}
