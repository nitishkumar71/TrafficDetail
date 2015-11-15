This Cordova/Phonegap plugin will help to get network related information for android and windows mobile devices.
##Pre-Requisite:
1. Cordova Environment for developemnt. Those who are new in cordova can use this link https://netbeans.org/kb/docs/webclient/cordova-gettingstarted.html
2. Cordova Project

You can directly install these plugin into your cordova project, doc for plugin installation is available here https://cordova.apache.org/docs/en/5.0.0/guide/cli/

Plugin can be used as shown below

```
TrafficDetail.getBytesSent(successFunction, errorFunction);

// callback function to be called on success
function successFunction(detail) {
    console.log(" Bytes Sent: "+detail.bytesSent);
	console.log(" Packets Sent: "+detail.PacketSent);
	console.log(" Bytes Received: "+detail.BytesReceived);
	console.log(" Packets Sent: "+detail.PacketReceived);
}

// callback function to be called on error
function errorFunction(error) {
    alert(" Error: " + error);
}
```

####Note: Plugin is only supported for android and windows platform

