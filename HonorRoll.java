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
      if (honorList.get(i).getGpa() >= num){} //Does nothing (maybe something in the future)
      else{
        honorList.remove(i); //Removes student lower than num.
        i--;
      }
    }
  }

  //Ranks students.
  public void rankStudents(){
    int count = 0; //made so that once the overall max is found for each, it skips the found max.
    //Ex: {10, 23, 42, 12} 
    double maxNum = honorList.get(0).getGpa();

    while(count != honorList.size()-1){
      int maxIndex = 0;

      for (int i = count; i < honorList.size(); i++){
        if(maxNum <= honorList.get(i).getGpa()){
          
          maxIndex = i;
          maxNum = honorList.get(i).getGpa();
        }
      }

      honorList.add(count, honorList.get(maxIndex));
      honorList.remove(maxIndex+1);
      count++;
      maxNum = honorList.get(count).getGpa();
    }
  }
    
  

  

  @Override
  public String toString(){
    String build = "";
    for (int i = 0; i < honorList.size(); i++){
      build += i+1 + ") " + honorList.get(i) + "\n";
    }
    return "Honor Students: \n" + build;
  }
}