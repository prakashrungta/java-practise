import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.*;
public class IPAdd {
	
	public static InetAddress getLocalInetAddress() throws SocketException {
		List<ImmutablePair<NetworkInterface, InetAddress>> list = new ArrayList<>(
				3);
		for (NetworkInterface ni : Collections.list(NetworkInterface
				.getNetworkInterfaces())) {
			for (InetAddress addr : Collections.list(ni.getInetAddresses())) {
				list.add(ImmutablePair.of(ni, addr));
			}
		}
		
		NetworkInterface eth1 = NetworkInterface.getByName("eth1");
		 System.out.println("This is  Debug 1   *****   "+eth1.getDisplayName());
		if ("Linux".equals(System.getProperty("os.name")) && eth1 != null) {
			// EDP
			 System.out.println("This is  Debug 2   *****   ");
			List<InetAddress> addresses = new ArrayList<InetAddress>(
					Collections.list(eth1.getInetAddresses()));
			System.out.println("This is  Debug 3   *****   "+eth1.getInetAddresses());
			System.out.println("This is  Debug 4   *****   "+eth1.getInterfaceAddresses());
			System.out.println("This is  Debug 5   *****   "+addresses.get(0));
			try{
				for (NetworkInterface sub : Collections.list(eth1
						.getSubInterfaces())) {
				// filter out Cluster IP which is assigned under a sub-interface
				// of eth1 namely eth1:0
				 System.out.println("This is  Debug 6   *****   "+addresses);
				addresses.removeAll(Collections.list(sub.getInetAddresses()));
				 System.out.println("This is  Debug 7   *****   "+addresses);
			}
				System.out.println("This is  Debug 8 size of address collection is *****   "+addresses.size());
				System.out.println("This is  Debug 9  and address is ***  "+addresses);
	            // remove all IP v6 addresses
	            Iterator<InetAddress> it = addresses.iterator();
	            while (it.hasNext()) {
	                if (it.next() instanceof Inet6Address) {
	                    it.remove();
	                }
	            }

			if (addresses.size() == 1) {
				System.out.println("This is Debug 10  when size is 1 *****   "+addresses.get(0));
				return addresses.get(0);
			}
		/*	else
			{	System.out.println("This is  Debug 12 when size is NOT 1 *****  "+addresses.get(0).getHostAddress());
				System.out.println("This is  Debug 13 when size is NOT 1 *****  "+addresses.get(1).getHostAddress());
				return addresses.get(0);
			}*/
			}catch(Exception e)
			{
				  System.out.println(" Exception Occured"+e.getMessage());
		} 
			 }else {
			// Windows or Linux (developer's machine)
			for (ImmutablePair<NetworkInterface, InetAddress> pair : list) {
				if (!pair.getA().isLoopback()
						&& !pair.getB().isSiteLocalAddress()
						&& pair.getB() instanceof Inet4Address) {
					return pair.getB();
				}
			}
		}

		throw new SocketException(
				"Could not find suitable network inteface among ");
		// + getDebugListOfNetworkAddresses(list));
	}
	public static void getLocalInetAddressModified() throws SocketException {
		List<ImmutablePair<NetworkInterface, InetAddress>> list = new ArrayList<>(
				3);
		for (NetworkInterface ni : Collections.list(NetworkInterface
				.getNetworkInterfaces())) {
			for (InetAddress addr : Collections.list(ni.getInetAddresses())) {
				list.add(ImmutablePair.of(ni, addr));
			}
		}
		
		NetworkInterface eth1 = NetworkInterface.getByName("eth1");
		 System.out.println("This is  Debug 1   *****   "+eth1.getDisplayName());
		if ("Linux".equals(System.getProperty("os.name")) && eth1 != null) {
			// EDP
			 System.out.println("This is  Debug 2   *****   ");
			List<InetAddress> addresses = new ArrayList<InetAddress>(
					Collections.list(eth1.getInetAddresses()));
			System.out.println("This is  Debug 3   *****   "+eth1.getInetAddresses());
			System.out.println("This is  Debug 4   *****   "+eth1.getInterfaceAddresses());
			System.out.println("This is  Debug 5   *****   "+addresses);
			//System.out.println("This is  Debug 5   *****   "+addresses.get(0));
			for (int i = 0; i < addresses.size(); i++) {
				System.out.println("This is  Debug 99   *****  "+i+"   sub.getHostAddress "+addresses.get(i).getHostAddress());
			}
			try{
				for (NetworkInterface sub : Collections.list(eth1
						.getSubInterfaces())) {
				 System.out.println("This is  Debug 6 getDisplayName  *****   "+sub.getDisplayName());
				 System.out.println("This is  Debug 100 getInetAddresses   *****   "+sub.getInetAddresses());	
				 System.out.println("This is  Debug 6  getInterfaceAddresses *****   "+sub.getInterfaceAddresses());
				addresses.removeAll(Collections.list(sub.getInetAddresses()));
				for (int i = 0; i < addresses.size(); i++) {
					System.out.println("This is  Debug 101   *****  "+i+"sub.getHostAddress "+addresses.get(i).getHostAddress());					
				}
				}
				 System.out.println("This is  Debug 7   *****   "+addresses);
				
			
				//System.out.println("This is  Debug 8 size of address collection is ***** "+addresses.size());
			if (addresses.size() == 1) {
				System.out.println("This is Debug 9  when size is 1 *****   "+addresses.get(0));
				;
			}
			else
			{	//System.out.println("This is Debug 10 size of address collection is ***** "+addresses.size());
				System.out.println("This is  Debug 10 *****  "+addresses.get(0));
				System.out.println("This is  Debug 11 *****  "+addresses.get(0).getHostAddress());
				System.out.println("This is  Debug 12 *****  "+addresses.get(1).getHostAddress());
				
			}
		}
		catch(Exception e)
			{
				  System.out.println(" Exception Occured"+e.getMessage());
		} 
			
	}
			else {
			// Windows or Linux (developer's machine)
			for (ImmutablePair<NetworkInterface, InetAddress> pair : list) {
				if (!pair.getA().isLoopback()
						&& !pair.getB().isSiteLocalAddress()
						&& pair.getB() instanceof Inet4Address) {
					//return pair.getB();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        String localIPAddress = "127.0.0.1";
	        System.out.println("This is Default localIPAddress "+localIPAddress);
	        try {
	            // SocketException can occur on some bamboo servers. Ignore in test environment to avoid a build failure
	            InetAddress localInetAddress = getLocalInetAddress();
	            System.out.println("This is localInetAddress 1" + localInetAddress);
	            localIPAddress = localInetAddress.getHostAddress();
	            System.out.println("This is localIPAddress"+localIPAddress);
	            System.out.println("\n*********Modified************\n");
	            //Modified
	            String localModIPAddress = "127.0.0.1";
	            getLocalInetAddressModified();
	           /* InetAddress localInetAddressMod = getLocalInetAddressModified();
	            System.out.println("This is localInetAddressMod 1" + localInetAddressMod);
	            localModIPAddress = localInetAddress.getHostAddress();
	            System.out.println("This is localModIPAddress"+localModIPAddress);
	            */
	        } catch (SocketException sx) {
	            
	                System.out.println(" Exception Occured"+sx.getMessage());
	            } 
	        }
	     
	}


