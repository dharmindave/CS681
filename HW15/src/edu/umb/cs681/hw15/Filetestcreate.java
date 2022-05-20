package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Filetestcreate {
    public static void main(String[] args){
        LocalDateTime creationtime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
        String time=creationtime.format(formatter);

        LocalDateTime creationtime1=LocalDateTime.now();
        Directory root=new Directory(null,"Root",0,creationtime );


        LocalDateTime creationtime2=LocalDateTime.now();
        Directory home=new Directory(root,"home",0,creationtime1 );
        Directory system=new Directory(root,"system",0,creationtime1 );
        Directory pictures=new Directory(home,"pictures",0,creationtime1 );
        File filea=new File(home,"file:a",1,creationtime2 );
        File fileb=new File(system,"file:b",1,creationtime2 );
        File filec=new File(system,"file:c",1,creationtime2 );
        File filed=new File(system,"file:d",1,creationtime2 );
        File filee=new File(pictures,"file:e",1,creationtime2 );
        File filef=new File(pictures,"file:f",1,creationtime2 );

        System.out.println("The Size of the directory home: " +home.getTotalsize());

        System.out.println("The Size of the directory root: " +root.getTotalsize());

        System.out.println("The Size of the directory system: " +system.getTotalsize());

        System.out.println("The Size of the directory pictures: " +pictures.getTotalsize());


    }
}
