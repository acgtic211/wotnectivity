package es.ual.acg;

import java.net.InetSocketAddress;

import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;

public class KnxReq {


	public void getStatus(String remoteHost, String group){
	
		final InetSocketAddress remote = new InetSocketAddress(remoteHost, 3671);
		// Create our network link, and pass it to a process communicator
		try (KNXNetworkLink knxLink = KNXNetworkLinkIP.newTunnelingLink(null, remote, false, TPSettings.TP1);
				ProcessCommunicator pc = new ProcessCommunicatorImpl(knxLink)) {

			System.out.println("read boolean value from datapoint " + group);
			final boolean value = pc.readBool(new GroupAddress(group));
			System.out.println("datapoint " + group + " value = " + value);

			// Uncomment the next line, if you want to write back the same value to the KNX network
			// pc.write(group, value);
		}
		catch (KNXException | InterruptedException e) {
			System.out.println("Error accessing KNX datapoint: " + e.getMessage());
		}
	}
		
}
	
