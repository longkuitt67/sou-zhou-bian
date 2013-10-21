package com.example.souzhoubian;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.*;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    private static final int SUCCESS = 0;
    private static final int ERROR_SERVER = 1;
    private static final int ERROR_DATA_FORMAT = 2;
    private ListView listView;
    private ImageButton ic_action_map;
    private ImageButton mainBackButton;
    private ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ?>>();
    private View mapview;
    private boolean flag = true;

    private BMapManager bMapManager;
    public static final String strKey = "AB0f4e783ab452277aa2d7deb9517554";
    private MapView mapView;
    private MapController mapController;
    private LayoutInflater layoutInflater;
    private View mapPopWindow;
    private PoiOverlay<OverlayItem> itemItemizedOverlay;
    private MyLocationOverlay myLocationOverlay;
    private ImageButton refreshBar;
    private AlertDialog loginDialog;
    private SimpleAdapter simpleAdapter;

    private LinearLayout jump;
    private TextView showTextView;
    int selectedFruitIndex = 0;
    private ImageButton contentButton;

     List<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        BMapManager bMapManager = new BMapManager(this);
//        bMapManager.init("20deb62852b3e32be20f587e798849db",null);

        bMapManager = new BMapManager(this);
        boolean initResult = bMapManager.init(strKey, new MKGeneralListener() {
            @Override
            public void onGetNetworkState(int iError) {
                if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
                    Toast.makeText(MyActivity.this, "您的网络出错啦！", Toast.LENGTH_LONG).show();
                } else if (iError == MKEvent.ERROR_NETWORK_DATA) {
                    Toast.makeText(MyActivity.this, "输入正确的检索条件！", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onGetPermissionState(int iError) {
                if (iError == MKEvent.ERROR_PERMISSION_DENIED) {
                    Toast.makeText(MyActivity.this, "请在 DemoApplication.java文件输入正确的授权Key！", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (!initResult) {
            Toast.makeText(MapApplication.getInstance().getApplicationContext(), "BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
        }


        setContentView(R.layout.main);
        mapview = findViewById(R.id.mapparent);
        layoutInflater = LayoutInflater.from(this);

        mapView = (MapView) findViewById(R.id.bmapView);

        mapView.setBuiltInZoomControls(false);
        //卫星图层
        mapView.setSatellite(false);
        //交通图层
        mapView.setTraffic(false);


        mapController = mapView.getController();
        //控制缩放等级
        mapController.setZoom(14);

        //移动到经纬度点
        final GeoPoint geoPoint = new GeoPoint((int) (34.25934463685013 * 1E6), (int) (108.94721031188965 * 1E6));
        //设置中心点
        mapController.setCenter(geoPoint);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mapController.animateTo(geoPoint);
            }
        }, 5000);


        Drawable marker = getResources().getDrawable(R.drawable.ic_loc_normal);


        itemItemizedOverlay = new PoiOverlay<OverlayItem>(marker, mapView);


        for (int i = 0; i < 10; i++) {
            GeoPoint point = new GeoPoint(geoPoint.getLatitudeE6() + i * 10000, geoPoint.getLongitudeE6() + i * 10000);
            OverlayItem overlayItem = new OverlayItem(point, "我是标题 " + i, "黄记煌三汁焖锅 " + i);
            itemItemizedOverlay.addItem(overlayItem);
        }

        mapView.getOverlays().add(itemItemizedOverlay);
//        layoutInflater = getLayoutInflater();
        //添加弹出窗口
        mapPopWindow = layoutInflater.inflate(R.layout.map_pop_window, null);
        mapPopWindow.setVisibility(View.GONE);
        mapView.addView(mapPopWindow);


        myLocationOverlay = new MyLocationOverlay(getResources().getDrawable(R.drawable.ic_loc_normal), mapView);
        mapView.getOverlays().add(myLocationOverlay);



        Map();
        ProgressBar();
        mainBack();


        DetailMapView();
        listView();

        JsonTask("https://api.weibo.com/2/location/pois/search/by_geo.json?q=理想国际大厦&access_token=2.0049soLEchqxNE76806c7cb8ype3hB&coordinate=116.322479%2C39.980781");


    }

    public void JsonTask(String url) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("加载中...");
        final String url_name = url;
        AsyncTask<Integer, Integer, Integer> task = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected Integer doInBackground(Integer... integers) {
                try {

                    String result = requestServerData(url_name);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("poilist");
                    for(int i=0;i<jsonArray.length();i++){
                        HashMap<String,String>data=new HashMap<String, String>();
                        JSONObject o = (JSONObject) jsonArray.get(i);

                        data.put("name",o.getString("name"));
                        data.put("address",o.getString("address"));
                        data.put("distance", o.getString("distance"));
                        Log.d("","name"+o.getString("name"));
                        Log.d("","address"+o.getString("address"));
                        Log.d("","distance"+o.getString("distance"));
                        list.add(data);
                    }
                } catch (IOException e) {
                    Log.e("", "Request server data error", e);

                    return ERROR_SERVER;
                } catch (JSONException e) {
                    Log.e("", "Format data error", e);

                    return ERROR_DATA_FORMAT;
                }

                return SUCCESS;
            }

           ;
            @Override
            protected void onPreExecute() {
                progressDialog.show();
            }

            @Override
            protected void onPostExecute(Integer result) {
                progressDialog.dismiss();
               simpleAdapter.notifyDataSetChanged();
//
//                if (result == SUCCESS) {
//                    //跳转到展示界面
//                    gotoDetail(downloadPath, ImageViewerActivity.IMAGE_SOURCE_TEMP);
//
//                } else if (result == ERROR_SERVER) {
//                    showServerErrorMessage();
//                } else if (result == ERROR_DATA_FORMAT) {
//                    showDataErrorMessage();
//                }
            }
        };

        task.execute(0);

    }
    private void showServerErrorMessage() {
        Toast.makeText(this, "请求数据失败", Toast.LENGTH_LONG).show();
    }

    private void showDataErrorMessage() {
        Toast.makeText(this, "数据格式错误", Toast.LENGTH_LONG).show();
    }
    private String requestServerData(String url) throws IOException {
        //请求服务器
        HttpGet request = new HttpGet(url);

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpResponse response = httpClient.execute(request);
        String resultStr = EntityUtils.toString(response.getEntity(), "UTF-8");

        return resultStr;
    }

    public void DetailMapView() {
        jump = (LinearLayout) findViewById(R.id.Jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ProgressBar() {
        refreshBar = (ImageButton) findViewById(R.id.refreshButtonOnActivity);
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

    public void Map() {
        ic_action_map = (ImageButton) findViewById(R.id.mapButton);
        ic_action_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
//                    ic_action_map.setVisibility(View.GONE);
//                    contentButton.setVisibility(View.VISIBLE);
                    ic_action_map.setImageResource(R.drawable.ic_action_list);
                    listView.setVisibility(View.GONE);
                    mapview.setVisibility(View.VISIBLE);
                    flag = false;

                } else {
//                    ic_action_map.setVisibility(View.VISIBLE);
//                    contentButton.setVisibility(View.GONE);
                    ic_action_map.setImageResource(R.drawable.ic_action_map);
                    mapview.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    flag = true;

                }
            }
        });
    }

    public void Dialog(View v) {
        String args[] = new String[]{"1000m内", "2000m内", "3000m内", "4000m内", "5000m内"};
        showTextView = (TextView) findViewById(R.id.fanwei);
        final Dialog alertDialog = new AlertDialog.Builder(this).
                setTitle("选择范围")
                .setIcon(android.R.drawable.ic_menu_more)
                .setSingleChoiceItems(args, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedFruitIndex = which;
                        dialog.dismiss();

                        if (selectedFruitIndex == 0) {
                            showTextView.setText("范围:1000m内");
                        } else if (selectedFruitIndex == 1) {
                            showTextView.setText("范围:2000m内");
                        } else if (selectedFruitIndex == 2) {
                            showTextView.setText("范围:3000m内");
                        } else if (selectedFruitIndex == 3) {
                            showTextView.setText("范围:4000m内");
                        } else if (selectedFruitIndex == 4) {
                            showTextView.setText("范围:5000m内");
                        }
                    }
                }).create();
        alertDialog.show();


    }

    public void listView() {
        listView = (ListView) findViewById(R.id.listView);

        simpleAdapter = new SimpleAdapter(this,
                list,
                R.layout.chat_item,
                new String[]{"name", "address", "distance"},
                new int[]{R.id.TittleText, R.id.AddressMessage, R.id.fanwei});


        listView.setAdapter(simpleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long itemId) {
                listView.setVisibility(View.GONE);
                mapview.setVisibility(View.VISIBLE);
                flag = false;
            }
        });

    }

    public void mainBack() {
        mainBackButton = (ImageButton) findViewById(R.id.main_back);
        mainBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyActivity.this.finish();


            }
        });
    }

    class PoiOverlay<OverlayItem> extends ItemizedOverlay {

        public PoiOverlay(Drawable drawable, MapView mapView) {
            super(drawable, mapView);
        }

        @Override
        protected boolean onTap(int i) {
            Log.d("BaiduMapDemo", "onTap " + i);
            com.baidu.mapapi.map.OverlayItem item = itemItemizedOverlay.getItem(i);
            GeoPoint point = item.getPoint();
            String content = item.getSnippet();


            TextView contentTextView = (TextView) mapPopWindow.findViewById(R.id.contentTextView);
            contentTextView.setText(content);
            contentTextView.setVisibility(View.VISIBLE);

            MapView.LayoutParams layoutParam = new MapView.LayoutParams(
                    //控件宽,继承自ViewGroup.LayoutParams
                    MapView.LayoutParams.WRAP_CONTENT,
                    //控件高,继承自ViewGroup.LayoutParams
                    MapView.LayoutParams.WRAP_CONTENT,
                    //使控件固定在某个地理位置
                    point,
                    0,
                    -40,
                    //控件对齐方式
                    MapView.LayoutParams.BOTTOM_CENTER);

            mapPopWindow.setVisibility(View.VISIBLE);

            mapPopWindow.setLayoutParams(layoutParam);

            mapController.animateTo(point);

            return super.onTap(i);
        }

        @Override
        public boolean onTap(GeoPoint geoPoint, MapView mapView) {
            Log.d("BaiduMapDemo", "onTap geoPoint " + geoPoint);

            mapPopWindow.setVisibility(View.GONE);

            return super.onTap(geoPoint, mapView);    //To change body of overridden methods use File | Settings | File Templates.
        }
    }
}
