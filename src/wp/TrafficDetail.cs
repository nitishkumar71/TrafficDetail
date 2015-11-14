using System;
using Windows.Foundation;
using Windows.Networking.Connectivity;
using System.Diagnostics;

namespace WPCordovaClassLib.Cordova.Commands
{
    public class TrafficDetail : BaseCommand
    {
		
        public void getDetails(string options)
        {
			PluginResult result;
			string res;
            DateTime current_time = DateTime.Now;
            TimeSpan TimeDiff = new TimeSpan(1, 0, 0);
            Debug.WriteLine("Current Time: " + current_time);
            Debug.WriteLine("Time Diff: " + TimeDiff);
            ConnectionProfile InternetConnectionProfile = NetworkInformation.GetInternetConnectionProfile();
            if (InternetConnectionProfile == null)
            {
				res = String.Format("\"bytesSent\":\"{0}\",\"PacketSent\":\"{1}\",\"BytesReceived\":\"{2}\",\"PacketReceived\":\"{3}\"",
                                        0,
                                        0, //not supported in windows
                                        0,
                                        0); //not supported in windows

                //Debug.WriteLine("Not connected to Internet");
            }
            else
            {
                var DataStats = InternetConnectionProfile.GetLocalUsage(current_time.Subtract(TimeDiff), current_time);
				res = String.Format("\"bytesSent\":\"{0}\",\"PacketSent\":\"{1}\",\"BytesReceived\":\"{2}\",\"PacketReceived\":\"{3}\"",
                                        DataStats.BytesSent,
                                        0, //not supported in windows
                                        DataStats.BytesReceived,
                                        0); //not supported in windows

                //Debug.WriteLine("Data Usage "+DataStats.BytesSent);
            }
            //string upperCase = JSON.JsonHelper.Deserialize<string[]>(options)[0].ToUpper();            
            res = "{" + res + "}";
            //Debug.WriteLine("Result::" + res);
            DispatchCommandResult(new PluginResult(PluginResult.Status.OK, res));
        }
    }
}