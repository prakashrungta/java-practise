// Java code to illustrate Reentrant Locks 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Date; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.locks.ReentrantLock; 





class worker implements Runnable 
{ 
String name; 
ReentrantLock re; 

public worker(ReentrantLock rl, String n) 
{ 
	re = rl; 
	name = n; 
} 
public void run() 
{ 
	
	Integer TIMEOUT_VALUE = 20000; 
	boolean done = false; 
	boolean ans ;
	//while (!done) 
	{ 

		try
		{
			System.out.println(Thread.currentThread().getName() + "     Going for acquiring tryLock  "+name );
			ans = re.tryLock(TIMEOUT_VALUE, java.util.concurrent.TimeUnit.MILLISECONDS); 
			System.out.println(Thread.currentThread().getName() + "     Acquired  Lock"); 
	
			if(ans) 
			{ 				
				System.out.println(Thread.currentThread().getName()+"   Going into sleep" ); 
				Thread.sleep(10); 			
				System.out.println(Thread.currentThread().getName()+"   Coming out of sleep" );
				if(re!=null)
				{
					System.out.println(Thread.currentThread().getName()+"    Before unlock getQueueLength - " + re.getQueueLength()+ "  hasQueuedThreads  -     " +re.hasQueuedThreads()+"    isLocked  -   " +re.isLocked());
					re.unlock();
				} 
				//
				if(re!=null)
				{
					System.out.println(Thread.currentThread().getName()+ "    After  unlock getQueueLength - " + re.getQueueLength()+ "  hasQueuedThreads  -    " +re.hasQueuedThreads()+"     isLocked  -   "+re.isLocked());
					
				}
				if(re!=null){
						if((re.hasQueuedThreads()!=true)&& (re.isLocked()==false))
						{
							System.out.println(Thread.currentThread().getName()+ "   ************Removing the Lock************");
							re = null;
						}
			}else{
				System.out.println(Thread.currentThread().getName()+ "   RE IS NULL");
			}
			
				
					
			}
		}
		catch(InterruptedException e) 
		{ 
				e.printStackTrace(); 
	    }
			
		}
	}
}

public class practise1 
{ 
		static final int MAX_T = 30; 
		public static void main(String[] args) 
		{ 
			try{
				ReentrantLock rel = new ReentrantLock(true); 
				ExecutorService pool = Executors.newFixedThreadPool(MAX_T); 
				Runnable w1 = new worker(rel, "Job1"); 
				pool.execute(w1); 
			Thread.sleep(101/100);				
				pool.execute(w1);
				//Thread.sleep(97);	
				pool.execute(w1);
				
				pool.shutdown(); 
			}catch(Exception e)
			{
				e.printStackTrace(); 
			}
		}
} 
 
