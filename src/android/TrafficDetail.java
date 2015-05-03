package org.apache.cordova.traffic;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;
import android.net.TrafficStats;

public class TrafficDetail extends CordovaPlugin {

	public TrafficDetail() {

	}

	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) {
		JSONObject r = new JSONObject();
		try {
			
			//JSONObject arg_object = args.getJSONObject(0);
			if (action.equals("bytesSent")) {
				int uid=android.os.Process.myUid();
				long temp = this.getSentBytes(uid);
				r.put("bytesSent", temp);
				temp=this.getSentPackets(uid);
				r.put("PacketSent", temp);
				temp=this.getReceivedBytes(uid);
				r.put("BytesReceived", temp);
				temp=this.getReceivedPackets(uid);
				r.put("PacketReceived", temp);
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Only alert and confirm are async.
		callbackContext.success(r);
		return true;
	}

	public long getSentBytes(int uid) {
		return TrafficStats.getUidTxBytes(uid);
	}
	

	public long getSentPackets(int uid) {
		return TrafficStats.getUidTxPackets(uid);
	}
	
	public long getReceivedBytes(int uid) {
		return TrafficStats.getUidRxBytes(uid);
	}
	
	public long getReceivedPackets(int uid) {
		return TrafficStats.getUidRxPackets(uid);
	}

}