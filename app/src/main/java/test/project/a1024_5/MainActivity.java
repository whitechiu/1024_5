package test.project.a1024_5;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static test.project.a1024_5.R.id.radioButton;
import static test.project.a1024_5.R.id.radioButton2;

public class MainActivity extends AppCompatActivity {

    CheckBox chk;
    //RadioButton rb;
    RadioGroup rg;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chk = (CheckBox) findViewById(R.id.checkBox);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TD","chk:"+isChecked);
            }
        });

        /*rb = (RadioButton) findViewById(R.id.radioButton);
        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Log.d("TD", "No.21");
            }
        });*/

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == radioButton)
                {
                    Log.d("TD", "No.21");
                }
                else if(checkedId == R.id.radioButton2 )
                {
                    Log.d("TP", "No.9");
                }
            }
        });
    }
    public void click1(View v)
    {
        pb.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();
    }
}
