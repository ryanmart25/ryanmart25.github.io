package com.src.datastructures;

import java.util.Locale;

public class Movie implements toStringConverter {
    private String actor1;
    private String actor2;
    private String title;
    private String director;
    private int year;
    private float runtime;
    public Movie(String title,int year,String director,String actor1,String actor2,    float runtime){
        this.actor2=actor2;
        this.actor1=actor1;
        this.title = title;
        this.director = director;
        this.year = year;
        this.runtime=runtime;
    }
    public Movie(){}
    //will this actually work? pretty elegant
    public boolean isActorInMovie(String actor){

        return this.actor1.contains(actor.toLowerCase(Locale.ROOT).trim()) || this.actor2.contains(actor.toLowerCase(Locale.ROOT).trim());
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString(Movie m){
        return new String(m.getTitle()+"*"+ m.getYear() + "*"+m.getDirector()+"*"+m.getActor1()+"*"+m.getActor2()+"*"+m.getRuntime());
    }
}
