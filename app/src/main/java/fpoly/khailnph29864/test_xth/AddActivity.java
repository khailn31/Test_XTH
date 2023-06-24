package fpoly.khailnph29864.test_xth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {
    TextInputEditText ed_ten,ed_hangSX,ed_namSX,ed_gia;
    Button btnSave, btnCancel;
    DAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed_ten=findViewById(R.id.ed_add_name);
        ed_hangSX=findViewById(R.id.ed_add_hangSX);
        ed_namSX=findViewById(R.id.ed_add_namSX);
        ed_gia=findViewById(R.id.ed_add_gia);
        btnSave=findViewById(R.id.btnSave);
        btnCancel=findViewById(R.id.btnCancel);
        dao=new DAO(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ed_ten.getText().toString();
                String hangSX=ed_hangSX.getText().toString();
                String namSX=ed_namSX.getText().toString();
                String gia=ed_gia.getText().toString();
                Car car=new Car();
                try{
                    if(name.equals("")||hangSX.equals("")||namSX.equals("")||gia.equals("")){
                        Toast.makeText(AddActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else if (Integer.parseInt(namSX.toString())<1980||Integer.parseInt(namSX.toString())>2023){
                        ed_namSX.requestFocus();
                        ed_namSX.setError("Năm sản xuất từ 1980 đến 2023");
                    }else if(Double.parseDouble(gia.toString())<=0){
                        ed_gia.requestFocus();
                        ed_gia.setError("Giá phải lớn hơn 0");
                    }else{
                        car.setTen(name);
                        car.setHangSX(hangSX);
                        car.setNamSX(Integer.parseInt(namSX.toString()));
                        car.setGia(Double.parseDouble(gia.toString()));
                        if(dao.insert(car)>0){
                            Toast.makeText(AddActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(AddActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(AddActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){

                }

            }
        });
    }
}