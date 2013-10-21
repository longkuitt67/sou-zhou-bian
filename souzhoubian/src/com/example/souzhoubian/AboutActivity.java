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
 * Date: 13-10-16
 * Time: 下午9:39
 * To change this template use File | Settings | File Templates.
 */
public class AboutActivity extends Activity {
    private ImageButton aboutBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.install);
        aboutBackButton= (ImageButton) findViewById(R.id.about_nav_back);
        aboutBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(AboutActivity.this,FirstActivity.class);
                startActivity(intent);
                AboutActivity.this.finish();
            }
        });
    }

}
