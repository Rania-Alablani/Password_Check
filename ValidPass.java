package validpass;
// Rania
//Aziz challenge
import java.util.Scanner;
public class ValidPass {
 static int minChange =0;
 
    public static void main(String[] args) {
       Scanner input = new Scanner (System.in);
        System.out.println("*** This program will check whether your password is strong or not ***\n");

        System.out.print("Enter your password: ");
        String userPassword = input.next();

        System.out.print(userPassword.length() +" characters total");
        checkPass1 (userPassword);
        
        System.out.println("\n"+minChange + " minimum change.");
    }
    
     public static void checkPass1 (String pass ){
         if (pass.length() >= 8 && pass.length() <= 20) {
        } 
         else {
           if (pass.length()==21 ){
               minChange++;
              System.out.print(", need to delete one character");
           }
        }
           if (checkPass2 (pass)) {}
          if(checkPass3(pass)){}
     }
     
    public static boolean checkPass2 (String pass ){
        
        boolean hasUpper= false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i< pass.length(); i++) {
           
            if (Character.isUpperCase(pass.charAt(i))) {
                hasUpper = true;
            }else if (Character.isLowerCase(pass.charAt(i))){
            hasLower= true;
            }else if (Character.isDigit(pass.charAt(i))){
            hasDigit=true;
            }
            
            if (hasUpper && hasLower && hasDigit){
            return true;
            }
        }
        
        if (hasUpper==false){
            System.out.print(", need to add at least one uppercase letter");
            minChange++;
        }if (hasLower==false){
            System.out.print(", need to add at least one lowercase letter");
            minChange++;
        }if (hasDigit==false){
            System.out.print(", need to add at least one digit");
            minChange++;
        }
        return false;
    }
    
    public static boolean checkPass3 (String pass){
           for (int i = 1; i< pass.length()-1 ; i++) {
               if ( pass.charAt(i)==pass.charAt(i-1) && pass.charAt(i)==pass.charAt(i+1) ){
                   minChange++;
                   System.out.print("\nContains more than 3 repeating characters in a row - \""+pass.charAt(i-1)+pass.charAt(i)+pass.charAt(i+1)
                                          +"\" ,need to replance an \""+pass.charAt(i)+"\" with a different character.");
                break;
               }
           }
        return false;
    }
}
