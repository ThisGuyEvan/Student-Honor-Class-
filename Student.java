import java.util.*;

public class Student{
  private String name;
  private double gpa;

  Student(String name, double gpa){
    this.name = name;
    this.gpa = gpa;
  }


  //Setters and getters.
  public double getGpa(){
    return this.gpa;
  }

  public String getName(){
    return this.name;
  }

  public void setGpa(double newGpa){
    this.gpa = newGpa;
  }

  public void setName(String newName){
    this.name = newName;
  }
  

  //Print to string.
  @Override

  public String toString(){
    return name + "'s GPA: " + gpa;
  }

}