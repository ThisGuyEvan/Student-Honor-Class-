import java.util.*;

class Main {
  public static void main(String[] args){
    //Scanner.
    Scanner console = new Scanner(System.in);
    ////////////////////////////////////////////////////
    //              Intializing variables             //
    ////////////////////////////////////////////////////
    System.out.print("How many students: ");
    int studentNum = console.nextInt();

    System.out.print("What's the maximum grade? A+ = ");
    int maxGrade = console.nextInt();

    System.out.print("What's the minimum grade? F = ");
    int minGrade = console.nextInt();

    ArrayList<Student> roster = new ArrayList<Student>(); //Create class.

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    System.out.println(Arrays.toString(alphabet)); //Array of (char) letters.
    

    ////////////////////////////////////////////////////
    //                Creating Students               //
    ////////////////////////////////////////////////////

    //Cycling through to create new "names" and random averages.
    for (int i = 0; i < studentNum; i++){
      double randomizer = (double) Math.round((minGrade + (Math.random() *(maxGrade-minGrade))) *100.0)/100.0;  //Random average. Cap: 106.
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

    System.out.print("What will be the honor average requirement?");
    int require = console.nextInt();

    //Non ranked print, based on default arraylist order.
    students.configureStudents(require);
    System.out.println(students.toString() + "\n");

    //Ranking print.
    students.rankStudents();
    System.out.println(students.toString() + "\n");

    console.close();
  }
}