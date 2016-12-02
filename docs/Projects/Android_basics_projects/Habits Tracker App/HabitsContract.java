package com.waters89gmail.dave.habittracker;

import android.provider.BaseColumns;

/**
 * Created by watersd on 8/5/2016.
 */
public final class HabitsContract {

    // Logcat tag
    private static final String LOG = "MYLOG";

    public HabitsContract() {}

    /* Inner class that defines the HabitsTable table contents */
    public static abstract class HabitsTable implements BaseColumns {

        //Habits table - name
        public static final String TABLE_HABITS = "habits_table";

        //Habits table - column names
        public static final String _ID = "_id";
        public static final String HABIT = "habit_name";
    }

    /* Inner class that defines the RankTable table contents */
    public static abstract class RankTable implements BaseColumns {

        //Rank table - table name
        public static final String TABLE_RANK = "rank_table";

        // Rank table - column names
        public static final String _ID = "_id";
        public static final String RANK = "rank_name";
    }

    /* Inner class that defines the OccurrenceTable table contents */
    public static abstract class OccurrenceTable implements BaseColumns {

        // Occurrence table - table name
        public static final String TABLE_OCCURRENCE = "occurrence_table";

        // Occurrence table - column names
        public static final String _ID = "_id";
        public static final String DATE_TIME = "date_time";
        public static final String DURATION = "duration";
        public static final String LOCATION = "location";
        public static final String COMMENTS = "comments";
    }

    /* Inner class that defines the HabitOccurrenceTable table contents
    * This class defines the table data, this table is used to establish a relationship between the Habit and the occurrence.*/
    public static abstract class HabitOccurrenceTable implements BaseColumns {

        // Habit-Occurrence table - table name
        public static final String TABLE_HABIT_OCCURRENCE = "habit_occurrence_table";

        // Habit-Occurrence table - column names
        public static final String _ID = "_id";
        public static final String HABIT_OCCUR_KEY = "habit_occur_key";
        public static final String OCCURRENCE_KEY = "occurrence_key";
    }

    /* Inner class that defines the HabitRankTable table contents
    *  This class defines the table data, this table is used to establish a relationship between the Habit and a rank.*/
    public static abstract class HabitRankTable implements BaseColumns {

        // Habit-Rank table - table name
        public static final String TABLE_HABIT_RANK = "habit_rank_table";

        // Tags table - column names
        public static final String _ID = "_id";
        public static final String HABIT_RANK_KEY = "habit_rank_key";
        public static final String RANK_KEY = "rank_key";
    }
}