package com.project.sangjun.myapp.view.autocompletetextview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoCompleteTextViewActivity extends BaseActivity {

    @BindView(R.id.ac_tv)
    AutoCompleteTextView ac_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletetextview);
        ButterKnife.bind(this);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        List<String> autoData = new ArrayList<>();
        autoData.add("박11");
        autoData.add("박12");
        autoData.add("박13");
        autoData.add("박14");
        autoData.add("박21");
        autoData.add("박22");
        autoData.add("박1가");
        autoData.add("박1나");
        autoData.add("박1다");

        ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, autoData);

        ac_tv.setAdapter(autoAdapter);

    }
}
