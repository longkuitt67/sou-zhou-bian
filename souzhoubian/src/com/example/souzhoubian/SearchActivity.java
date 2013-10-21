package com.example.souzhoubian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-18
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class SearchActivity extends Activity {
    private ImageButton searchBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search);
        searchBackButton= (ImageButton) findViewById(R.id.search_nav_back);
        searchBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(SearchActivity.this,FirstActivity.class);
                startActivity(intent);
                SearchActivity.this.finish();
            }
        });
    }
}
