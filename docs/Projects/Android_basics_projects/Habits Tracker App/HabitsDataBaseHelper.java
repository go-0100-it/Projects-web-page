package com.waters89gmail.dave.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WatersD on 8/7/2016.
 */
public class HabitsDataBaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = ("MYLOG");

    Context context;
    // Database Version & Name
    // If the database schema is changed, the database version must be incremented.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habit_tracker";

    //Constant values for
    private static final String TEXT_TYPE = "TEXT";
    private static final String OPEN_PAR = "(";
    private static final String SPACE = " ";
    private static final String CLOSE_PAR = ")";
    private static final String INT_TYPE = "INTEGER";
    private static final String COMMA = ",";
    private static final String INT_PK_AUTO = "INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String CREATE_TABLE = "CREATE TABLE";
    private static final String WHERE_EQUALS = "=?";
    private static final String WHERE_ID_EQUALS = "_id=";

    /*
    String for Creating the Habits Table
     */
    private static final String SQL_CREATE_HABITS_TABLE =
            CREATE_TABLE + SPACE + HabitsContract.HabitsTable.TABLE_HABITS + SPACE + OPEN_PAR +
                    HabitsContract.HabitsTable._ID + SPACE + INT_PK_AUTO + COMMA +
                    HabitsContract.HabitsTable.HABIT + SPACE + TEXT_TYPE + CLOSE_PAR;
    /*
    String for Creating the Rank Table
     */
    private static final String SQL_CREATE_RANK_TABLE =
            CREATE_TABLE + SPACE + HabitsContract.RankTable.TABLE_RANK + SPACE + OPEN_PAR +
                    HabitsContract.RankTable._ID + SPACE + INT_PK_AUTO + COMMA +
                    HabitsContract.RankTable.RANK + SPACE + INT_TYPE + CLOSE_PAR;
    /*
    String for Creating the Occurrence Table
     */
    private static final String SQL_CREATE_OCCURRENCE_TABLE =
            CREATE_TABLE + SPACE + HabitsContract.OccurrenceTable.TABLE_OCCURRENCE + SPACE + OPEN_PAR +
                    HabitsContract.OccurrenceTable._ID + SPACE + INT_PK_AUTO + COMMA +
                    HabitsContract.OccurrenceTable.DATE_TIME + SPACE + TEXT_TYPE + COMMA +
                    HabitsContract.OccurrenceTable.DURATION + SPACE + INT_TYPE + COMMA +
                    HabitsContract.OccurrenceTable.LOCATION + SPACE + TEXT_TYPE + COMMA +
                    HabitsContract.OccurrenceTable.COMMENTS + SPACE + TEXT_TYPE + CLOSE_PAR;
    /*
    String for Creating the Habit Occurrence Table
    */
    private static final String SQL_CREATE_HABIT_OCCURRENCE_TABLE =
            CREATE_TABLE + SPACE + HabitsContract.HabitOccurrenceTable.TABLE_HABIT_OCCURRENCE + SPACE + OPEN_PAR +
                    HabitsContract.HabitOccurrenceTable._ID + SPACE + INT_PK_AUTO + COMMA +
                    HabitsContract.HabitOccurrenceTable.HABIT_OCCUR_KEY + SPACE + INT_TYPE + COMMA +
                    HabitsContract.HabitOccurrenceTable.OCCURRENCE_KEY + SPACE + INT_TYPE + CLOSE_PAR;
    /*
    String for Creating the Habit Rank Table
   */
    private static final String SQL_CREATE_HABIT_RANK_TABLE =
            CREATE_TABLE + SPACE + HabitsContract.HabitRankTable.TABLE_HABIT_RANK + SPACE + OPEN_PAR +
                    HabitsContract.HabitRankTable._ID + SPACE + INT_PK_AUTO + COMMA +
                    HabitsContract.HabitRankTable.HABIT_RANK_KEY + SPACE + INT_TYPE + COMMA +
                    HabitsContract.HabitRankTable.RANK_KEY + SPACE + INT_TYPE + CLOSE_PAR;


    public HabitsDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //onCreate will be called if no database exists and create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_HABITS_TABLE);
        db.execSQL(SQL_CREATE_OCCURRENCE_TABLE);
        db.execSQL(SQL_CREATE_RANK_TABLE);
        db.execSQL(SQL_CREATE_HABIT_OCCURRENCE_TABLE);
        db.execSQL(SQL_CREATE_HABIT_RANK_TABLE);
    }

    //Deleting the database if onUpgrade is called
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteHabitsDataBase(context);
    }

    //Deleting the database if onDowngrade is called
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        deleteHabitsDataBase(context);
    }

    //Method to insert a row into the database for a new habit occurrence
    public void putOccurrence(String date_time, int duration, String location, String comments) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating a new ContentValues Object and putting values where column names are the keys
        ContentValues cv = new ContentValues();
        cv.put(HabitsContract.OccurrenceTable.DATE_TIME, date_time);
        cv.put(HabitsContract.OccurrenceTable.DURATION, duration);
        cv.put(HabitsContract.OccurrenceTable.LOCATION, location);
        cv.put(HabitsContract.OccurrenceTable.COMMENTS, comments);

        String isNullable = HabitsContract.OccurrenceTable.LOCATION;
        String table = HabitsContract.OccurrenceTable.TABLE_OCCURRENCE;
        // Insert the new row
        db.insert(table, isNullable, cv);
        db.close();
    }

    //Method allowing habit occurrence details to be edited.
    public void updateOccurrence(long occurrenceId, String newDateTime, int newDuration, String newLocation, String comments) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating a new ContentValues Object with  new values for the habit occurrence.
        ContentValues cv = new ContentValues();
        cv.put(HabitsContract.OccurrenceTable.DATE_TIME, newDateTime);
        cv.put(HabitsContract.OccurrenceTable.DURATION, newDuration);
        cv.put(HabitsContract.OccurrenceTable.LOCATION, newLocation);
        cv.put(HabitsContract.OccurrenceTable.COMMENTS, comments);

        String table = HabitsContract.OccurrenceTable.TABLE_OCCURRENCE;
        //Updating the occurrence @ row occurrenceId with the inputted data values.
        db.update(table, cv, WHERE_ID_EQUALS + occurrenceId, null);
        db.close();
    }

    //Get occurrences by passing in the occurrence id
    public Cursor getOccurrences(long occurrenceId) {

        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                HabitsContract.OccurrenceTable.DATE_TIME,
                HabitsContract.OccurrenceTable.DURATION,
                HabitsContract.OccurrenceTable.LOCATION,
                HabitsContract.OccurrenceTable.COMMENTS};

        String selection = HabitsContract.OccurrenceTable._ID + WHERE_EQUALS;
        String table = HabitsContract.OccurrenceTable.TABLE_OCCURRENCE;
        String[] selectionArgs = {String.valueOf(occurrenceId)};

        Cursor cursor = db.query(table, projection, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            return cursor;
        } else {
            return null;
        }
    }

    //Method to delete database
    private boolean deleteHabitsDataBase(Context context) {
        return context.deleteDatabase(DATABASE_NAME);
    }

    //Method to delete all rows in all tables
    public void deleteRowsAllTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(HabitsContract.HabitsTable.TABLE_HABITS, null, null);
        db.delete(HabitsContract.RankTable.TABLE_RANK, null, null);
        db.delete(HabitsContract.OccurrenceTable.TABLE_OCCURRENCE, null, null);
        db.delete(HabitsContract.HabitRankTable.TABLE_HABIT_RANK, null, null);
        db.delete(HabitsContract.HabitOccurrenceTable.TABLE_HABIT_OCCURRENCE, null, null);
        db.close();
    }
}