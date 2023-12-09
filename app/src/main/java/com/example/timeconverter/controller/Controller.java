package com.example.timeconverter.controller;

import com.example.timeconverter.model.TimeConvert;

public class Controller {
    private static Controller instance;
    private  static  TimeConvert timeConvert;
    // attributs de classe
    private Controller(){
        super();
    }

    public static final Controller getInstance(){
            if (Controller.instance==null)
                Controller.instance=new Controller();
            return instance;

    }

    public void createTimeConvertion(long secondes){
     timeConvert =new TimeConvert(secondes);

        }
    public String getTemps() {
       return timeConvert.getTemps();
    }

}
