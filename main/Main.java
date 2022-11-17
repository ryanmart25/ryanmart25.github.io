package com.src.main;

import com.src.datastructures.Database;
import com.src.inputandoutput.UserHandler;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //load db.txt contents. Create a database object
        //
        //TODO change persistence from do-while to FSM


        System.out.println("booting up...");

        System.out.println("Loading database...");
        Database db = new Database(DBLoaderSaver.loadMovies(),
                                 true,
                                 "\\C:\\Users\\User\\eclipse-workspace\\moviedatabase\\src\\com\\src\\datastructures\\db.txt\\");
        System.out.println("""

                 __      ___     _              _____        _        _                      _____           _           _  \s
                 \\ \\    / (_)   | |            |  __ \\      | |      | |                    |  __ \\         (_)         | | \s
                  \\ \\  / / _  __| | ___  ___   | |  | | __ _| |_ __ _| |__   __ _ ___  ___  | |__) | __ ___  _  ___  ___| |_\s
                   \\ \\/ / | |/ _` |/ _ \\/ _ \\  | |  | |/ _` | __/ _` | '_ \\ / _` / __|/ _ \\ |  ___/ '__/ _ \\| |/ _ \\/ __| __|
                    \\  /  | | (_| |  __/ (_) | | |__| | (_| | || (_| | |_) | (_| \\__ \\  __/ | |   | | | (_) | |  __/ (__| |_\s
                     \\/   |_|\\__,_|\\___|\\___/  |_____/ \\__,_|\\__\\__,_|_.__/ \\__,_|___/\\___| |_|   |_|  \\___/| |\\___|\\___|\\__|
                                                                                                           _/ |             \s
                                                                                                          |__/              \s
                """);

        System.out.println("""
                Welcome! Valid commands are:\s
                 search by title/year/director/actor/runtime\s
                 new entry
                 delete movie\n quit""");
        do{
            UserHandler.primaryPrompt(db);
        }
        while(db.isRunning());

        UserHandler.scan.close();
        }


}
