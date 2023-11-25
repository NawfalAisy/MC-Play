package com.example.a2502009715_mcs_uas;

public class articles {

    private int image;
    private String name;
    private Integer ID;

    public articles(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
