package ru.startandroid.develop.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean is_started = false;
    private int counter = 0;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = findViewById(R.id.textView);
    }
    public void onClickStart(View view){
        is_started = true;
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(is_started)
                {
                    counter++;
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            tv.setText(String.valueOf(counter));
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        is_started = false;
    }
}