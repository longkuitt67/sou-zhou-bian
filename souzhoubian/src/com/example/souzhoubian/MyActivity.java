package com.example.souzhoubian;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MyActivity extends Activity {

    /**
     * Called when the activity is first created.
     */

    private ListView listView;
    private ImageButton ic_action_map;
    private ImageButton refreshBar;
    private ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ?>>();
    int selectedFruitIndex = 0;
    private AlertDialog loginDialog;
    private TextView showTextView;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView();
        Map();
        ProgressBar();
    }
    public void ProgressBar(){
         refreshBar=(ImageButton)findViewById(R.id.refreshButtonOnActivity);
         refreshBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);

                LayoutInflater inflater = LayoutInflater.from(MyActivity.this);
                View progress = inflater.inflate(R.layout.progressbar, null);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.FILL_PARENT);
                progress.setLayoutParams(params);

                builder.setView(progress);

                loginDialog = builder.create();
                loginDialog.show();
            }
        });
    }
    public void Map(){
        ic_action_map=(ImageButton)findViewById(R.id.mapButton);
        ic_action_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MyActivity.this,MapActivity.class);
                //Intent intent=new Intent(IntentTest.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Dialog(View v) {
        String args[] = new String[]{"1000m内", "2000m内", "3000m内", "4000m内", "5000m内"};
        showTextView=(TextView)findViewById(R.id.fanwei);
       final Dialog alertDialog = new AlertDialog.Builder(this).
                setTitle("选择范围")
                .setIcon(android.R.drawable.ic_menu_more)
                .setSingleChoiceItems(args, 0, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedFruitIndex=which;
                        dialog.dismiss();

                        if(selectedFruitIndex==0){
                            showTextView.setText("范围:1000m内");
                        }else if(selectedFruitIndex==1){
                            showTextView.setText("范围:2000m内");
                        } else if(selectedFruitIndex==2){
                            showTextView.setText("范围:3000m内");
                        } else if(selectedFruitIndex==3){
                            showTextView.setText("范围:4000m内");
                        } else if(selectedFruitIndex==4){
                            showTextView.setText("范围:5000m内");
                        }
                    }
                }).create();
        alertDialog.show();



    }

    public void listView() {
        listView = (ListView) findViewById(R.id.listView);
        for (int i = 0; i < 20; i++) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("title", "黄记煌三汁焖锅");
            item.put("address", "西安南大街52号南附楼内3层” ");
            item.put("fanwei", " 500m");
            if (i == 1) {
                item.put("title", "香港私家菜天子海鲜火锅 " + i);
                item.put("address", "南大街 " + i + " " + i);
                item.put("fanwei", "500m");
                data.add(item);
                continue;
            }
            data.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.chat_item,
                new String[]{"title", "address", "fanwei"},
                new int[]{R.id.TittleText, R.id.AddressMessage, R.id.fanwei});


        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long itemId) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });

    }
}
