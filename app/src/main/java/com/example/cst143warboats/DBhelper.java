package com.example.cst143warboats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Warships.db";
    private static final String TABLE_NAME = "Players";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String SCORE = "score";
    public static final String PIC = "pic";
    private static final int DB_VERSION = 1;
    public SQLiteDatabase sqlDB;

    /**
     *This is a database helper app.
     * @param context
     */
    public DBhelper(Context context) { super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sCreate = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " integer primary key autoincrement, " +
                NAME + " text not null, " +
                SCORE + " double not null, " +
                PIC + " text not null);";
        db.execSQL(sCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop existing table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //call onCreate to recreate it
        onCreate(db);
    }

    public void open() throws SQLException
    {
        sqlDB = this.getWritableDatabase();
    }

    public void close()
    {
        sqlDB.close();
    }

    public long createPlayer(player player)
    {
        // a container storing each column and value for a row
        ContentValues cvs = new ContentValues();
        cvs.put(NAME, player.name);
        cvs.put(SCORE, player.score);
        cvs.put(PIC, player.pic);

        player.id = sqlDB.insert(TABLE_NAME, null, cvs);
        return player.id;
    }

    public boolean updatePlayer(player player)
    {
        ContentValues cvs = new ContentValues();
        cvs.put(NAME, player.name);
        cvs.put(SCORE, player.score);
        cvs.put(PIC, player.pic);

        return sqlDB.update(TABLE_NAME,cvs , ID + " = " + player.id,null) > 0;
    }

    public Cursor getAllPlayers()
    {
        String sFields[] = new String[] {ID,NAME,SCORE,PIC};
        return sqlDB.query(TABLE_NAME, sFields, null, null, null, null, null);
    }

    /**
     * This method is called to get an ArrayList of all players in the database.
     * @return
     */
    public ArrayList<player> getPlayerlist()
    {
        Cursor cursor = getAllPlayers();
        ArrayList<player> listrtn = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                listrtn.add(new player(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return listrtn;
    }

}
