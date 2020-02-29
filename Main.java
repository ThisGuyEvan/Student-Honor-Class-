import java.util.*;

class Main {
  public static void main(String[] args){
    Scanner console = new Scanner(System.in); //Scanner

    ////////////////////////////////////////////////////
    //              Intializing variables             //
    ////////////////////////////////////////////////////
    System.out.print("How many students: ");
    int studentNum = console.nextInt();

    System.out.print("What's the maximum grade? A+ = ");
    double maxGrade = console.nextDouble();

    System.out.print("What's the minimum grade? F = ");
    double minGrade = console.nextDouble();

    ArrayList<Student> roster = new ArrayList<Student>(); //Create class.

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    System.out.println(Arrays.toString(alphabet)); //Array of (char) letters.
    

    ////////////////////////////////////////////////////
    //                Creating Students               //
    ////////////////////////////////////////////////////

    //Cycling through to create new "names" and random averages.
    for (int i = 0; i < studentNum; i++){
      double randomizer = (double) Math.round((minGrade + (Math.random() *(maxGrade-minGrade))) *100.0)/100.0;  //Random average to the hundredth place.
      String name = "";
      for (int x = 0; x < 2 + (Math.random() * 6); x++){
        name += alphabet[(int) (Math.random() * 26)]; //Adds uses the chars(1-27) to build up a name.
      }
      roster.add(new Student(name,randomizer));
    }
   
    ////////////////////////////////////////////////////
    //              Testing Honor Class               //
    ////////////////////////////////////////////////////
    //Printing & testing
    HonorRoll students = new HonorRoll(roster); //Creating class
    System.out.println(students.toString() + "\n");

    System.out.print("What is the required average to be an honor student? ");
    double require = console.nextDouble();

    //Non ranked print, based on default arraylist order.
    students.configureStudents(require);
    System.out.println("--------------------------\n!!! This is UN-SORTED !!!\n--------------------------");
    System.out.println(students.toString() + "\n");

    //Ranking print.
    students.rankStudents();
    System.out.println("-----------------------\n!!! This is SORTED !!!\n-----------------------");
    System.out.println(students.toString() + "\n");

    console.close();
  }
}