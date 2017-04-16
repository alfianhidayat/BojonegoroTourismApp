package com.usramrizal.bojonegoro_tourism;

/**
 * Created by amrizalns on 4/15/17.
 */

public class ItemObject {

    private String location;
    private String name;
    private int img;

    public ItemObject(String Location , String name, int img) {
        this.location = Location;
        this.name = name;
        this.img = img;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
