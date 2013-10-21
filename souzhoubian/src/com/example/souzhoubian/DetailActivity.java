package com.example.souzhoubian;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.*;
import com.baidu.mapapi.search.MKRoute;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-16
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */
public class DetailActivity extends Activity {
    private TabHost tab;
    private BMapManager bMapManager;
    public static final String strKey = "AB0f4e783ab452277aa2d7deb9517554";
    private MapView mapView;
    private MapController mapController;
    private LayoutInflater layoutInflater;
    private ImageButton DetailBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapView();
        setContentView(R.layout.detailmessage1);//To change body of overridden methods use File | Settings | File Templates.
//        tab = (TabHost) findViewById(R.id.tabs);
//
//        tab.setup(this.getLocalActivityManager());
//
//        final View buxing = getLayoutInflater().inflate(R.layout.byfoot, null);
//        final View gongjiao= getLayoutInflater().inflate(R.layout.bybus,null);
//        final View jiache= getLayoutInflater().inflate(R.layout.bycar, null);


//        tab.addTab(tab.newTabSpec("foot")// 制造一个新的标签TT
//                .setIndicator(buxing)
//                .setContent(R.id.content1));
//
//        tab.addTab(tab.newTabSpec("bus")// 制造一个新的标签TT
//                .setIndicator(gongjiao)
//                .setContent(R.id.content2));
//
//        tab.addTab(tab.newTabSpec("car")// 制造一个新的标签TT
//                .setIndicator(jiache)
//                .setContent(R.id.content3));
        layoutInflater = LayoutInflater.from(this);

        mapView = (MapView) findViewById(R.id.bmapView1);

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
        GeoPoint geoPoint1 = new GeoPoint((int) (34.25934463685013 * 1E6+1000), (int) (108.94721031188965 * 1E6+1000));
        ItemizedOverlay itemizedOverlay = new ItemizedOverlay(getResources().getDrawable(R.drawable.ic_loc_from),mapView);
        OverlayItem overlayItem = new OverlayItem(geoPoint,"这是起点，","这是对起点的描述");
        OverlayItem overlayItem1 = new OverlayItem(geoPoint1,"这是终点，","这是对终点的描述");
        overlayItem1.setMarker(getResources().getDrawable(R.drawable.ic_loc_to));

        OverlayItem overlayItem2 = new OverlayItem(geoPoint,"这是原点，","这是对原点的描述");
        overlayItem2.setMarker(getResources().getDrawable(R.drawable.ic_current_loc));

        itemizedOverlay.addItem(overlayItem2);
        itemizedOverlay.addItem(overlayItem);
        itemizedOverlay.addItem(overlayItem1);


        GeoPoint[] step2 = new GeoPoint[2];
        step2[0] = geoPoint;
        step2[1] = geoPoint1;

        MKRoute route = new MKRoute();
        route.customizeRoute(geoPoint,geoPoint1,step2);
        //将包含站点信息的MKRoute添加到RouteOverlay中
        RouteOverlay routeOverlay = new RouteOverlay(DetailActivity.this, mapView);
        routeOverlay.setData(route);
        //向地图添加构造好的RouteOverlay
        mapView.getOverlays().add(routeOverlay);



       mapView.getOverlays().add(itemizedOverlay);

        mapView.refresh();


        DetailBackButton();

    }

    private void DetailBackButton() {
        DetailBackButton=(ImageButton)findViewById(R.id.DetailBack);
        DetailBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity.this.finish();
            }
        });
    }

    public void MapView(){
        bMapManager = new BMapManager(this);
        boolean initResult = bMapManager.init(strKey, new MKGeneralListener() {
            @Override
            public void onGetNetworkState(int iError) {
                if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
                    Toast.makeText(DetailActivity.this, "您的网络出错啦！", Toast.LENGTH_LONG).show();
                } else if (iError == MKEvent.ERROR_NETWORK_DATA) {
                    Toast.makeText(DetailActivity.this, "输入正确的检索条件！", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onGetPermissionState(int iError) {
                if (iError == MKEvent.ERROR_PERMISSION_DENIED) {
                    Toast.makeText(DetailActivity.this, "请在 DemoApplication.java文件输入正确的授权Key！", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (!initResult) {
            Toast.makeText(MapApplication.getInstance().getApplicationContext(), "BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
        }

//        setContentView(R.layout.map_activity);



    }
}
