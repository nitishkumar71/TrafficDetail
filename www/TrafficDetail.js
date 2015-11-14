
/**
 * Get Traffic Detail info
 *
 * @param {Function} successCallback The function to call when the heading data is available
 * @param {Function} errorCallback The function to call when there is an error getting the heading data. (OPTIONAL)
 */
var TrafficDetail= {
            /*[{                  // and this array of custom arguments to create our entry
                "title": title,
                "description": notes,
                "eventLocation": location,
                "startTimeMillis": startDate.getTime(),
                "endTimeMillis": endDate.getTime()
            }]*/

	 getBytesSent : function(successCallback, errorCallback,uid) {
			cordova.exec(successCallback, errorCallback, "TrafficDetail", "getDetails", []);
	 }
}

module.exports = TrafficDetail;