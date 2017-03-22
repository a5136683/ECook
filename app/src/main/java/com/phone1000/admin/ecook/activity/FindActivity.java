package com.phone1000.admin.ecook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phone1000.admin.ecook.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class FindActivity extends AppCompatActivity implements View.OnClickListener{
    @ViewInject(R.id.search_lv)
    private ListView search_lv;
    @ViewInject(R.id.find_cancel)
    private TextView find_cancel;
    @ViewInject(R.id.find_clear)
    private ImageView find_clear;
    @ViewInject(R.id.find_info)
    private AutoCompleteTextView find_info;
    @ViewInject(R.id.search_click)
    private ImageView search_click;
    private View head = null;
    private View foot = null;
    private List<String> list = new ArrayList();
    private ArrayAdapter adapter = null;
    private TextView clear = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        x.view().inject(this);
        initView();
        search_lv.addHeaderView(head);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        search_lv.setAdapter(adapter);
        search_lv.addFooterView(foot);
        setListener();
    }

    private void setListener() {
        find_cancel.setOnClickListener(this);
        find_clear.setOnClickListener(this);

        search_click.setOnClickListener(this);
        foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                find_info.setText("");
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        head = RelativeLayout.inflate(this,R.layout.search_head,null);
        foot = RelativeLayout.inflate(this,R.layout.search_foot,null);
        clear = (TextView) foot.findViewById(R.id.clear_history);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.find_cancel:
                finish();
                break;
            case R.id.find_clear:
                find_info.setText("");
                break;
            case R.id.search_click:
                String txt = find_info.getText().toString();
                list.add(txt);
                adapter.notifyDataSetChanged();
                break;
//            case R.id.clear:
//                list.clear();
//                adapter.notifyDataSetChanged();
//                break;
        }

    }
}
