import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

class Main{  
  public static void main(String [] args){
    File loginFile = new File("login.txt");

    HashMap<String, Userdata> dataBase = new HashMap<String, Userdata>();

    try{
      //Building Hashmap
      Scanner sc = new Scanner(loginFile);
      
      //Reading from user/password file
      while (sc.hasNextLine()){
        String userInfo = sc.nextLine();
        int indexStart = userInfo.indexOf("e: ");
        int indexEnd = userInfo.indexOf(" |");
       
        String username = userInfo.substring(indexStart + 3, indexEnd); 

        indexStart = userInfo.indexOf("d: ");
        String password = userInfo.substring(indexStart + 3);

        Userdata userToAdd = new Userdata(username, password);
        dataBase.put(username, userToAdd);
      }
      sc.close();
    } catch(Exception e){
      System.out.println("Error");
    }

    //Getting username from user
    Scanner in = new Scanner(System.in);
    String usernameToSearch = "";
    boolean userNameFound = false;
    boolean passwordFound = false;
    do{
      System.out.println("Username: ");
      usernameToSearch = in.nextLine();

      if (dataBase.containsKey(usernameToSearch)){
        userNameFound = true;
        do {
          //Getting password from user
          System.out.println("Password: ");
          in = new Scanner(System.in);
          String passwordEntered = in.nextLine();

          if(passwordEntered.equals(dataBase.get(usernameToSearch).getPassword())){
            passwordFound = true;
            Functions.runApplication(dataBase.get(usernameToSearch));
          }
          else{
            System.out.println("Incorrect password. Try again.");
          }

        } while (!passwordFound);
      }
      else{
        System.out.println("That username is not in the system. Try again.");
      }
    } while (!userNameFound);
  }

}  