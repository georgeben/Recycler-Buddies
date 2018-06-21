package com.kurobarabenjamingeorge.recyclerbuddies;

/**
 * Created by George Benjamin on 6/21/2018.
 */

public class Buddy {
    private String buddy_name;
    private String buddy_description;

    public Buddy(String buddy_name, String buddy_description) {
        this.buddy_name = buddy_name;
        this.buddy_description = buddy_description;
    }

    public String getBuddy_name() {
        return buddy_name;
    }

    public String getBuddy_description() {
        return buddy_description;
    }
}
