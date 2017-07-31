package com.zhiyuan.libai.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.show.api.ShowApiRequest;
import com.zhiyuan.libai.R;
import com.zhiyuan.libai.bean.Result;
import com.zhiyuan.libai.util.JsonUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected Handler mHandler =  new Handler();
    private TextView mTxt;
    private EditText mEditText;
    private String mPoemKey;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxt = (TextView) this.findViewById(R.id.tv);
        mEditText = (EditText) this.findViewById(R.id.et);
        Button myBtn = (Button) this.findViewById(R.id.bt);

        myBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(){
                    //在新线程中发送网络请求
                    public void run() {
                        mPoemKey = mEditText.getText().toString();
                        String appid="42339";//要替换成自己的
                        String secret="e4e347d6b8824fab81b2ca8ced8c61fe";//要替换成自己的
                        final String res=new ShowApiRequest( "http://route.showapi.com/950-1", appid, secret)
                                .addTextPara("num", "5")
                                .addTextPara("type", "1")
                                .addTextPara("yayuntype", "1")
                                .addTextPara("key", mPoemKey)
                                .post();

                        System.out.println(res);
                        //把返回内容通过handler对象更新到界面
                        mHandler.post(new Thread(){
                            public void run() {
                                Result result = JsonUtil.getObject(res, Result.class);
                                List<String> list = result.showapi_res_body.list;
                                mTxt.setText(list.get(0));

                            }
                        });
                    }
                }.start();


            }
        });
    }

    public static void lauch(Context mContext){
        mContext.startActivity(new Intent(mContext,MainActivity.class));
    }
}
