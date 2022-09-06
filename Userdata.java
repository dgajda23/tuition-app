import java.util.ArrayList;

public class Userdata {
  String username;
  String password;
  ArrayList<String> courses;
  
  public Userdata(String usernameInit, String passwordInit){
    password = passwordInit;
    username = usernameInit;
    courses = new ArrayList<String>();
  }

  public String getPassword(){
    return password;
  }

  public String getUsername(){
    return username;
  }

  public void add(String courseToAdd){
    courses.add(courseToAdd);
  }

  public void remove(String courseToRemove){
    int index = 0;
    boolean courseFound = false;
    for (int i = 0; i < courses.size(); i++){
      if (courseToRemove == courses.get(i)){
        index = i;
        courseFound = true;
      }
    }
    if (courseFound){
      courses.remove(index);
    }
    else{
      System.out.println("You are not registered for that course");
    }
  }

  public void view(){
    if (courses.size() > 0){
      for (int i = 0; i < courses.size(); i++){
        System.out.println((i + 1) + ". " + courses.get(i));
      }
    }
    else{
      System.out.println("You have no courses to print.");
    }
  }

    public int calcTuition(int credits){
      int tuition = 400 * credits;
      return tuition;
    }
}
