package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Data
@AllArgsConstructor
@Entity
@Table(name="country")
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Country {

	@Id
	@Column(name="co_code")
	private String code;

	@NonNull
	@Column(name="co_name")
	private String name;
	
	

}
