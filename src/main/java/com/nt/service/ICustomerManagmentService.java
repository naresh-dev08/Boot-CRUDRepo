package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerManagmentService {
	public String registerCustomer(Customer cust);
	public String registerGroupOfCustomer(Iterable<Customer> customers);
	public boolean isCustomerAvailable(Integer id);
	public Long getCustomersCount();
	public Iterable<Customer> getAlICustomers();
	public Iterable<Customer> getCustomersById(Iterable<Integer> ids);
	public String showCustomerById(int id);
	public Customer findCustomerById(int id);
	public Customer fetchCustomerById(int id);
	public String adjustCustomerBillAmount(int id, float discountPercentage);
	public String registerOrUpdateDetails(Customer cust);
	public String removeCustomerById(int id); //public String removeCustomerById(int id);
	public String deleteCustomer(Customer cust);
	public String deleteAllCustomersById(List<Integer> ids);
	public String deleteAllCustomers();
	public String deleteAllCusttomers(List<Customer> it);
	

}
