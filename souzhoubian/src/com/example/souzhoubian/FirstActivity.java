package com.example.souzhoubian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private ListView listView;
    private Button  button;
    private ImageButton aboutButton,searchButton;
    private ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ?>>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.index);
        listView();
    }
    public void listView() {
        listView = (ListView) findViewById(R.id.listView);
        String[] strings = new String[]{"餐饮服务","购物服务","生活服务","体育休闲服务","医疗保健服务","住宿服务","科教文化服务","交通设施服务","金融保险服务","公共设施服务"};
        for (int i = 0; i < strings.length; i++) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("text", strings[i]) ;
            data.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,
        data,
        R.layout.listview_item,
        new String[]{"text"},
        new int[]{R.id.firstTextView}){
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                button=(Button)view.findViewById(R.id.step) ;

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        TextView textView = (TextView) view.findViewById(R.id.firstTextView);
//                        Log.d("view.setOnClickListener",textView.getText().toString());

                        Intent intent=new Intent();
                        intent.setClass(FirstActivity.this,MyActivity.class);
                        intent.putExtra("name",data.get(position).get("text").toString());
                        startActivity(intent);
                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent();
                        intent.setClass(FirstActivity.this, SecondaryActivity.class);
                        intent.putExtra("name",data.get(position).get("text").toString()) ;
                        startActivityForResult(intent,RESULT_OK);
//                        startActivity(intent);

                    }
                });
                return view ;    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
        listView.setAdapter(adapter);


        aboutButton= (ImageButton) findViewById(R.id.setting);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });
        searchButton= (ImageButton) findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(FirstActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

    }

}

