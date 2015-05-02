
var exec = require('cordova/exec');

function TrafficDetail()
{

}
/**
 * Get Traffic Detail info
 *
 * @param {Function} successCallback The function to call when the heading data is available
 * @param {Function} errorCallback The function to call when there is an error getting the heading data. (OPTIONAL)
 */
TrafficDetail.prototype.getBytesSent = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "TrafficDetail", "bytesSent", []);
};

module.exports = new Device();