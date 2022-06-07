package com.it.anoopit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AdminApiFormBo {
	private Integer adminId;
	private String adminName;
	private Long mobileNo;
	private String gender;
	private String adminEmail;
	private String activeStatus;
	private Integer ssn;
	
	private LocalDate adminStartDate;
	private LocalDate adminEndDate;
	
	private LocalDate planUpdateDate;
	

}
