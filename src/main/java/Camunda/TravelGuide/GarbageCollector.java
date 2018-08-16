package Camunda.TravelGuide;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

import Camunda.utils.JSONWorker;



public class GarbageCollector implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		JSONObject names = new JSONObject();
		/*location
		names = JSONWorker.addToJO(names, JSONWorker.getValFromExec("location_latitude", execution));
		names = JSONWorker.addToJO(names, JSONWorker.getValFromExec("location_longitude", execution));
		
		names = JSONWorker.addToJO(names, JSONWorker.getValFromExec("HappyDuckAppearsHappy", execution));
		*/
		names = JSONWorker.addToJO(names, JSONWorker.getValFromExec("UrbanDef", execution));
		
		execution.setVariable("vals", names.toString());
	}
	
}
