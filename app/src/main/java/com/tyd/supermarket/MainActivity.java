package com.tyd.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText u_name;
    EditText u_pwd;
    Button denglu;
    Button zc;
    public SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u_name=findViewById(R.id.u_name);
        u_pwd=findViewById(R.id.u_pwd);

        denglu=findViewById(R.id.denglu);
        zc=findViewById(R.id.ljzc);
         my_db_helper mydb = new my_db_helper(this);


        zc.setOnClickListener(view -> {
            finish();
            Intent intent = new Intent(MainActivity.this,siginActivity.class);
            startActivity(intent);
        });

        denglu.setOnClickListener(view -> {
             db=mydb.getReadableDatabase();
            String uname=u_name.getText().toString();
            String upwd=u_pwd.getText().toString();
            String sql="select * from user_info where u_name=? and u_pwd=?";
            Cursor cursor=db.rawQuery(sql, new String[]{uname,upwd});
            if(cursor.moveToFirst()==true){
                cursor.close();
                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("zdf",1);
                intent.putExtra("yhm",uname);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(MainActivity.this,"登录失败账号or密码错误",Toast.LENGTH_SHORT).show();

            }


        });
    }



}
