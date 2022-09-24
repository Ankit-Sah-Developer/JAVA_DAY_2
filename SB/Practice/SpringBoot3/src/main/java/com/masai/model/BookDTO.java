package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	private String name;
	private String author;
	private String publication;
	private String category;
	private Integer pages;
	private Integer price;
}
