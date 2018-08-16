package Camunda.TravelGuide;

import java.util.LinkedList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

import Camunda.utils.JSONWorker;

public class GarbageCollector implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Collector begins to fill with itself");
		LinkedList<String> varVals = new LinkedList<String>();
		varVals.add(JSONWorker.getValFromExec("HappyDuckAppearsHappy", execution));
		varVals.add(JSONWorker.getValFromExec("UrbanDef", execution));

		LinkedList<Integer> usedInts = new LinkedList<Integer>();
		JSONObject names = new JSONObject();

		while (usedInts.size() != varVals.size()) {
			int i = (int) (Math.random() * varVals.size());
			if (!usedInts.contains(i)) {
				names = JSONWorker.addToJO(names, varVals.get(i));
				usedInts.add(i);
				System.out.println(i + " = " + varVals.get(i));
			}
		}
		
		names = JSONWorker.addToJO(names, "<br><br>the crazyness factor is about:" + this.getCrazyness(varVals) * 100 + "%");
		execution.setVariable("vals", names.toString());
	}
	
	public double getCrazyness(LinkedList<String> data) {
		double a = 0;
		double b = 0;
		for(String str: data) {
			for(char c: str.toCharArray()) {
				if(c == 'a') {
					a +=1;
				}else if (c == 'b') {
					b+=1;
				}
			}
		}
		return a/b;
	}
}
