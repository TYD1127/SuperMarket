package com.tyd.supermarket.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.tyd.supermarket.R;


/**
 * 2021_4_2——完成
 */
public class meFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.me,container,false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button u_name=getActivity().findViewById(R.id.bt_dl);
        final Intent intent=getActivity().getIntent();
        final String name= intent.getStringExtra("yhm");
        u_name.setText("用户"+name);
        Button b_tc = getActivity().findViewById(R.id.tcyy);//出错
        b_tc.setOnClickListener(view -> getActivity().finish());

        Button bsz = getActivity().findViewById(R.id.bt_sz);//出错
        bsz.setOnClickListener(view -> {
            Intent int_sz=new Intent();
            int_sz.setAction("android.intent.action.SZ");
            startActivity(int_sz);
        });


        Button bt_gy = getActivity().findViewById(R.id.bt_gy);//出错
        bt_gy.setOnClickListener(view -> {
            AlertDialog dialog;
            //设置对话框属性
            final EditText editText=new EditText(getContext());//通过getActivity（）得到context来实现*已了解*
            editText.setText("\n\t\t\t联系作者:\n\n\t\t 周琦发");
            editText.setEnabled(false);
            AlertDialog.Builder builder=new AlertDialog.Builder(getContext())
                    .setTitle("关于超市管理系统")
                    .setView(editText)
                    .setIcon(R.drawable.me)
                    .setPositiveButton("返回", (dialog1, arg1) -> {
//                         点确定按钮发生的事件
                        dialog1.dismiss();
//
                    }).setNegativeButton("", (dialog12, arg1) -> {
                        // 点取消按钮发生的事件
                        dialog12.dismiss();
                    });
            builder.setCancelable(true);
            dialog=builder.create();
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();

        });

    }

    private void tz(Fragment fragment1, Fragment fragment2) {
        // 获取 FragmentTransaction  对象
        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();
        //如果fragment2没有被添加过，就添加它替换当前的fragment1
        if (!fragment2.isAdded()) {
            transaction.add(R.id.fa,fragment2)
                    //加入返回栈，这样你点击返回键的时候就会回退到fragment1了
                    .addToBackStack(null)
                    // 提交事务
                    .commitAllowingStateLoss();

        } else { //如果已经添加过了的话就隐藏fragment1，显示fragment2
            transaction
                    // 隐藏fragment1，即当前碎片
                    .hide(fragment1)
                    // 显示已经添加过的碎片，即fragment2
                    .show(fragment2)
                    // 加入返回栈
                    .addToBackStack(null)
                    // 提交事务
                    .commitAllowingStateLoss();
        }
    }

}


