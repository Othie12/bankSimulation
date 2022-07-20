/*
This is a simple app that could simulate the basic operations a normal commercial bank does. that is
Depositing, withdrawing, creating an account and checking balance.

the program has four main methods that each stand for one of the above stated operations and an aditional method to hold the menu. I can call
it the proxy to other methods that I created in this program and it is the only one that I called in the main method of this program
*/
package banksimulation;
import java.util.*;



public class BankSimulation {

   //final class client{
   static long[] accounts = new long[10];
    static String[] passwords = new String[10];
    static String name = " ", name2, password, nin, pass2;
   static long tel, age, accNo, acc2;
   static double deposit = 0, bal = 0, amount;
   static int times = 0;
   
   static boolean checkacc(){
       
       int i = 0;
       while( i < 10){
            if(acc2 != accounts[i]){
               ++i;
       }else{
            return true;
       }         
   }
       return false;
   }
   
   static boolean checkpass(){
      
       int i = 0;
       while(i < 10){
           if(!validate(pass2, password)){
               ++i;
           }else{
               return true;
           }
       }
       return false;
   }
    static boolean validate(String arg1, String arg2){//it takes 2 strings and returns a boolean
       boolean ret = true;//the boolean will be initialized with a true value
       if(arg1.length() == arg2.length()){//first check the length of both strings
       for(int i = 0; i < arg1.length(); ++i){//then check characters one by one
           if(arg1.charAt(i)!= arg2.charAt(i)){
               ret = false;
               break;//if any of the characters is not the same with the other string, just return false and
           }//break the loop
       }
       }else{
       ret = false;//return false if the lengths donot rhyme
       }
       return ret;//the function returns the resultant boolean value
   }//end validate
    
     static void createAcc(){//method to create account
        Scanner c = new Scanner(System.in);
        Random rand = new Random();
        //this one is to basically get personal and authentication data that we shall use to authenticate the user
        System.out.println("**************CREATE ACCOUNT******************");
        System.out.print("Name: ");
            name = c.nextLine();
        System.out.print("Age: ");
            age = c.nextInt();
        System.out.print("Telephone: ");
            tel = c.nextInt();
        System.out.print("NIN: ");
        
            nin = c.next();
        System.out.print("Password(can contain letters and numbers): ");
            password = c.next();
            passwords[times] = password;
       
            accNo = rand.nextInt(3000);
            accounts[times] = accNo;
        System.err.printf("Thank you for opening up an account with us.\n Your account number is AC%.04s\n", accNo);
            System.out.println("");
    }//end create account
     
      static void deposit(){//depositing money
        Scanner con = new Scanner(System.in);
         System.out.println("**************DEPOSIT******************");
         
         System.out.print("Account number: AC");//get account number
            acc2 = con.nextInt();
            //see if it is the right one
            while(!checkacc()){
                System.err.print("Wrong account number.\nRe-enter account number: AC");
            acc2 = con.nextInt();
            }
            //If all is well, allow the user to deposit money
         System.out.print("Amount: shs.");
            deposit = con.nextDouble();
            bal += deposit;
         //show them their account balance
         System.out.printf("Deposit successful. your new balance is shs.%.2f\n", bal);
    }
      
       static void checkBal(){//function to check balance
       Scanner get = new Scanner(System.in);
         System.out.println("**************CHECK BALANCE******************");
         
          System.out.print("Account number: AC");
            acc2 = get.nextInt();
            
            while(!checkacc()){
                System.err.print("Wrong account number.\n Enter account number again: AC");
                acc2 = get.nextInt();
            }
            //all is the same authentication methods. Except that we now take the password since we are about to expose very sensitive info
            System.out.print("Password: ");
                pass2 = get.next();
                
                while(!checkpass()){
                    System.err.print("Wrong password.\nRe-enter password: ");
                    pass2 = get.next();               
                }
                //after ensuring the user, show them their balance
                System.out.printf(" Dear %s, your account balance is shs.%.2f\n", name.toUpperCase(), bal);
    }//end checkbalance
       
        static void withdraw(){
        Scanner in = new Scanner(System.in);
         System.out.println("**************WITHDRAW MONEY******************");
         
          System.out.print("Account number: AC");
            acc2 = in.nextInt();
            
            while(!checkacc()){
                System.err.println("Wrong account number.");
            System.out.print("Re-enter account number: AC");
            acc2 = in.nextInt();
            }
            
            System.out.print("Password: ");
                pass2 = in.next();
                
           while(!checkpass()){
                    System.err.print("Wrong password.\nRe-enter password: ");
                    pass2 = in.next();               
                }
                
         System.out.print("Amout: shs");
            amount = in.nextDouble();
            
            if(amount <= bal){//check if the account balance is lower than the amount we want to withdraw
                bal -= amount;
            System.out.printf("Thank you for withdrawing.\n Your new account balance is shs.%.2f\n", bal);
            }else{
            System.out.println("Insufficient balace.");
            }
         
    }//end withdraw
        
          static void menu(){//the menu method
        Scanner input = new Scanner(System.in);
        int option;
        
        System.out.println("______________________FLUX BANK____________________________");
        System.out.println("Welcome, what would you want to do?\n\t1. Create account\n\t2. Deposit\n\t3. check balabce\n\t4. Withdraw money\n\t0. Exit.");
            option = input.nextInt();
             
            
        switch(option){//what would the user want to do?
            case 1:
                createAcc();
                menu();
                break;             
            case 2://we'll first check if the user really entered their name. if not then they havent opened up an account
                if(name.charAt(0) == ' '){//this one is to prevent the user from doing any other thing without opening up account first
                    System.out.println("Please open up account first.");
                    menu();
                }else{
                    deposit();
                    menu();
                }
                break;
            case 3:
                 if(name.charAt(0) == ' '){
                    System.out.println("Please open up account first.");
                    menu();
                }else{
                    checkBal();
                    menu();
                }
                break;
            case 4:
                 if(name.charAt(0) == ' '){
                    System.out.println("Please open up account first.");
                    menu();
                }else{
                    withdraw();
                    menu();
                }
                break;
            case 0:
                System.out.println("Thank you");
                break;
            default:
                System.out.println("Invalid input.");
                menu();
                break;
        
        
    }//end of the menu method
            
          }    
//}
 
    
    public static void main(String[] args) {
while(times <= 10){
      menu();
    times++;
}
    }
}
