import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
public class mazeSolver {

  public static List<String> entradaSaida = new ArrayList<String>();

  public static void printMaze(String maze[][]) {
    for(int i = 0; i < maze.length; i++) {
      for(int j = 0; j < maze.length; j++) {
        if(j % maze.length == 0 && i != 0) System.out.println();
        System.out.print(maze[i][j] + " ");
      }
    }
    System.out.println();
  }

  public static String toBinary(String hex) {
    switch(hex) {
      case "0" : hex = "0000"; break;
      case "1" : hex = "0001"; break;
      case "2" : hex = "0010"; break;
      case "3" : hex = "0011"; break;
      case "4" : hex = "0100"; break;
      case "5" : hex = "0101"; break;
      case "6" : hex = "0110"; break;
      case "7" : hex = "0111"; break;
      case "8" : hex = "1000"; break;
      case "9" : hex = "1001"; break;
      case "a" : hex = "1010"; break;
      case "b" : hex = "1011"; break;
      case "c" : hex = "1100"; break;
      case "d" : hex = "1101"; break;
      case "e" : hex = "1110"; break;
      case "f" : hex = "1111"; break;
      default: break;
    }

    return hex;
  }

  //Tem que testar mais casos pra essa merda
  public static void startEnd(String[][] maze) {
    for(int i = 0; i < maze.length; i++) {
      if(maze[0][i].charAt(0) == ('0')) entradaSaida.add(maze[0][i]); //Abertura Superior
      if(maze[i][maze.length-1].charAt(1) == '0') entradaSaida.add(maze[i][maze.length-1]); //Abertura direita
      if(maze[i][0].charAt(3) == '0') entradaSaida.add(maze[i][0]);//Abertura esquerda
      if(maze[maze.length-1][i].charAt(2) == '0') entradaSaida.add(maze[maze.length-1][i]); //Abertura inferior 
    }
  }

  public static void main(String[] args) {
    
    File file = new File(args[0]);

    try {

      Scanner in = new Scanner(file);
      int size = Integer.parseInt(in.next());
      in.nextLine();
      System.out.println(size);
      String l [][] = new String[size][size];

      while(in.hasNext()) {
        for(int i = 0; i < size; i++) {
          for(int j = 0; j < size; j++) {
            l[i][j] = toBinary(in.next());
          }
        }
      }
      printMaze(l);
      startEnd(l);
    } catch(FileNotFoundException e) {
        e.printStackTrace();
      }

    System.out.println("Entrada/Saida ---> " + entradaSaida);
    }
  }
