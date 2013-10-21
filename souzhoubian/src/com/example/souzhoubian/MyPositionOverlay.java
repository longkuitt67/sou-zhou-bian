package com.example.souzhoubian;

import android.content.Context;
import android.graphics.Canvas;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Overlay;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-17
 * Time: 下午2:45
 * To change this template use File | Settings | File Templates.
 */
public class MyPositionOverlay extends Overlay {

    private GeoPoint geoPoint;
    private Context context;
    private int drawable;

    public MyPositionOverlay(GeoPoint geoPoint, Context context, int drawable) {
        super();
        this.geoPoint = geoPoint;
        this.context = context;
        this.drawable = drawable;
    }


    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
//
//        Projection projection = mapView.getProjection();
//        Point point = new Point();
//        projection.toPixels(geoPoint, point);
//
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
//                drawable);
//        canvas.drawBitmap(bitmap, point.x - bitmap.getWidth() , point.y - bitmap.getHeight() , null);
       // super.draw(canvas, mapView, shadow);
    }




}
