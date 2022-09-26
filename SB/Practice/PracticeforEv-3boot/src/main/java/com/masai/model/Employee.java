package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name")
	@Size(min = 3,max = 20, message = "Invalid name - min 3 letters and max 20 required")
	private String name;
	
	private Double salary;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid name")
	@Size(min = 3,max = 20, message = "Invalid name - min 3 letters and max 20 required")
	private String deptName;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid city name")
	@Size(min = 3,max = 20, message = "Invalid name - min 3 letters and max 20 required")
	private String city;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid state name")
	@Size(min = 2,max = 20, message = "Invalid name - min 3 letters and max 20 required")
	private String state;
	
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid pincode... must be of 6 digits")
	private String pincode;
}
