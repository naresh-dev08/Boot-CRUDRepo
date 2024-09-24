package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_CUSTOMER_TAB")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	//@GeneratedValue(strategy= GenerationType.AUTO) //generates value to the CID property automatically startng with 1
	@Column(name="CID")
	@Id
	@SequenceGenerator(name="gen1", sequenceName = "CUSTCID_SEQ",initialValue = 1, allocationSize = 1)  // customized sequence value
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
	private Integer cno;
	
	@NonNull
	private String cname;
	
	@NonNull
	@Transient   //insert null value to the db so they can use this column in future without disturbing the table 
	@Column(name="CADD", length = 20)
	private String caddrs;
	
	@NonNull
	@Column(name="BILLAMT") // column name optional when column name is matched with db table
	private Float billAmt;

}
