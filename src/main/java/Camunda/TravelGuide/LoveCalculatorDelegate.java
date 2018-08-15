package Camunda.TravelGuide;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;



public class LoveCalculatorDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution exe) throws Exception {
		// TODO Auto-generated method stub
		
		// These code snippets use an open-source library. http://unirest.io/java
		
		
		String name = (String) exe.getVariable("name");
		String city= (String) exe.getVariable("city");
		
		
		HttpResponse<JsonNode> response = Unirest.get("https://love-calculator.p.mashape.com/getPercentage?fname="+name+"&sname="+city)
		.header("X-Mashape-Key", "sjbEkLUmcWmshKXq0pWqXIkM6BzSp1e37zxjsnXSjAjEQfWwG4")
		.header("Accept", "application/json")
		.asJson();
		
		System.out.println(response.getRawBody());
		
		exe.setVariable("response", response.getRawBody());

	}

}
