package com.tyd.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class settingActivity extends AppCompatActivity {
    SQLiteDatabase db;
    my_db_helper mydq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button bt_xgmm=findViewById(R.id.xg_mm);
        Button bt_xgyhm=findViewById(R.id.xg_yhm);

        mydq=new my_db_helper(this);
        bt_xgmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog;
                //设置对话框属性
                final EditText editText_1=new EditText(settingActivity.this);//通过getActivity（）得到context来实现*已了解*
                editText_1.setText("");
//                editText.setEnabled(false);
                AlertDialog.Builder builder=new AlertDialog.Builder(settingActivity.this)
                        .setTitle("请输入旧密码")
                        .setView(editText_1)
                        .setIcon(R.drawable.me)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                AlertDialog dialog_2;
                                //设置对话框属性
                                final EditText editText_2=new EditText(settingActivity.this);
                                AlertDialog.Builder builder=new AlertDialog.Builder(settingActivity.this)
                                        .setTitle("请输入新密码")
                                        .setView(editText_2)
                                        .setIcon(R.drawable.me)
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                db = mydq.getWritableDatabase();//定义出错
                                                String  u_mm=editText_2.getText().toString();
                                                String  u_m=editText_1.getText().toString();
                                                ContentValues values = new ContentValues();
                                                values.put("u_pwd",u_mm);
                                                db.update("user_info", values, "u_pwd=?",new String[]{u_m});
                                                db.close();

//                         点确定按钮发生的事件
                                                dialog.dismiss();
//                                Toast.makeText(read_Activity.this,"你已经添加笔记"+editText.getText().toString(),Toast.LENGTH_LONG).show();
                                                Toast.makeText(settingActivity.this,"修改成功"+"\n新密码："+u_mm,Toast.LENGTH_LONG).show();
                                            }
                                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int arg1) {
                                                // 点取消按钮发生的事件
                                                dialog.dismiss();

                                            }
                                        });
                                builder.setCancelable(true);
                                dialog_2=builder.create();
                                dialog_2.setCanceledOnTouchOutside(true);
                                dialog_2.show();
//                                db = mydq.getWritableDatabase();//定义出错
//                                String  u_bj=editText.getText().toString();
//                                ContentValues values = new ContentValues();
//                                values.put("u_bj_content",u_bj);
//                                db.insert("user_sc", null, values);
//                                db.close();
////                         点确定按钮发生的事件
                                dialog.dismiss();
//
                            }
                        }).setNegativeButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                // 点取消按钮发生的事件
                                dialog.dismiss();

                            }
                        });
                builder.setCancelable(true);
                dialog=builder.create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();

            }
        });
        bt_xgyhm.setOnClickListener(view -> {

            AlertDialog dialog;
            //设置对话框属性
            final EditText editText_1=new EditText(settingActivity.this);//通过getActivity（）得到context来实现*已了解*
            editText_1.setText("");
//                editText.setEnabled(false);
            AlertDialog.Builder builder=new AlertDialog.Builder(settingActivity.this)
                    .setTitle("请输入原用户名")
                    .setView(editText_1)
                    .setIcon(R.drawable.me)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int arg1) {
                            AlertDialog dialog_2;
                            //设置对话框属性
                            final EditText editText_2=new EditText(settingActivity.this);
                            AlertDialog.Builder builder=new AlertDialog.Builder(settingActivity.this)
                                    .setTitle("请输入新用户名")
                                    .setView(editText_2)
                                    .setIcon(R.drawable.me)
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int arg1) {
                                            db = mydq.getWritableDatabase();//定义出错
                                            String  u_mm=editText_2.getText().toString();
                                            String  u_m=editText_1.getText().toString();
                                            ContentValues values = new ContentValues();
                                            values.put("u_name",u_mm);
                                            db.update("user_info", values, "u_name=?",new String[]{u_m});
                                            db.close();

//                         点确定按钮发生的事件
                                            dialog.dismiss();
//                                Toast.makeText(read_Activity.this,"你已经添加笔记"+editText.getText().toString(),Toast.LENGTH_LONG).show();
                                            Toast.makeText(settingActivity.this,"修改成功"+"\n新用户名："+u_mm,Toast.LENGTH_LONG).show();
                                        }
                                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int arg1) {
                                            // 点取消按钮发生的事件
                                            dialog.dismiss();

                                        }
                                    });
                            builder.setCancelable(true);
                            dialog_2=builder.create();
                            dialog_2.setCanceledOnTouchOutside(true);
                            dialog_2.show();
//                                db = mydq.getWritableDatabase();//定义出错
//                                String  u_bj=editText.getText().toString();
//                                ContentValues values = new ContentValues();
//                                values.put("u_bj_content",u_bj);
//                                db.insert("user_sc", null, values);
//                                db.close();
////                         点确定按钮发生的事件
                            dialog.dismiss();
                        }
                    }).setNegativeButton("", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int arg1) {
                            // 点取消按钮发生的事件
                            dialog.dismiss();

                        }
                    });
            builder.setCancelable(true);
            dialog=builder.create();
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();


        });



    }

}
