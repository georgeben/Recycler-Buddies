package com.kurobarabenjamingeorge.recyclerbuddies;

/**
 * Created by George Benjamin on 6/21/2018.
 */

public class Buddy {
    private String buddy_name;
    private String buddy_description;
    private int img_res;

    public Buddy(String buddy_name, String buddy_description, int img_res) {
        this.buddy_name = buddy_name;
        this.buddy_description = buddy_description;
        this.img_res = img_res;
    }

    public String getBuddy_name() {
        return buddy_name;
    }

    public String getBuddy_description() {
        return buddy_description;
    }

    public int getImg_res() {
        return img_res;
    }
}
