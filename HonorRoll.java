import java.util.*;

public class HonorRoll{

  private ArrayList<Student> honorList; //new arrayList

  //Stores given arraylist to new.
  HonorRoll(ArrayList<Student> honorList){ 
    this.honorList = honorList;
  }

  //Drops those who are lower than num.
  public void configureStudents(double num){
    for (int i = 0; i < honorList.size(); i++){ //Cycles given size of student body.
      if (honorList.get(i).getGpa() < num){ //Does nothing (maybe something in the future)
        honorList.remove(i); //Removes student lower than num.
        i--;
      }
    }
  }

  //Ranks students.
  public void rankStudents(){
    int count = 0; //made so that once the overall max is found for each, it skips the found max. if variable i was 0 intially, the second while loop run will intialze i with the value of 1, skipping the previous overall maximum.
    double maxNum = honorList.get(0).getGpa();

    //Runs until a complete cycle through the whole arraylist.
    while(count != honorList.size()-1){
      int maxIndex = 0;

      //Simple find max algorithm
      for (int i = count; i < honorList.size(); i++){
        if(maxNum <= honorList.get(i).getGpa()){
          
          maxIndex = i;
          maxNum = honorList.get(i).getGpa();
        }
      }
    
    //Adds to the index of count and removes previous location of the student.
      honorList.add(count, honorList.get(maxIndex));
      honorList.remove(maxIndex+1);
      count++;
      //Sets new maximum to avoid contridicting values.
      maxNum = honorList.get(count).getGpa();
    }
  }
    
  

  
  // This. Is. A. To. String. Method.
  @Override
  public String toString(){
    String build = "";
    for (int i = 0; i < honorList.size(); i++){
      build += i+1 + ") " + honorList.get(i) + "\n";
    }
    return "Honor Students: \n" + build;
  }
}