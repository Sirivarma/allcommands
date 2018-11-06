package com.cg.airways.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.airways.bean.Admin;
import com.cg.airways.bean.Customer;
import com.cg.airways.bean.Flights;
import com.cg.airways.bean.TourPlanner;
import com.cg.airways.exception.AirwaysException;
import com.cg.airways.service.AdminService;
import com.cg.airways.service.CustomerService;
import com.cg.airways.service.FlightService;
import com.cg.airways.service.TourPlannerService;

@Controller
public class AirwaysController{

	public static int count=0;
	@Autowired
	FlightService flightService;
	@Autowired
	AdminService adminService;
	@Autowired
	TourPlannerService tourplannerService;
	@Autowired
	CustomerService customerService;
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
@RequestMapping("/admin")
public String getAdmin(Model model,String error,String logout){
	//System.out.println("loginPage");
	if (error != null)
		model.addAttribute("error", "Your username and password is invalid.");

	if (logout != null)
		model.addAttribute("message", "You have been logged out successfully.");
	///System.err.println("loginPage");
	return "login";
}

@RequestMapping("/adminLogin")
public String getLogin(Model model) {
	System.err.println("admin");
	return "adminLogin";
}

	@RequestMapping("/")
	public String getHome( Model model) throws Exception  {
		try {
		model.addAttribute("tour", new TourPlanner());
		if(count==0) {
		Admin admin=new Admin();
		admin.setUsername("Admin");
		admin.setPassword("Admin");
		admin.setRoles("ADMIN");
		Admin ad=adminService.recordsAdd(admin);
		System.err.println(ad);
		count++;}
		}
		catch(AirwaysException e) 
		{
		throw new AirwaysException(1,"Exception");
		}
		return "index";
		}
		
	
public static TourPlanner tp=new TourPlanner();
	@SuppressWarnings("null")
	@RequestMapping("/search")
	public String search(Model model, @Valid@ModelAttribute("tour") TourPlanner tourPlanner,BindingResult result) throws Exception{
		if (result.hasErrors()) {
			
			return "index";
		}
		
		tp=tourPlanner;
		List<Flights> flightList=flightService.display();
		List<Flights> fList=new ArrayList<Flights>();
		for (Flights flights : flightList) {
			System.out.println(flights.getSource()+"   "+tourPlanner.getTourFrom()+"  "+flights.getDestination()+"   "+tourPlanner.getTo());
			if( flights.getSource().equals(tourPlanner.getTourFrom()) && flights.getDestination().equals(tourPlanner.getTo())) {
				fList.add(flights);
				System.out.println("added successfully");
			}
		}
		if(fList.size()<=0) {
		
			model.addAttribute("msg", "No Records Found.");
			return "error1";
		
		}
		model.addAttribute("flights", fList);
		return "result";
		
	}
	
	@RequestMapping("/addFlightPage")
	public String addFlightPage(Model model) {

		
		model.addAttribute("flights", new Flights());
		
		return "addFlight";
	}
	@RequestMapping("/displayFlightPage")
	public String displayFlightPage(Model model) throws AirwaysException {
		List<Flights> flights=null;
		try {
         flights=flightService.display();
		}catch(AirwaysException e) {
			throw new AirwaysException(1,"error in displaying flights");
		}
		model.addAttribute("flights", flights);
		return "displayFlights";
	}
	@SuppressWarnings("null")
	@RequestMapping("/addFlight")
	public String addFlight(Model model, @Valid@ModelAttribute("flights") Flights flights, BindingResult result) throws Exception {
		Flights flight=null;
		if (result.hasErrors()) {
			
			return "addFlight";
		}
         try {
		 flight = flightService.addFlight(flights);
         }catch(AirwaysException e) {
        	 throw new AirwaysException(1,"failed in adding flights");
         }
		model.addAttribute("flight", flight);
		
		
		return "addresult";
	}
	@RequestMapping("/bookFlight")
	public String addResult(Model model,@RequestParam("id") int id,@ModelAttribute("flights") Flights flights) throws AirwaysException {
		model.addAttribute("Customer", new Customer());
		Flights flight=null;
		try {
		 flight=flightService.retriveOne(id);
		}catch(AirwaysException e) {
			throw new AirwaysException(1,"Error in retreiving the details");
		}
		 model.addAttribute("flights", flight);
		return "bookFlight";
	}
	 @RequestMapping(value="/bookTicket",method=RequestMethod.POST)
	   public String bookTicket(@Valid @ModelAttribute("Customer") Customer customer,BindingResult br,@Valid@ModelAttribute("flights") Flights flight,BindingResult re,Model model) throws AirwaysException {
		 if (re.hasErrors()||br.hasErrors()) {
				return "bookFlight";
			}	
		 Customer customer1=null;
		 try {
		 customer1= customerService.addCustomer(customer);
		 System.err.println(customer1);
		 }catch(AirwaysException e) {
			 throw new AirwaysException(1,"Error in adding customer details");
		 }
		 Flights flight1=null;
		  try {
		  flight1=flightService.retriveOne(flight.getFlightNumber());
			System.err.println(flight1);
		  }catch(AirwaysException e) {
			  throw new AirwaysException(1,"Error in retreiving the flight number");
		  }
		  
			//TourPlanner tourplanner1=tourplannerService.add(tp);
			model.addAttribute("firstName",customer1.getFirstname());
			model.addAttribute("custId",customer1.getCustomerid());
			model.addAttribute("phoneno",customer1.getPhonenumber());
			
			model.addAttribute("flight1", flight1);
	      return "displayDetails";
	   
		 }
	 @RequestMapping("/error1")
	 public String error() {
		 return "error2";
	 }
}
