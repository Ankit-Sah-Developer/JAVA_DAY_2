package com.masai.Q2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.masai.Q2")
@PropertySource(value = "a.properties")
public class AppConfig2 {
	
	@Value("#{'${cities}'.split(',')}")
	public List<String> city;
//	cities=Mumbai,Pune,Nashik,Bengalore,Chennai
	
	@Autowired
	public Environment ev;
	
	@Bean
	public List<String> cities(){
		
		List<String> cities = new ArrayList<>();
		
		cities.addAll(city);
		
//		cities.add(ev.getProperty("c1"));
//		cities.add(ev.getProperty("c2"));
//		cities.add(ev.getProperty("c1"));
//		cities.add(ev.getProperty("c2"));
//		cities.add(ev.getProperty("c1"));
		
		
		return cities ;
	}
	
	
	
	@Bean
	public List<Student> students(){
		
		List<Student> st = new ArrayList<>();
		
		st.add(new Student(10,"Ram",780));
		st.add(new Student(11,"Shyam",740));
		st.add(new Student(12,"Sita",720));
		st.add(new Student(13,"Gita",750));
		st.add(new Student(14,"Tom",710));
		
		return st;
		
	}
	
	@Bean
	public Map<Student, String> theMap(){
		
		Map<Student, String> theMap = new HashMap<>();
		
		for(int i=0;i<5;i++) {
			theMap.put(students().get(i), cities().get(i));
		}
		
		return theMap;
		
	}
	
}
