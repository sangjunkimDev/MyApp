package com.project.sangjun.myapp.view.progressAndSeekBar;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressAndSeekBarActivity  extends BaseActivity {

    @BindView(R.id.pb_horizon)
    ProgressBar pb_horizon;

    @BindView(R.id.pb_horizon_2)
    ProgressBar pb_horizon_2;

    @BindView(R.id.sb_1)
    SeekBar sb_1;

    @BindView(R.id.bt_start)
    Button bt_start;

    @BindView(R.id.tv_seekbar_value)
    TextView tv_seekbar_value;

    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_seek_bar);
        ButterKnife.bind(this);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        sb_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekbar_value.setText("현재 값 : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(context, "seekbar start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(context, "seekbar end", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.bt_start)
    void startThread(View v) {
        new ProgressThread().start();
    }

    class ProgressThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i <= 100; i++) {
                    sleep(300);
                    pb_horizon.setProgress(i);
                    pb_horizon_2.setProgress(i);
                    if (pb_horizon_2.getProgress() < 100) {
                        pb_horizon_2.setSecondaryProgress(i*2);
                    }
                }
                sleep(500);
                pb_horizon.setProgress(0);
                pb_horizon_2.setProgress(0);
                pb_horizon_2.setSecondaryProgress(0);
                for (int i = 0; i < 10; i++) {
                    sleep(300);
                    pb_horizon.incrementProgressBy(10);
                    pb_horizon_2.incrementProgressBy(10);
                    if (pb_horizon_2.getProgress() < 100) {
                        pb_horizon_2.incrementSecondaryProgressBy(12);
                    }
                }



            } catch (InterruptedException e) {

            }
        }
    }

}
