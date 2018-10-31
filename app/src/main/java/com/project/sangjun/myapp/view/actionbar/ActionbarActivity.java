package com.project.sangjun.myapp.view.actionbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.sangjun.myapp.R;
import com.project.sangjun.myapp.util.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionbarActivity extends BaseActivity {

    @BindView(R.id.tv_value)
    TextView tv_value;

    SearchView searchView;

    @BindView(R.id.iv_context_menu)
    ImageView imageView;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
//            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setIcon(R.drawable.ic_launcher_background);
        }

        //View를 오래누르면 나오는 메뉴 설정
        imageView = findViewById(R.id.iv_context_menu);
        registerForContextMenu(imageView);

    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //자바 코드로 메뉴 생성
//        MenuItem item1 = menu.add(0,0,0,"메뉴1");
//        MenuItem item2 = menu.add(0,1,0,"메뉴2");


        //리소스로 매뉴 생성
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_1, menu);

        //오버플로우 메뉴의 아이콘 출력 설정
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }

        // ActionView 설정 (SearchView)
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                tv_value.setText(s);
                return false;
            }
        });

        //actionLayout 설정
        MenuItem menuItem1 = menu.findItem(R.id.menu_5);
        menuItem1.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(context, item.getTitle() + "_expand", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(context, item.getTitle() + "_collapse", Toast.LENGTH_SHORT).show();

                CheckBox checkBox1 = findViewById(R.id.cb_1);
                CheckBox checkBox2 = findViewById(R.id.cb_2);
                Toast.makeText(context, checkBox1.isChecked()+"_1", Toast.LENGTH_SHORT).show();
                Toast.makeText(context, checkBox2.isChecked()+"_2", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Home As UP Click (뒤로가기)
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(context, "Home As Up Click", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);
        }

        //자바로 만든 클릭 이벤트 처리
//        else if (item.getItemId() == 0) {
//            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else if (item.getItemId() == 1) {
//            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//            return true;
//        }

        //리소스를 이용한 클릭 이벤트 처리
        else if (item.getItemId() == R.id.menu_1) {
            Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.menu_2) {
            Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.menu_3) {
            Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.menu_3_1) {
            Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.menu_3_2) {
            Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.menu_5) {
            Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            return false;
        }


        return super.onOptionsItemSelected(item);
    }

    //뷰를 오래누르면 보이는 메뉴 설정
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"메뉴1");
        menu.add(0,1,0,"메뉴2");
        menu.add(0,2,0,"메뉴3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            Toast.makeText(context, "메뉴 1", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 1) {
            Toast.makeText(context, "메뉴 2", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 2) {
            Toast.makeText(context, "메뉴 3", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
