package com.zhiyuan.libai;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.show.api.ShowApiRequest;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    protected Handler mHandler =  new Handler();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt = (TextView) this.findViewById(R.id.tv);
        Button myBtn = (Button) this.findViewById(R.id.bt);
        myBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(){
                    //在新线程中发送网络请求
                    public void run() {
                        String appid="42339";//要替换成自己的
                        String secret="e4e347d6b8824fab81b2ca8ced8c61fe";//要替换成自己的
                        final String res=new ShowApiRequest( "http://route.showapi.com/950-1", appid, secret)
                                .addTextPara("num", "5")
                                .addTextPara("type", "1")
                                .addTextPara("yayuntype", "1")
                                .addTextPara("key", "士大夫")
                                .post();

                        System.out.println(res);
                        //把返回内容通过handler对象更新到界面
                        mHandler.post(new Thread(){
                            public void run() {
                                txt.setText(res+"  "+new Date());
                            }
                        });
                    }
                }.start();


            }
        });
    }
}
