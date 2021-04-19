package com.tyd.supermarket.fragment;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tyd.supermarket.R;
import com.tyd.supermarket.dxl;
import com.tyd.supermarket.my_db_helper;
import com.tyd.supermarket.myadapter;

import java.util.ArrayList;
import java.util.List;

public class bdFragment extends Fragment {
    private EditText et_n,et_p,et_nu;
    private ListView listView;
    private String name,price,number;
    private my_db_helper mydb;
    private SQLiteDatabase db;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.bd, container, false);
        et_n = view.findViewById(R.id.et_name);
        et_p = view.findViewById(R.id.et_price);
        et_nu = view. findViewById(R.id.et_number);
        listView = view.findViewById(R.id.sclistView);
        Button add = view.findViewById(R.id.add);
        Button query = view.findViewById(R.id.query);
        Button update = view.findViewById(R.id.update);
        Button delete = view.findViewById(R.id.delete);
        add.setOnClickListener(this::onClick);
        query.setOnClickListener(this::onClick);
        update.setOnClickListener(this::onClick);
        delete.setOnClickListener(this::onClick);
        mydb = new my_db_helper(getContext());
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:
                db = mydb.getWritableDatabase();
                name = et_n.getText().toString();
                price = et_p.getText().toString();
                number = et_nu.getText().toString();
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("price", price);
                values.put("number", number);
                db.insert("cart", null, values);
                db.close();
                Toast.makeText(getActivity(), "添加商品成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.query:
                List<dxl> list = new ArrayList();
                db = mydb.getWritableDatabase();
                Cursor cursor = db.query("cart", null, null, null, null,
                        null, null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getActivity(), "商品不存在", Toast.LENGTH_SHORT).show();
                } else {
                    while (cursor.moveToNext()) {
                        dxl dy = new dxl();
                        int nameIndex = cursor.getColumnIndex("name");
                        int priceIndex = cursor.getColumnIndex("price");
                        int numberIndex = cursor.getColumnIndex("number");
                        String name = cursor.getString(nameIndex);
                        String price = cursor.getString(priceIndex);
                        String number = cursor.getString(numberIndex);
                        dy.setName(name);
                        dy.setPrice(price);
                        dy.setNumber(number);
                        list.add(dy);
                    }
                    myadapter adapter = new myadapter(getActivity(),list);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                cursor.close();
                db.close();
                break;
            case  R.id.update:
                name = et_n.getText().toString();
                price = et_p.getText().toString();
                number = et_n.getText().toString();
                db = mydb.getWritableDatabase();
                values = new ContentValues();
                values.put("number",number);
                values.put("price",price);
                db.update("cart", values, "name=?",
                        new String[]{name});
                db.close();
                Toast.makeText(getActivity(), "商品信息已修改", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                db = mydb.getWritableDatabase();
                db.delete("cart", null, null);
                List<dxl> list2 = new ArrayList();
                myadapter adapter = new myadapter(getActivity(),list2);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                db.close();
                Toast.makeText(getActivity(), "已删除商品", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
