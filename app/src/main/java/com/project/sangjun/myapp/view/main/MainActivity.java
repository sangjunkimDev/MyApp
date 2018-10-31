package com.project.sangjun.myapp.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;
import com.project.sangjun.myapp.view.actionbar.ActionbarActivity;
import com.project.sangjun.myapp.view.autocompletetextview.AutoCompleteTextViewActivity;
import com.project.sangjun.myapp.view.progressAndSeekBar.ProgressAndSeekBarActivity;
import com.project.sangjun.myapp.view.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.sp_list)
    Spinner sp_list;

    @BindView(R.id.bt_submit)
    Button bt_submit;

    private String dataName;

    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final List<String> datas = new ArrayList<>();
        datas.add("WebView 웹뷰");
        datas.add("AutoCompleteTextView");
        datas.add("ProgressAndSeekBar");
        datas.add("ActionBar");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, datas);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_list.setAdapter(arrayAdapter);
        sp_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, datas.get(position), Toast.LENGTH_SHORT).show();
                dataName = datas.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick(R.id.bt_submit)
    void onClick_bt_submit(View v) {
        Toast.makeText(context, dataName, Toast.LENGTH_SHORT).show();

        Class clazz = null;
        switch (dataName) {
            case "WebView 웹뷰" :
                clazz = WebViewActivity.class;
                break;
            case "AutoCompleteTextView" :
                clazz = AutoCompleteTextViewActivity.class;
                break;
            case "ProgressAndSeekBar" :
                clazz = ProgressAndSeekBarActivity.class;
                break;
            case "ActionBar" :
                clazz = ActionbarActivity.class;
                break;
        }

        Intent intent = new Intent(this, clazz);
        startActivity(intent);

    }

}
