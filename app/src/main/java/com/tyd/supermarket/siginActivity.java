package com.tyd.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class siginActivity extends AppCompatActivity {

    EditText u_name_z;
    EditText u_id_z;
    EditText u_pwd_z;
    String u_name;
    String u_id;
    String u_pwd;
    Button ljzc;
    Button fh;
    public my_db_helper mydb;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        mydb = new my_db_helper(this);
        ljzc = findViewById(R.id.qr_zc);
        fh = findViewById(R.id.fh_dl);

        u_name_z = findViewById(R.id.et_u_name);
        u_id_z = findViewById(R.id.et_u_id);
        u_pwd_z = findViewById(R.id.et_u_pwd);

        u_name = u_name_z.getText().toString();
        u_id = u_id_z.getText().toString();
        u_pwd = u_pwd_z.getText().toString();
        //立即注册
        ljzc.setOnClickListener(view -> {
            db = mydb.getWritableDatabase();
            u_name = u_name_z.getText().toString();//用户名
            u_id = u_id_z.getText().toString();//账号
            u_pwd = u_pwd_z.getText().toString();//密码
            ContentValues values = new ContentValues();
            values.put("u_id", u_id);
            values.put("u_name", u_name);
            values.put("u_pwd", u_pwd);
            long info = db.insert("user_info", null, values);
            db.close();
            Toast.makeText(siginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();


        });
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(siginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}