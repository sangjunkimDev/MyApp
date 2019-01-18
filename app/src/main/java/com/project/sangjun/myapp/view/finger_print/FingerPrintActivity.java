package com.project.sangjun.myapp.view.finger_print;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;


import butterknife.BindView;
import butterknife.ButterKnife;

public class FingerPrintActivity extends BaseActivity {

    @BindView(R.id.iv_finger)
    ImageView iv_fingerPrint;


    private Context mContext;
    private FingerprintManagerCompat fingerprintManager;
    private KeyguardManager keyguardManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);
        ButterKnife.bind(this);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        mContext = this;

        keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        fingerprintManager = FingerprintManagerCompat.from(mContext);



        if (!keyguardManager.isKeyguardSecure()) {
            Toast.makeText(this,
                    "Lock screen security not enabled in Settings",
                    Toast.LENGTH_LONG).show();

            return;
        }

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,
                    "Fingerprint authentication permission not enabled",
                    Toast.LENGTH_LONG).show();

            return;
        }


        if (!fingerprintManager.hasEnrolledFingerprints()) {
            // This happens when no fingerprints are registered.
            Toast.makeText(this,
                    "Register at least one fingerprint in Settings",
                    Toast.LENGTH_LONG).show();
            return;

        }




    }
}
