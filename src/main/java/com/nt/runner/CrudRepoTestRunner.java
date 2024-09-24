package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICustomerManagmentService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerManagmentService custService;

	@Override
	public void run(String... args) throws Exception {
		
		
		/* Customer cust = new Customer(); 
		 cust.setCname("Varshan");
		 cust.setCaddrs("KSP");
		 cust.setBillAmt(77256.7f); 
		 String msg =
		 custService.registerCustomer(cust); System.out.println(msg);*/
		 
		
		/*
		 try { 
		// Customer cust1 = new Customer(); 
		      //  cust1.setCname("Ranav");	 cust1.setCaddrs("Novida");  cust1.setBillAmt(54276.2f); 
		  //  Customer cust2 = new Customer(); 
		      //  cust2.setCname("Anketh");   cust2.setCaddrs("KMNR");    cust2.setBillAmt(52676.3f); 
		  //   Customer cust3 = new Customer();
		     //     cust3.setCname("Harsh");  cust3.setCaddrs("JPL");         cust3.setBillAmt(73753.6f);
		 List<Customer> list = List.of(new Customer("Rahul","Manipur",76523.8f), new Customer("Suhas","Dehradun",56524.4f), new Customer("Kaushik","Lucknow",68523.2f));
		    
		 
		// String msg = custService.registerGroupOfCustomer(Arrays.asList(cust1,cust2, cust3));
		 
		   String msg = custService.registerGroupOfCustomer(list); 
		 System.out.println(msg);
		 
		 }catch (Exception e) {
		  e.printStackTrace(); 
		 }*/
		 
		
		/*try {
			boolean flag = custService.isCustomerAvailable(10);
			if (flag) 
				System.out.println("Customer Available");
			else
				System.out.println("Customer is not available");
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
			System.out.println("Customers count is::"+custService.getCustomersCount());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*try {
			Iterable<Customer> it = custService.getAlICustomers();
			it.forEach(cust->{System.out.println(cust);
			});
			System.out.println("--------------------------------------------------");
			it.forEach(cust->System.out.println(cust));
			System.out.println("--------------------------------------------------");
			it.forEach(System.out::println);
			System.out.println("--------------------------------------------------");
			Iterator<Customer> it1 = it.iterator();
			while (it1.hasNext()) {
				System.out.println(it1.next());
			}
			System.out.println("--------------------------------------------------");  //java 5 enhanced for loop
			for(Customer cust:it) {
				System.out.println(cust);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Iterable<Customer> it = custService.getCustomersById(List.of(1203,103, null, 252)); //we will get Null pointer exception
			it.forEach(cust->{System.out.println(cust);
			});
			   System.out.println("--------------------------------------------------");
			it.forEach(cust->System.out.println(cust));
			   System.out.println("--------------------------------------------------");
			it.forEach(System.out::println);
			   System.out.println("--------------------------------------------------");
			   Iterator<Customer> it1 = it.iterator();
			while (it1.hasNext()) {
				System.out.println(it1.next());
			}
			   System.out.println("--------------------------------------------------");
			for(Customer cust:it) {
				System.out.println(cust);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
				System.out.println(custService.showCustomerById(21));
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			System.out.println(custService.findCustomerById(20));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(custService.fetchCustomerById(21));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(custService.adjustCustomerBillAmount(10, 20.0f));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
			Customer cust = new Customer();
			cust.setCno(23); cust.setCname("Kumar"); cust.setCaddrs("Mumbai"); cust.setBillAmt(87634.2f);
			System.out.println(custService.registerOrUpdateDetails(cust));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(custService.removeCustomerById(254));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
			Customer cust = new Customer();
			cust.setCno(253);
			System.out.println(custService.deleteCustomer(cust));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
		   System.out.println(custService.deleteAllCustomersById(List.of(1202,1203,1204)));
		}catch (Exception e) {
		    e.printStackTrace();
		}*/
		
		/*try {
			   System.out.println(custService.deleteAllCustomersById(List.of(1202,1205,1207)));
			}catch (Exception e) {
			    e.printStackTrace();
			}*/
		
		/*try {
			   System.out.println(custService.deleteAllCustomers());
		    }catch (Exception e) {
			    e.printStackTrace();
		    }*/
		
		try {
			   System.out.println(custService.deleteAllCustomers());
		    }catch (Exception e) {
			    e.printStackTrace();
		    }
		
		
		
		
		
	}///run()

}//class()
