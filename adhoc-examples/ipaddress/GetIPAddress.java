// A Java program to demonstrate working of InetAddress class
// This program finds IP address for a domain name.
import java.net.*;
import java.util.ArrayList;

public class GetIPAddress
{
	public static void main(String args[]) throws Exception
	{


		String url = args[0];
		String pimHostAddr="2a07:2a42:adc0:11:250:56ff:fe9c:e3d3";
		try
		{
			InetAddress addrbyName = InetAddress.getByName(url);
			System.out.println(addrbyName.getHostName());
			InetAddress vpmsAddr[] = InetAddress.getAllByName(addrbyName.getHostName());
			// Get IP addresses related to the domain

			ArrayList<InetAddress> list = new ArrayList<InetAddress>();

			// Display ip addresses
			System.out.println("IP Address(es)");
			for (InetAddress addr:vpmsAddr)
				System.out.println(addr.getHostAddress());

			if (vpmsAddr != null) {
				for (InetAddress addr : vpmsAddr) {
				//	if (pimHostAddr.equals(addr.getHostAddress())) {
						boolean singleBox = true;

						System.out.println(".. Found A Single Box installation on Primary VPMS for pimHostAddr = " + pimHostAddr
								+ "   and addr " + addr.getHostAddress());
				//	}

				}
			}

			//InetAddress addr = InetAddress. getByName("DA18122188");
		//	System.out.println("Host name is: "+addr. getHostName());
		//	System.out.println("Ip address is: "+ addr. getHostAddress());


		}
		catch(Exception ex)
		{
			System.out.println("host not found");
		}
	}



}


