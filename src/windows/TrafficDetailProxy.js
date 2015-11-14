var cordova = require('cordova'),
    ToUpperPlugin= require('./TrafficDetail');

module.exports = {

    getDetails: function (successCallback, errorCallback, args) {
	    var networkInfo = Windows.Networking.Connectivity.NetworkInformation;
		var connectivityNS = Windows.Networking.Connectivity;
		var currTime = new Date();
		var granularity=connectivityNS.DataUsageGranularity.total;
		var result;
        //Set start Time to 1 hour (3600000ms) before current time
        var startTime = new Date(currTime);
		startTime.setHours(startTime.getHours() - 1);

        //Get the ConnectionProfile that is currently used to connect to the Internet
		var connectionProfile = networkInfo.getInternetConnectionProfile();
		var networkUsageStates = {			
			roaming: connectivityNS.TriStates.doNotCare,
			shared: connectivityNS.TriStates.doNotCare
		};
        //var networkUsage = connectionProfile.getAttributedNetworkUsageAsync(startTime, currTime, networkUsageStates);
        //var networkUsage = connectionProfile.getNetworkUsageAsync(startTime,currTime);
		if (connectionProfile === null) {
                WinJS.log && WinJS.log("Not connected to Internet\n\r", "sample", "status");
        }
        else {
			//connectionProfile.getAttributedNetworkUsageAsync(startTime, currTime, networkUsageStates)
		    connectionProfile.getNetworkUsageAsync(startTime, currTime, granularity, networkUsageStates)
                .then(function (networkUsages) {
        for (var i = 0; i < networkUsages.size; i++) {
		//result="bytes sent "+networkUsages[i].bytesSent;
            result =
		    {
		        bytesSent: networkUsages[i].bytesSent,
		        PacketSent: 0, //not supported in windows
		        BytesReceived: networkUsages[i].bytesReceived,
		        PacketReceived: 0   //not supported in windows
		    };
        }
		successCallback(result);
    },
    function (error) {
        // This can happen if you try to get the network usage for a long period of time with
        // too fine a granularity.
        result =
		    {
		        bytesSent: error,
		        PacketSent: 0, //not supported in windows
		        BytesReceived: 0,
		        PacketReceived: 0   //not supported in windows
		    };
        //WinJS.log && WinJS.log("An error has occurred: " + error, "sample", "error");
		successCallback(result);
    });
        }       
    }
};

require("cordova/exec/proxy").add("TrafficDetail", module.exports);