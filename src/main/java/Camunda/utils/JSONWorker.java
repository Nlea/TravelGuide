package Camunda.utils;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWorker {

	public static JSONObject addToJO(JSONObject obj, String val) throws JSONException {
		obj.put(obj.length()+"", val);
		return obj;
	}
	
	public static String getValFromExec(String name, DelegateExecution execution) {
		return (String) execution.getVariable(name);
	}
	
}
