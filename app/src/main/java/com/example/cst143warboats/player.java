package com.example.cst143warboats;

import java.io.Serializable;

/**
 *This is a player class that is used for easier database entry.
 */
public class player implements Serializable {
    public long id;
    public String name;
    public int score;
    public String pic;

    /**
     * Player constructor for new players to be entered in the database.
     * @param name
     * @param score
     * @param pic
     */
    public player(String name, int score, String pic)
    {
        this.id = -1;
        this.name = name;
        this.score = score;
        this.pic = pic;
    }

    /**
     * Player constructor with ID for players coming from the database.
     * @param id
     * @param name
     * @param score
     * @param pic
     */
    public player(long id, String name, int score, String pic)
    {
        this.id = id;
        this.name = name;
        this.score = score;
        this.pic = pic;
    }

}
