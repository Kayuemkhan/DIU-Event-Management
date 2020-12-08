package com.example.diuems;

public class Events {
    String date, place,venue;
    public Events(){

    }

    public Events(String date, String place, String venue) {
        this.date = date;
        this.place = place;
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
