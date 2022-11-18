package com.src.inputandoutput;
import com.src.datastructures.Database;
import com.src.datastructures.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class UserHandler {
public static Scanner scan = new Scanner(System.in);
private static String state = "Main";
    //handle user input -

    //primary prompt
    public static void primaryPrompt(Database one) {
        //TODO implement finite state machine
        try{

            System.out.print("Main\n--------\nEnter Command: ");
            String command = scan.nextLine();
           command = command.toLowerCase(Locale.ROOT);
            command = command.trim();

            //what does this weird syntax nonsense do and why does my IDE autocomplete it
            switch (command) {

                case "new entry" -> UserHandler.secondaryNewEntryHandler(one);
                case "search by actor" -> {
                    System.out.print("\n\n\n\n\n\nEnter Actor's name: ");
                    String actor = scan.nextLine();
                   ArrayList<Movie> alm = one.searchByActor(actor);
                    if ( !alm.isEmpty()){
                        for (Movie M:
                                one.getAl()) {
                            System.out.println("I found this movie: " + M.getTitle() +", " + M.getYear() +"\n Director: " + M.getDirector() + "\n Actor: " + M.getActor1() + ", " + M.getActor2() + "\n Runtime: " + M.getRuntime());

                        }

                    }
                    else
                        System.out.println("Couldn't find anything :(");
                    one.getAl().clear();
                }
                case "search by year" -> {
                    System.out.print("\n\n\n\n\n\nEnter year made: ");
                    int year = scan.nextInt();
                    ArrayList<Movie> alm =  one.searchByYear(year);
                    if (!alm.isEmpty())
                    {
                        for (Movie M :
                                alm) {
                            System.out.println("I found this movie: " + M.getTitle() + "\n Director: " + M.getDirector() + "\n Actor: " + M.getActor1() + ", " + M.getActor2() + "\n Runtime: " + M.getRuntime());

                        }

                    }
                    else
                        System.out.println("Couldn't find anything :(");
                    one.getAl().clear();
                }
                case "search by runtime" -> {
                    System.out.print("\n\n\n\n\n\nEnter runtime: ");
                    float f = scan.nextFloat();
                    ArrayList<Movie> alm =  one.searchByRuntime(f);
                    if (!alm.isEmpty()){
                        for (Movie M :
                                alm) {
                            System.out.println("I found this movie: " + M.getTitle() + "\n Director: " + M.getDirector() + "\n Actor: " + M.getActor1() + ", " + M.getActor2() );

                        }

                    }
                    else
                        System.out.println("Couldn't Find Anything :(");
                    one.getAl().clear();
                }
                case "search by director" -> {
                    System.out.print("\n\n\n\n\n\nEnter Director's Name: ");
                    String director = scan.nextLine();
                   ArrayList<Movie> alm =  one.searchByDirector(director);
                   if (!alm.isEmpty()){
                       for (Movie M :
                               alm) {
                           System.out.println("I found this movie: " + M.getTitle() +", " + M.getYear() + "\n Actor: " + M.getActor1() + ", " + M.getActor2() + "\n Runtime: " + M.getRuntime());

                       }

                   }
                   else
                       System.out.println("Could not find anything :(");
                   one.getAl().clear();
                }
                case "search by title" -> {

                    System.out.print("\n\n\n\n\n\nEnter Movie Title: ");

                    String title = scan.nextLine();
                   ArrayList<Movie> alm =  one.searchByTitle(title);
                    if (!alm.isEmpty()) {
                        for (Movie M :
                                alm) {
                            System.out.println("I found this information: " + M.getYear() + "\n Director: " + M.getDirector() + "\n Actor: " + M.getActor1() + ", " + M.getActor2() + "\n Runtime: " + M.getRuntime());

                        }
                    }
                    else
                        System.out.println("Couldn't find anything");
                    one.getAl().clear();
                }
                case "quit" ->
                        //TODO create quit method
                        Database.quit(one);
                default -> System.out.println("\nCommand Not Recognized. Please Input a valid command.");
            }
        }
        catch(NoSuchElementException e){


            System.out.println("\n--Error: The line the scanner tried to grab is null--");
        }
    }
    //new entry method must Ask for year,Actors, Director,Title,Runtime.
    // and append to the List.
    // TODO Save list on quit()

    /*private static void secondaryNewEntryHandler(Scanner s,Database one){
        String t,a1,a2,d;
        int y;
        float rt;
        System.out.print("Enter movie Title:  ");
        //on this nextLine(), throws an error.
        // I haven't had the chance to input title.
        //jump to catch(NoSuchElementException)
                 t=s.nextLine();
                 System.out.print("\nEnter Director: ");
                 d=s.nextLine();
                 System.out.print("\nEnter first actor: ");
                 a1=s.nextLine();
                 System.out.print("\nEnter second Actor: ");
                 a2=s.nextLine();
                 System.out.print("\nEnter runtime: ");
        rt=Float.parseFloat(s.nextLine());
                 System.out.println("\nEnter Year");
                 y=s.nextInt();
        Movie newestEntry = new Movie(t,y,d,a1,a2,rt);
        one.getMovieList().add(newestEntry);
    }
*/
    private static void secondaryNewEntryHandler(Database one){
        String t,a1,a2,d;
        int y;
        float rt;
       // s.useDelimiter(System.lineSeparator());



    System.out.print("Enter movie Title:  ");

    t = scan.nextLine();
    System.out.print("\nEnter Director: ");
    d = scan.nextLine();
    System.out.print("\nEnter first actor: ");
    a1 = scan.nextLine();
    System.out.print("\nEnter second Actor: ");
    a2 = scan.nextLine();
    System.out.print("\nEnter runtime: ");
    rt = Float.parseFloat(scan.next());
    System.out.println("\nEnter Year: ");
    y = scan.nextInt();
    Movie newestEntry = new Movie(t, y, d, a1, a2, rt);
    one.getMovieList().add(newestEntry);


    }
}
