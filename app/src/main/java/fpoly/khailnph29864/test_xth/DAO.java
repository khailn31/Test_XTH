package fpoly.khailnph29864.test_xth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {
    private final SQLiteDatabase sqLiteDatabase;
    private Context context;
    public DAO(Context context) {
        DbHelper helper=new DbHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();
    }
    public ArrayList<Car> getData(String sql, String...SelectAvgs){
        ArrayList<Car> lst=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,SelectAvgs);
        while (cursor.moveToNext()){
          Car car=new Car();
            car.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
            car.setTen(cursor.getString(cursor.getColumnIndex("ten")));
            car.setHangSX(cursor.getString(cursor.getColumnIndex("hangSX")));
            car.setNamSX(Integer.parseInt(cursor.getString(cursor.getColumnIndex("namSX"))));
            car.setGia(Double.parseDouble(cursor.getString(cursor.getColumnIndex("gia"))));
            lst.add(car);
        }
        return lst;
    }
    public ArrayList<Car> getAllData(){
        String sql="SELECT * FROM tbl_car";
        return getData(sql);
    }

    public int insert(Car car) {
        ContentValues values = new ContentValues();
        values.put("ten", car.getTen());
        values.put("namSX",car.getNamSX());
        values.put("hangSX",car.getHangSX());
        values.put("gia",car.getGia());

        return (int) sqLiteDatabase.insert("tbl_car",null,values);
    }

    public int delete(int ID) {
        return sqLiteDatabase.delete("tbl_car", "id = ?", new String[]{String.valueOf(ID)});
    }
}
