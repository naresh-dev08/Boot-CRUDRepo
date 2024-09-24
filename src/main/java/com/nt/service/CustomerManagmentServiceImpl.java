package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Service("custService")
public class CustomerManagmentServiceImpl implements ICustomerManagmentService {
	
	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String registerCustomer(Customer cust) {
		System.out.println("Cust obj data ::"+cust);
		//use the repo
		Customer cust1 = custRepo.save(cust);
		System.out.println("Cust1 obj data ::"+cust1);
		return "Customer obj is saved (record inserted) having the id value"+cust1.getCno();
	}

	@Override
	public String registerGroupOfCustomer(Iterable<Customer> customers)  {
	  
	  if(customers != null) { 
		  Iterable<Customer> savedCustomers = custRepo.saveAll(customers); 
		  int size = ((Collection<Customer>)savedCustomers).size();
		  List<Integer> ids = (List<Integer>) ((Collection<Customer>)savedCustomers).stream().map(d -> ((Customer) d).getCno()).collect(Collectors.toList());
	  return size+" No. of customers are saved with id values::"+ids.toString();
	  } else {
	  throw new IllegalArgumentException("Invalid customers info");
	  }
	  }
	
	
	
	
	/*	  @Override //Old fasion code public String
		  registerGroupOfCustomer(Iterable<Customer> customers) {
		  
		  if(customers != null) { 
			  Iterable<Customer> savedCustomers =
		  custRepo.saveAll(customers); 
		  int size = ((Collection)savedCustomers).size();
		  List<Integer> ids = new ArrayList<>(); savedCustomers.forEach(d->{ids.add(d.getCno()); 
		  } ); 
		  return size+" No. of customers are saved with id values::"+ids.toString(); } else {
		  throw new IllegalArgumentException("Invalid customers info") ; 
		  } 
		  }
		 */
	
	
	@Override
	public boolean isCustomerAvailable(Integer id) {
		//use repo
		boolean flag = custRepo.existsById(id);
		return flag;
	}
	
	@Override
	public Long getCustomersCount() {
		//use repo
		Long count = custRepo.count();
		return count;
	}

	@Override
	public Iterable<Customer> getAlICustomers() {
		//use repo
		Iterable<Customer>  it= custRepo.findAll();
		return it;
	}

	@Override
	public Iterable<Customer> getCustomersById(Iterable<Integer> ids) {
		//use repo
		Iterable<Customer> it = custRepo.findAllById(ids);
		return  it;
	}

	@Override
	public String showCustomerById(int id) {
		Optional<Customer> opt =custRepo.findById(id);
		if(opt.isPresent()) {
			return id+" Id Customer Details :: "+opt.get();
		} else {
		return id+" id No customer found";
		}
	}

	/*	@Override
		public Customer findCustomerById(int id) {
			Optional<Customer> opt = custRepo.findById(id);
			if(opt.isPresent()) {
				return opt.get();        
			}else {
				throw new IllegalArgumentException(id+" id Customer not found");
			}
		}*/
	
	
	@Override
	public Customer findCustomerById(int id) {
		return custRepo.findById(id).orElseThrow(()-> new IllegalArgumentException(id +" id Customer not found"));  //one line code
	}

	@Override
	public Customer fetchCustomerById(int id) {
		return custRepo.findById(id).orElse(new Customer(00,"xxx","yyy",00.00f));
	}//method

	@Override
	public String adjustCustomerBillAmount(int id, float discountPercentage) {
		Optional<Customer> opt = custRepo.findById(id);
		if(opt.isPresent()) {
			Customer cust = opt.get();
		   //calculate discount amount
			float discount = cust.getBillAmt()*(discountPercentage/100.0f);
			//set final bill amount to customer
			cust.setBillAmt(cust.getBillAmt()-discount);
			//update the obj
			custRepo.save(cust);
			return id+" id Customer details are updated";
		}else {
		return id+" id Customer not found";
		}
	}//method

	@Override
	public String registerOrUpdateDetails(Customer cust) {
		Optional<Customer> opt = custRepo.findById(cust.getCno());
		if(opt.isPresent()) {
			custRepo.save(cust);
			return cust.getCno()+" id Customer details are found and updated";
		} else {
			int idVal = custRepo.save(cust).getCno();
		return " Customer details are saved with id "+idVal;
		}
	}//method

	@Override
	public String removeCustomerById(int id) {
		//find the customer
		Optional<Customer> opt = custRepo.findById(id);
		if (opt.isPresent()) {
			custRepo.deleteById(id);
			return id+" id Customer is found and deleted";
		} else {
		return id+" id Customer is not found for deletion";
		}
	}//method

	@Override
	public String deleteCustomer(Customer cust) {
		Optional<Customer> opt = custRepo.findById(cust.getCno());
		if (opt.isPresent()) {
			custRepo.delete(cust);
			return cust.getCno()+" id Customer found and deleted";
		} else {
			return cust.getCno()+" id Customer is not found for deletion";
		}
	}//method

	/*@Override
	public String deleteAllCustomersById(List<Integer> id) {
		 List<Customer> custList = (List<Customer>) custRepo.findAllById(id);
		 
		 if (custList.size()==id.size()) {
			custRepo.deleteAllById(id);
			return id+" id are deleted from DB";
		} else
		return id+" id are not found";
	}//method
	*/
	
	@Override
	public String deleteAllCustomersById(List<Integer> id) {
		List<Customer> list = (List<Customer>) custRepo.findAllById(id);
			custRepo.deleteAllById(id);
			return list.size()+" id are deleted from DB";
	}//method
	
	@Override
	public String deleteAllCustomers() {
		Long count = custRepo.count();
		if (count> 0) {
			custRepo.deleteAll();	
			return count +" No of records are found and deleted";
		} else
			return " No records are found for deletion";
	}//method

	@Override
	public String deleteAllCusttomers(List<Customer> it) {
		List<Customer> list = (List<Customer>) custRepo.findAll();
		custRepo.deleteAll(it);
		    return list.size()+" ids are deleted";
	}


	

}//class
