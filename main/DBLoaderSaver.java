package com.src.main;

import com.src.datastructures.Database;
import com.src.datastructures.Movie;

import java.io.*;
import java.util.*;

public class DBLoaderSaver {


    public static ArrayList<Movie> loadMovies() {
        //create array list for database
        ArrayList<Movie> list = new ArrayList<>();
        //set up for reading data in

        //scanner handles file reading
        try{
            Scanner scan = new Scanner(new File("\\C:\\Users\\User\\eclipse-workspace\\moviedatabase\\src\\com\\src\\datastructures\\db.txt.txt\\"));
            StringTokenizer st;
            String t,d,a1,a2;
            int y;
            float rt;
            //long counter = 0L;
            //define a new Tokenizer with each new line. Read data into temp variables. Append new Movie objects to database ArrayList
            while(scan.hasNextLine()){


                String data = scan.nextLine();
                st = new StringTokenizer(data,"*");

                try {
                    t = st.nextToken();
                    y=Integer.parseInt(st.nextToken());
                    d = st.nextToken();
                    a1 = st.nextToken();
                    a2 = st.nextToken();
                    rt = Float.parseFloat(st.nextToken());
                    list.add(new Movie(t.toLowerCase(Locale.ROOT).trim(),y,d.toLowerCase().trim(),a1.toLowerCase().trim(),a2.toLowerCase().trim(),rt));
                    }
                    catch(NoSuchElementException e){
                        System.out.println("Something is wrong with this token. Ask whoever made this database file...moving on");

                    }

            }
           // dls.setListLength(counter);
            scan.close();
        }
        catch(IOException e)
        {
            System.out.println("Could not find db.txt");
        }
        System.out.println("Database successfully loaded.");

        return list;
    }

    /*
public static boolean isSameSize(Database h, String filename, DBLoaderSaver j){
    int length = h.getMovieList().size();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        long throwawaycounter = 0L;
        while(reader.readLine()!= null)
        {
            String throwaway = reader.readLine();
            throwawaycounter++;

        }
        if(throwawaycounter< j.getListLength())
        {

        }
    } catch (IOException e) {
        e.printStackTrace();


    }
    return true;
}

     */
    public static void saveList(Database d){
        File file = new File("\\C:\\Users\\User\\eclipse-workspace\\demonstration\\src\\constructorsAndObjects\\db.txt.txt\\");

        if (file.exists()){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (Movie s:d.getMovieList()
                ) {
                    writer.write(s.toString());
                    writer.newLine();
                }

                writer.close();
            }
            catch(IOException e){
                System.out.println("AN error occurred...");
                e.printStackTrace();
            }
        }

    }


}
