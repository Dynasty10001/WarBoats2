package com.example.cst143warboats;

import java.io.Serializable;

public class player implements Serializable {
    public long id;
    public String name;
    public int score;
    public String pic;

    public player(String name, int score, String pic)
    {
        this.id = -1;
        this.name = name;
        this.score = score;
        this.pic = pic;
    }

}
