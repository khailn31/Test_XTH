package fpoly.khailnph29864.test_xth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Test_XTH";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String Table_car = "CREATE TABLE " +
            "tbl_car(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "ten TEXT NOT NULL," +
            "hangSX TEXT NOT NULL," +
            "namSX INTEGER NOT NULL," +
            "gia DOUBLE NOT NULL)";
    public static final String insert_car1 = "Insert into tbl_car(ten,hangSX,namSX,gia) values" +
            "('VinFast VF 5 Plus','VINFAST','2020','710')";
    public static final String insert_car2 = "Insert into tbl_car(ten,hangSX,namSX,gia) values" +
            "('Mercedes-Benz GLE 450 4MATIC','Mercedes','2022','910')";
    public static final String insert_car3 = "Insert into tbl_car(ten,hangSX,namSX,gia) values" +
            "('Mercedes Maybach S-Class','Mercedes','2019','1110')";
    public static final String insert_car4 = "Insert into tbl_car(ten,hangSX,namSX,gia) values" +
            "('Mazda MAZDA3 Sedan','Mazda','2021','880')";
    public static final String insert_car5 = "Insert into tbl_car(ten,hangSX,namSX,gia) values" +
            "('Mazda CX-5 Sport Utility','Mazda','2020','980')";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Table_car);
        sqLiteDatabase.execSQL(insert_car1);
        sqLiteDatabase.execSQL(insert_car2);
        sqLiteDatabase.execSQL(insert_car3);
        sqLiteDatabase.execSQL(insert_car4);
        sqLiteDatabase.execSQL(insert_car5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tbl_car");
        onCreate(sqLiteDatabase);
    }
}
