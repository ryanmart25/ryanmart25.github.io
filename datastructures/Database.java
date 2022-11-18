package com.src.datastructures;

import com.src.main.DBLoaderSaver;

import java.io.*;
import java.util.ArrayList;

public class Database extends Movie {
    private ArrayList<Movie> movieList;
    private boolean running;
    private final String file;

    public ArrayList<Movie> getAl() {
        return al;
    }

    private ArrayList<Movie> al = new ArrayList<>();
            //= new File("\\\\db.txt");
    private long listLength;
  //  private BufferedReader reader;
    //private BufferedWriter writer;
    public Database(ArrayList<Movie> list, boolean running, String filename){
        this.movieList = list;
        this.setRunning(running);
       // this.reader=reader;
        //this.writer=writer;
        this.file = filename;
    }


    public String deleteMovie(Movie movie){
        String status = "Not removed, or movie was not in the database to begin with. ";
        for (int i = 0; i < this.al.size(); i++) {
            if (this.al.get(i).equals(movie)){
                this.al.remove(i);
                status = "removed";
                break;
            }
        }
        return status;
    }


    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    //quit method
    public static void  quit(Database d) {
        d.setRunning(false);

            DBLoaderSaver.saveList(d);

            //Force saves, even if no movies were added/deleted
    }

//search methods
    //Must support - By Actor, By Year, by Title, by runtime, Director
public ArrayList<Movie> searchByActor(String name){

    for (Movie m :
            this.getMovieList()) {
        if (m.isActorInMovie(name)){
            this.al.add(m);

        }

    }
    return this.al;
}
public ArrayList<Movie> searchByYear(int n){
    for (Movie m :
            this.getMovieList()) {
        if (m.getYear()==n){
            this.al.add(m);

        }
    }
    return this.al;
}
public ArrayList<Movie> searchByTitle(String t){

    for (Movie m :
            this.getMovieList()) {
        if (m.getTitle().equals(t.toLowerCase().trim())){
        this.al.add(m);
        }

    }
        return this.al;
}
public ArrayList<Movie> searchByRuntime(float r){
    for (Movie m :
            this.getMovieList()) {
        if (m.getRuntime() == r){
this.al.add(m);      }
    }
    return this.al;
}
public ArrayList<Movie> searchByDirector(String name){
    for (Movie m :
            this.getMovieList()) {
        if (m.getDirector().equals(name.toLowerCase().trim())){
            this.al.add(m);
        }
    }
    return this.al;
}

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }


        //use append(CharSequence, int start, int end)

        //get the size of the list,  get the last movie of the list, shift writer cursor to the size of the list,write movie data to the file

        //save file, close writer and reader quit program


}


