package com.thowo.testandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.FileUtils;

import com.thowo.jmandroidframework.JMAnFunctions;
import com.thowo.jmandroidframework.component.JMAnActivity;
import com.thowo.jmandroidframework.component.JMAnAsyncLoaderDefault;
import com.thowo.jmandroidframework.component.JMAnUIMessenger;
import com.thowo.jmjavaframework.JMFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainActivity extends JMAnActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_main);

    }

    private void init(){
        JMFunctions.setUIListener(new JMAnUIMessenger());
        JMFunctions.setAsyncListener(new JMAnAsyncLoaderDefault(this));
        File languageExcelFile=JMAnFunctions.copyResourceToFileDir(R.raw.jmlanguagepack,"jmlanguagepack.xlsx",false);
        JMAnFunctions.init(languageExcelFile);
    }
}
