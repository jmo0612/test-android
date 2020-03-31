package com.thowo.testandroid;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.thowo.jmandroidframework.JMAnFunctions;
import com.thowo.jmandroidframework.component.JMAnActivity;
import com.thowo.jmandroidframework.component.JMAnAsyncLoaderDefault;
import com.thowo.jmandroidframework.component.JMAnButton;
import com.thowo.jmandroidframework.component.JMAnUIMessenger;
import com.thowo.jmjavaframework.JMFunctions;
import com.thowo.jmjavaframework.db.JMConnection;


import java.io.File;

public class MainActivity extends JMAnActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        setContentView(R.layout.activity_main);
        JMAnButton b=(JMAnButton) findViewById(R.id.btnTest);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.test();
            }
        });
    }

    private void init(){
        JMFunctions.setUIListener(new JMAnUIMessenger());
        JMFunctions.setAsyncListener(new JMAnAsyncLoaderDefault(this));
        File languageExcelFile=JMAnFunctions.copyResourceToFileDir(R.raw.jmlanguagepack,"jmlanguagepack.xls",false);
        JMAnFunctions.init(languageExcelFile);
    }

    private void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                JMConnection con=GitIgnoreDBConnection.mySQLConnection();
                JMFunctions.trace(con.queryMySQL("select * from user",true).getString(1));
            }
        }).start();
    }
}
