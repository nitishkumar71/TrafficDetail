package org.apache.cordova.traffic;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.TrafficStats;

public class TrafficDetail extends CordovaPlugin{
	
	public TrafficDetail(){
		
	}
	
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
	
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		JSONObject r = new JSONObject();
		if (action.equals("bytesSent")) {
            r.put("bytesSent",this.getSentBytes());
        }else{
        	return false;
        }
		// Only alert and confirm are async.
        callbackContext.success(r);
        return true;
	}
	
	public long getSentBytes(){
		return TrafficStats.getMobileTxBytes();
	}

}