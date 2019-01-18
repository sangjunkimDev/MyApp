package com.project.sangjun.myapp.view.finger_print;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ajalt.reprint.core.AuthenticationFailureReason;
import com.github.ajalt.reprint.core.AuthenticationListener;
import com.github.ajalt.reprint.core.Reprint;
import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FingerPrintActivity_3 extends BaseActivity {

    @BindView(R.id.hardware_present)
    TextView hardwarePresent;

    @BindView(R.id.fingerprints_registered)
    TextView fingerprintsRegistered;

    @BindView(R.id.iv_finger)
    ImageView iv_fingerPrint;

    @BindView(R.id.result)
    TextView result;


    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);
        ButterKnife.bind(this);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        boolean isHardwarePresent = Reprint.isHardwarePresent();
        boolean hasFingerprintRegistered = Reprint.hasFingerprintRegistered();
        hardwarePresent.setText(String.valueOf(isHardwarePresent));
        fingerprintsRegistered.setText(String.valueOf(hasFingerprintRegistered));

        running = false;
    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        if (running) {
            cancel();
        } else {
            start();
        }
    }

    private void start() {
        running = true;
        result.setText("Listening");
        startTraditional();
    }

    private void cancel() {
        result.setText("Cancelled");
        running = false;
        Reprint.cancelAuthentication();
    }


    private void startTraditional() {
        Reprint.authenticate(new AuthenticationListener() {
            @Override
            public void onSuccess(int moduleTag) {
                showSuccess();
            }

            @Override
            public void onFailure(AuthenticationFailureReason failureReason, boolean fatal,
                                  CharSequence errorMessage, int moduleTag, int errorCode) {
                showError(failureReason, fatal, errorMessage, errorCode);
            }
        });
    }

    private void showSuccess() {
        result.setText("Success");
    }

    private void showError(AuthenticationFailureReason failureReason, boolean fatal,
                           CharSequence errorMessage, int errorCode) {
        result.setText(errorMessage);
    }
}
