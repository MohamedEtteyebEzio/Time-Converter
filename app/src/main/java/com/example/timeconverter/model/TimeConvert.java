package com.example.timeconverter.model;

public class TimeConvert {

    long secondes;
    String temps;

    public TimeConvert(long secondes) {
        this.secondes=secondes;
        setReponse();
    }


    public String getTemps() {
        return temps;
    }

    public long getSecondes() {
        return secondes;
    }

    public void setReponse() {

        long heurs = secondes / 3600;
        long reste = secondes % 3600;
        long minutes = reste / 60;
        long secs = reste % 60;

        //temps : l'attribut qui content le résultat
        temps =  String.format("%02d:%02d:%02d", heurs, minutes, secs);


    }


}
