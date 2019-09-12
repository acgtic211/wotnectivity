package es.ual.acg;

import java.net.InetSocketAddress;

import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.datapoint.Datapoint;
import tuwien.auto.calimero.datapoint.StateDP;
import tuwien.auto.calimero.dptxlator.DPTXlator8BitSigned;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

public class KnxReq {


	public String getStatus(String remoteHost, String group, String datatype) throws Exception {
	
		final InetSocketAddress remote = new InetSocketAddress(remoteHost, 3671);
		// Create our network link, and pass it to a process communicator
		try (KNXNetworkLink knxLink = KNXNetworkLinkIP.newTunnelingLink(null, remote, false, TPSettings.TP1);
				ProcessCommunicator pc = new ProcessCommunicatorImpl(knxLink)) {

			System.out.println("read double value from datapoint " + group);

			GroupAddress groupAddress = new GroupAddress(group);

			

			// Uncomment the next line, if you want to write back the same value to the KNX network
			// pc.write(group, value);

			final Datapoint dp = new StateDP(groupAddress, "my datapoint "+groupAddress.toString());
			

			System.out.println(DPTXlator8BitSigned.DPT_VALUE_1_UCOUNT.getID());
			//dp.setDPT(0, KnxUtils.getTranslatorDPT(String value));

			dp.setDPT(0, datatype);
			String result = pc.read(dp);

			System.out.println("datapoint " + group + " value = " + result);
				
			
			return result;
		}
		catch (KNXException | InterruptedException e) {
			throw new Exception("Error accessing KNX datapoint: " + e.getMessage());
		}
	}

	public void setStatus(String remoteHost, String group, String datatype, String value) throws Exception {
	
		final InetSocketAddress remote = new InetSocketAddress(remoteHost, 3671);
		// Create our network link, and pass it to a process communicator
		try (KNXNetworkLink knxLink = KNXNetworkLinkIP.newTunnelingLink(null, remote, false, TPSettings.TP1);
				ProcessCommunicator pc = new ProcessCommunicatorImpl(knxLink)) {

			System.out.println("read double value from datapoint " + group);

			GroupAddress groupAddress = new GroupAddress(group);

			// Uncomment the next line, if you want to write back the same value to the KNX network
			// pc.write(group, value);

			final Datapoint dp = new StateDP(groupAddress, "my datapoint "+groupAddress.toString());
			
			//dp.setDPT(0, KnxUtils.getTranslatorDPT(String value));

			dp.setDPT(0, datatype);
			pc.write(dp, value);

		}
		catch (KNXException | InterruptedException e) {
			throw new Exception("Error accessing KNX datapoint: " + e.getMessage());
		}
	}
		
}
	