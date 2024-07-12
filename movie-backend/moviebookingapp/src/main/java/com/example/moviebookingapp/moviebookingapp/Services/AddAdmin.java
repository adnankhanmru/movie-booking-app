package com.example.movie_booking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.movie_booking.Entities.Admin;
//import com.example.movie_booking.Entities.Movie;
//import com.example.movie_booking.Entities.Screen;
//import com.example.movie_booking.Entities.Theater;

import com.example.moviebookingapp.moviebookingapp.Entities.Admin;
import com.example.moviebookingapp.moviebookingapp.Entities.Theater;
import com.example.moviebookingapp.moviebookingapp.Entities.Movie;
import com.example.moviebookingapp.moviebookingapp.Entities.Screen;

@Service
public class AddAdmin extends Admin {

    @Autowired
    @PostMapping("/allAdmin/")
    public Integer addTheatre(Theater theater){
        System.out.println("Theatre Name:"+theater.getTheaterName());
    return theater.getTheaterId();
    }

    @Autowired
    @PostMapping("/allAdmin/")

    public static void AddMovie(Movie movie, @RequestParam Integer adminid,@RequestParam String movieName){

        if(adminid>=0){System.out.println((movieName)+"true");}
    }
//        return 0;

    @GetMapping("/allAdmin/")
    public Integer getScreen(@RequestBody Screen screen,@RequestParam  Integer adminId,@RequestParam String movieName){
        if(adminId>0){return adminId;}
        else return adminId;
    }

    @PostMapping("/allAdmin/")
    @Autowired
    public static void addScreen(Screen screen,@RequestParam int screenid ){
       if(screenid>=0){System.out.println("Movie Screen"+screen.getScreenName());}
       System.out.println(screenid);
    }

//    @PostMapping("/allAdmin/")
//    @Autowired

//    public Integer addTheatre(@RequestBody Theater theatre,@RequestParam Integer theatername){
//        System.out.println("Theatre Name:"+theatername);
//    }
    @Autowired
    @PostMapping("/allAdmin/")

    public static void  addShow(@RequestParam Integer showId){

        System.out.println("Show Name:"+showId.intValue());
    }


    @Autowired
    @PostMapping("/allAdmin/")

    public Integer deleteTheatre(@RequestParam Integer showId){
        if(showId>=0){System.out.println("Theatre Name deleted:"+showId--);}
        return showId;
    }
    @Autowired
    @PostMapping("/allAdmin/")

    public boolean deleteScreen(@RequestParam Integer screenId){
        if(screenId>=0){System.out.println("Deleted screen id" +screenId--);}
        return true;
    }
}
