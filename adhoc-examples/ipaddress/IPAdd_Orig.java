import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
public class IPAdd {

	public static void getLocalInetAddress() throws Exception {
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
			 System.out.println("This is  Debug 2   *****   ");
			 List<InetAddress> addresses = new ArrayList<InetAddress>(
						Collections.list(eth1.getInetAddresses()));			 
			System.out.println("This is  Debug 3   *****   "+addresses.size());		
			System.out.println("This is  Debug 4   *****   "+eth1.getInetAddresses());
			System.out.println("This is  Debug 5**   *****   "+eth1.getInterfaceAddresses());		
			for (NetworkInterface sub : Collections.list(eth1
					.getSubInterfaces())){
						System.out.println("This is  Debug 6   *****   "+sub.getName());			
						try{		
								// filter out Cluster IP which is assigned under a sub-interface
								// of eth1 namely eth1:0
								 System.out.println("This is  Debug 7   Before Removing*****   "+addresses.size());
								 System.out.println("This is  Debug 8   Before Removing*****   "+addresses);
								 addresses.removeAll(Collections.list(sub.getInetAddresses()));
								 System.out.println("This is  Debug 9   After Removing*****   "+addresses.size());
								 System.out.println("This is  Debug 10   After Removing*****   "+addresses);
								if (addresses.size() == 1) {
										System.out.println("This is Debug 9  when size is 1 *****   "+addresses.get(0));
									//	return addresses.get(0);
								}
								else{  System.out.println("This is  Debug 11 *****  "+addresses.get(0));
										System.out.println("This is  Debug 12 *****  "+addresses.get(0).getHostAddress());
										System.out.println("This is  Debug 13 *****  "+addresses.get(1).getHostAddress());	
									//	return addresses.get(1);
										}
						}catch(Exception e)	{
							  System.out.println(" Exception Occured"+e.getMessage());
						} 
			}
		}else {
			// Windows or Linux (developer's machine)
			for (ImmutablePair<NetworkInterface, InetAddress> pair : list) {
				if (!pair.getA().isLoopback()
						&& !pair.getB().isSiteLocalAddress()
						&& pair.getB() instanceof Inet4Address) {
					System.out.println("This is  Debug 14 *****  "+pair.getB().getHostAddress());	
					
				}
			}
		}

		//throw new SocketException(
				//"Could not find suitable network inteface among ");
		// + getDebugListOfNetworkAddresses(list));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        String localIPAddress = "127.0.0.1";
	        System.out.println("This is Default localIPAddress "+localIPAddress);
	        try {
	            // SocketException can occur on some bamboo servers. Ignore in test environment to avoid a build failure
	          //  InetAddress localInetAddress = getLocalInetAddress();
	            getLocalInetAddress();
	           // System.out.println("This is localInetAddress 1" + localInetAddress);
	         //   localIPAddress = localInetAddress.getHostAddress();
	            System.out.println("This is localIPAddress"+localIPAddress);
	        } catch (Exception sx) {
	            
	                System.out.println(" Exception Occured"+sx.getMessage());
	            } 
	        }
	     
	}


