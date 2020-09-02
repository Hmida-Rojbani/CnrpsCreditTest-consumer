package tn.cnrps.ws.soap.consume.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.cnrps.ws.soap.consume.clients.SoapClient;
import tn.cnrps.ws.soap.consume.loanClasses.CustomerRequest;
import tn.cnrps.ws.soap.consume.loanClasses.WsResponse;

@RestController
public class TestConsumer {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping(path="/test",produces = MediaType.APPLICATION_XML_VALUE)
	public WsResponse testConsumer() {
		
		CustomerRequest customerRequest = new CustomerRequest();
		
		customerRequest.setCustomerName("Test");
		customerRequest.setAge(25);
		customerRequest.setYearlyIncome(25000);
		customerRequest.setCibilScore(690);
		customerRequest.setEmploymentMode("Full Time");
		
		
		
		return client.getLoanStatus(customerRequest);
	}

}
