
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   UrlValidator urlV = new UrlValidator();
     assertFalse(urlV.isValid(null));
     assertFalse(urlV.isValid("google"));
     assertFalse(urlV.isValid("h3t://www.facebook.com"));
     assertTrue(urlV.isValid("http://www.google.com"));
     assertTrue(urlV.isValid("http://www.google.com/test"));
      assertTrue(urlV.isValid("http://www.google.com:80/test"));
     assertFalse(urlV.isValid("http//www.google.com"));
     assertFalse(urlV.isValid(""));
   }
   
   
   public void testYourFirstPartition()
   {
	  UrlValidator urlV = new UrlValidator();
    String[] ports = {":0", ":1", ":65535", ":65536", ":-1"};
    
    for (int i = 0; i < ports.length; i++) {
      if (i > 2){
        // assertFalse(urlV.isValid("http://www.google.com" + ports[i]));
      }else{
        // assertTrue(urlV.isValid("http://www.google.com" + ports[i]));
      }
    }
     
   }
  
   public void testYourSecondPartition(){
     UrlValidator urlV = new UrlValidator();
     String[] schemes = {"http://", "http:/", "://", ""};
     
     for (int i = 0; i < schemes.length; i++) {
       if (i > 0){
         assertFalse(urlV.isValid(schemes[i] + "www.google.com"));
       }else{
         assertTrue(urlV.isValid(schemes[i] + "www.google.com"));
       }
     }
   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
     UrlValidator urlV = new UrlValidator();
	   //You can use this function for programming based testing
     String[] validSchemes = {"http://"};
     String[] validAuthorities = {"www.google.com", "google.com"};
     String[] validPorts = {":0", ":65535", ":1", ""};
     String[] validPaths = {"/test", ""};
     String[] validQueries = {"", "?action=view"};
     for(String s : validSchemes){
       for(String a : validAuthorities){
         for(String po : validPorts){
           for(String pa : validPaths){
             for(String q : validQueries){
               System.out.println(s + a+ po + pa + q);
               assertTrue(urlV.isValid(s + a + po + pa + q));
             }
           }
         }
       }
     }
     
   }
   


}
