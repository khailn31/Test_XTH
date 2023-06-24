package fpoly.khailnph29864.test_xth;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.DbVH> {
    private ArrayList<Car> list;

    private Context context;
    private DAO dao;

    public Adapter(final ArrayList<Car> list, final Context context) {
        this.list = list;
        this.context = context;
        dao = new DAO(context);

    }

    @NonNull
    @Override
    public DbVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new DbVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DbVH holder, @SuppressLint("RecyclerView") int position) {
        Car car = list.get(position);

     holder.tv_ten.setText("Tên: "+ car.getTen());
     holder.tv_hangSX.setText("Hãng sản xuất: "+car.getHangSX());
     holder.tv_namSX.setText("Năm sản xuất: "+car.getNamSX());
     holder.tv_gia.setText("Giá: "+car.getGia());
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDele(list.get(position).getId());
            }
        });

    }


    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    @Override
    public long getItemId(final int position) {
        return list.get(position).getId();
    }

    class DbVH extends RecyclerView.ViewHolder {
        private TextView tv_ten, tv_hangSX, tv_namSX, tv_gia;
        private ImageView btnDel;

        public DbVH(@NonNull View itemView) {
            super(itemView);
            tv_ten = itemView.findViewById(R.id.tv_ten);
            tv_hangSX = itemView.findViewById(R.id.tv_hangSX);
            tv_namSX = itemView.findViewById(R.id.tv_namSX);
            tv_gia = itemView.findViewById(R.id.tv_gia);
            btnDel=itemView.findViewById(R.id.btn_del);
        }
    }

    public void setData(ArrayList<Car> lst) {
        this.list = lst;
        notifyDataSetChanged();
    }



    private void showDele(int id) {
        AlertDialog.Builder dialogDL = new AlertDialog.Builder(context);
        dialogDL.setMessage("ban co muon xoa khong");
        dialogDL.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialogDL.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dao.delete(id) > 0) {
                    Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    list = dao.getAllData();
                    setData(list);
                } else {
                    Toast.makeText(context, "Xoa k thanh cong", Toast.LENGTH_SHORT).show();

                }
                dialog.dismiss();

            }
        });
        dialogDL.show();
    }
}
