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

            if (action.equals("getDetails")) {
                int uid = android.os.Process.myUid();
                long temp = this.getSentBytes(uid);
                r.put("UidTxBytes", temp);
                temp = this.getSentPackets(uid);
                r.put("UidTxPackets", temp);
                temp = this.getReceivedBytes(uid);
                r.put("UidRxBytes", temp);
                temp = this.getReceivedPackets(uid);
                r.put("UidRxPackets", temp);
                temp = this.getMobileRxBytes();
                r.put("MobileRxBytes", temp);
                r.put("MobileRxPackets", this.getMobileRxPackets());
                r.put("MobileTxBytes", this.getMobileTxBytes());
                r.put("MobileTxPackets", this.getMobileTxPackets());
                r.put("TotalRxBytes", this.getTotalRxBytes());
                r.put("TotalRxPackets", this.getTotalRxPackets());
                r.put("TotalTxBytes", this.getTotalTxBytes());
                r.put("TotalTxPackets", this.getTotalTxPackets());
            } 

            else {
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

    /**
     * Return number of bytes received across mobile networks since device boot.
     *
     * @return long
     */
    public long getMobileRxBytes() {
        return TrafficStats.getMobileRxBytes();
    }

    /**
     * Return number of packets received across mobile networks since device
     * boot.
     *
     * @return long
     */

    public long getMobileRxPackets() {
        return TrafficStats.getMobileRxPackets();
    }

    /**
     * Return number of bytes transmitted across mobile networks since device
     * boot.
     *
     * @return long
     */
    public long getMobileTxBytes() {
        return TrafficStats.getMobileTxBytes();
    }

    /**
     * Return number of packets transmitted across mobile networks since device
     * boot.
     *
     * @return long
     */
    public long getMobileTxPackets() {
        return TrafficStats.getMobileTxPackets();
    }

    /**
     * Return number of bytes received since device boot.
     *
     * @return long
     */
    public long getTotalRxBytes() {
        return TrafficStats.getTotalRxBytes();
    }

    /**
     * Return number of packets received since device boot.
     *
     * @return long
     */
    public long getTotalRxPackets() {
        return TrafficStats.getTotalRxPackets();
    }

    /**
     * Return number of bytes transmitted since device boot.
     *
     * @return long
     */
    public long getTotalTxBytes() {
        return TrafficStats.getTotalTxBytes();
    }

    /**
     * Return number of packets transmitted since device boot.
     *
     * @return long
     */
    public long getTotalTxPackets() {
        return TrafficStats.getTotalTxPackets();
    }

}
