package com.dimitriskatsikas.mathtools.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContentDB extends SQLiteOpenHelper{

    /** Database name */
    private static String DBNAME = "ContentDataBase";

    /** Version number of the database */
    private static int VERSION = 1;

    /** Field 1 of the table cont_master, which is the primary key */
    public static final String KEY_ROW_ID = "_id";

    /** Field 2 of the table cont_master, stores the customer code */
    public static final String KEY_DATA = "cont_data";

    /** A constant, stores the the table name */
    private static final String DATABASE_TABLE = "cont_master";

    /** An instance variable for SQLiteDatabase */
    private SQLiteDatabase mDB;

    /** Constructor */
    public ContentDB(Context context) {
        super(context, DBNAME, null, VERSION);
        this.mDB = getWritableDatabase();
    }

    /** This is a callback method, invoked when the method
     * getReadableDatabase() / getWritableDatabase() is called
     * provided the database does not exists
     * */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =     "create table "+ DATABASE_TABLE + " ( "
                + KEY_ROW_ID + " integer primary key autoincrement , "
                + KEY_DATA + "  text  ) " ;

        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( '<< Combinatorics >>')";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( '5 Combinatorics Formulas')";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( '<< Geometric Shapes >>' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( '<< 2D Shapes >>' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Circle')";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Convert Radians / Degrees')";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Circular Sector' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Ellipse' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Triangle' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Square' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Rectangle' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Parallelogram' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Trapezoid' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( '<< 3D Shapes >>' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Sphere' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Torus' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Cylinder' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Cone' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Cube' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Parallelepiped' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Triangular Pyramid' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Square Pyramid' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Triangular Prism' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Pentagonal Prism' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Regular Octahedron' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Regular Dodecahedron' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Regular Icosahedron' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( '<< Numbers >>' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Mathematical Constants' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Prime Numbers' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Fibonacci Numbers' )";
        db.execSQL(sql);

        sql = "insert into " + DATABASE_TABLE + " ( " + KEY_DATA + " ) "
                + " values ( 'Convert Radians / Degrees' )";
        db.execSQL(sql);


    }

    /** Returns all the customers in the table */
    public Cursor getAllContent(){
        return mDB.query(DATABASE_TABLE, new String[] { KEY_ROW_ID,  KEY_DATA  } ,
                null, null, null, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
