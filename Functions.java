import java.util.Scanner;

public class Functions {

  public static void runApplication(Userdata data){
    
    Scanner in = new Scanner(System.in);
    String option = "";
    do{
      Functions.mainMenu(data.getUsername());
      option = in.nextLine();
      
      switch(option){
        case "1": 
          System.out.println("Tuition is 400$ per credit (Each course is 4 credits).");
          System.out.println("Please enter the amount of credits you plan to take.");
          Scanner in2 = new Scanner(System.in);
          int credits = Integer.parseInt(in2.nextLine());
          int tuition = data.calcTuition(credits);
          System.out.println("The tuition for your courses will be $" + tuition);
          break;

        case("q"):
          System.out.println("Thank you for using the application!");
          break;
        
        default:
         System.out.println("Your input does not match any of the given functions. Please try again.");
         break;
        
        
      }
    } while (!option.equals("q"));
    
  }

  public static void mainMenu(String username){
    System.out.println("Hello " + username + "!");
    System.out.println("1. Calculate tuition");
    System.out.println("Enter (q) to quit application.");
  }
}


