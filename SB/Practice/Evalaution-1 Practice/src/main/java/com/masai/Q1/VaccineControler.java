package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.exception.VaccineNotFoundException;
import com.covid.model.Vaccine;
import com.covid.service.VaccineService;

@RestController
@RequestMapping("/service")
public class VaccineControler {
	
	@Autowired
	  private VaccineService  serviceVaccine;
	
	@PostMapping("/vaccine")
	  public ResponseEntity<Vaccine> AddVaccine( @RequestBody Vaccine vaccine) throws VaccineNotFoundException{
		  
		     return new ResponseEntity<Vaccine>(serviceVaccine.addVaccine(vaccine),HttpStatus.CREATED);
	  }
	
	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> gettAllVaccine() throws VaccineNotFoundException{
		
		   List<Vaccine> allvaccine= serviceVaccine.getAllVaccine();
		   
		   return new ResponseEntity<List<Vaccine>>(allvaccine,HttpStatus.OK);
	}
	
	@GetMapping("/vaccines/{vaccineName}")
	public ResponseEntity<List<Vaccine>> getVaccineByName(  @PathVariable("vaccineName")  String vaccineName) throws VaccineNotFoundException{
		
		       List<Vaccine> vaccineByName= serviceVaccine.getVaccineByVccineName(vaccineName);
		       
		       return new ResponseEntity<List<Vaccine>>(vaccineByName, HttpStatus.OK);
	}
	
	@GetMapping("vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccinesById( @PathVariable("vaccineId") Integer vaccineId) throws VaccineNotFoundException{
		
		  return new ResponseEntity<Vaccine>(serviceVaccine.getVaccineById(vaccineId),HttpStatus.OK);
	}

	@PutMapping("/vaccine")
	  public ResponseEntity<Vaccine> UpdateVaccine( @RequestBody Vaccine vaccine) throws VaccineNotFoundException{
		  
		     return new ResponseEntity<Vaccine>(serviceVaccine.updateVaccine(vaccine),HttpStatus.OK);
	  }
	
	@DeleteMapping("/vaccine")
	public ResponseEntity<Vaccine> DeleteVaccine( @RequestBody Vaccine vaccine) throws VaccineNotFoundException{
		
		return new ResponseEntity<Vaccine>(serviceVaccine.DeleteVaccine(vaccine),HttpStatus.OK);
	}
}
