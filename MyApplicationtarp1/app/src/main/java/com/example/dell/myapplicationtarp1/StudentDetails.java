package com.example.dell.myapplicationtarp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juned on 7/25/2017.
 */

public class StudentDetails {

   // List<String> Medicines = new ArrayList<>();
    private String Password;
    private String date;
    private String Doctor_id;
private String id;
    public List<Medicines> getMedList() {
        return medList;
    }

    public void setMedList(List<Medicines> medList) {
        this.medList = medList;
    }

    private List<Medicines> medList ;
    public StudentDetails() {

    }

    public StudentDetails(String date, String doctor_id, String password) {
        this.date = date;
        Doctor_id = doctor_id;
     //   Medicines = medicines;
        Password = password;
    }

  //  public List<String> getMedicines() {
    //    return Medicines;
    //}  ArrayList<String> medicines,


    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





    public String getPassword() {
        return Password;
    }

    public String getDoctor_id() {
        return Doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        Doctor_id = doctor_id;
    }

    public void setPassword(String password) {
        Password = password;
    }


}