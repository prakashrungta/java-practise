public class StringEquals {
 public static void main(String[ ] args) {
   String s1 = "Hello";
   String s2 = new String(s1);
   String s3 = "Hello";

		  
		
   System.out.println(s1 + " equals " + s2 + "--> " +  s1.equals(s2)); //true Object comparisions
 
   System.out.println(s1 + " == " + s2 + " --> " + (s1 == s2)); //false References comparisions
   System.out.println(s1 + " == " + s3 + " -->" + (s1 == s3)); //true


 }
}
 