package com.example.dell.myapplicationtarp1;

/**
 * Created by DELL on 18/03/2018.
 */

class Medicines {
    private String Components;
    private String Expiry;
    private String Mfg;
    private String Name;
    private long Qty;
    public Medicines() {

    }

    public Medicines(String components, String expiry, String mfg, String name, long qty) {
        Components = components;
        Expiry = expiry;
        Mfg = mfg;
        Name = name;
        Qty = qty;
    }

    public String getComponents() {
        return Components;
    }

    public void setComponents(String components) {
        Components = components;
    }

    public String getExpiry() {
        return Expiry;
    }

    public void setExpiry(String expiry) {
        Expiry = expiry;
    }

    public String getMfg() {
        return Mfg;
    }

    public void setMfg(String mfg) {
        Mfg = mfg;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getQty() {
        return Qty;
    }

    public void setQty(long qty) {
        Qty = qty;
    }



}
