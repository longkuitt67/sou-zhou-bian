package com.example.souzhoubian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-16
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
public class SecondaryActivity extends Activity{

    String[] foodStrings = new String[]{"中餐厅","外国餐厅","快餐厅","休闲餐饮场所","咖啡厅","茶艺馆","冷饮店","糕饼店","甜品店"};
    String[] shoppingStrings=new String[]{"购物相关场所","商场","便民商店／便利店","家电电子卖场","超级市场","花鸟鱼虫市场","家居建材市场","综合市场","文化用品店","体育用品店","特色商业街","服装鞋帽皮具店","专卖店","特殊买卖场所","个人用品/化妆品店"};
    String[] lifeService=new  String[]{"生活服务场所","旅行社","信息咨询中心","售票处","邮局","物流速递","电讯营业厅","事务所","人才市场","自来水营业厅","电力营业厅","美容美发店","维修站点","摄影冲印店","洗浴推拿场所","洗衣店","中介机构","搬家公司","彩票彩券销售点","丧葬设施" };
    String[] sportLife=new String[]{"体育休闲服务场所","运动场馆","高尔夫相关","娱乐场所","度假疗养场所","休闲场所","影剧院"};
    String[] financeInsurance=new String[]{"金融保险服务机构","银行","银行相关","自动提款机","保险公司","证券公司","财务公司"};
    String[] healthCare=new String[]{"医疗保健服务场所","综合医院","专科医院","诊所","急救中心","疾病预防机构","医药保健相关","动物医疗场所"};
    String[] accommodationServices =new String[]{"住宿服务相关","宾馆酒店","旅馆招待所"};
    String[] scienceAndEducationCulturalServices =new String[]{"科教文化场所","博物馆","展览馆","会展中心","美术馆","图书馆","科技馆","天文馆","文化馆","档案馆","文艺团体","传媒机构","学校","科研机构","培训机构","驾校"};
    String[] transportationService=new String[]{"交通服务相关","飞机场","火车站","港口码头","长途汽车站","地铁站","轻轨站","公交车站","班车站","停车场","过境口岸"};
    String [] publicFacilities=new String[]{"公共设施","报刊亭","公用电话","公共厕所","紧急避难场所"};

    /**
     * Called when the activity is first created.
     */

    private ListView listView2;
    private Button button;
    private ImageButton  backButton;

    private ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ?>>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.secondary);

        String[] strings= new String[]{};
        String  twoLevelName =  getIntent().getStringExtra("name");
        TextView title= (TextView) findViewById(R.id.secondTitle);
        title.setText(twoLevelName);
        if(twoLevelName.equals("餐饮服务")){
            strings = foodStrings;
        }  else if(twoLevelName.equals("购物服务")){
            strings = shoppingStrings;
        }  else if(twoLevelName.equals("生活服务")){
            strings = lifeService;
        }  else if(twoLevelName.equals("体育休闲服务")){
            strings = sportLife;
        }  else if (twoLevelName.equals("金融保险服务")){
            strings =  financeInsurance ;
        }   else if (twoLevelName.equals("医疗保健服务")){
            strings =  healthCare ;
        }   else if (twoLevelName.equals("住宿服务")){
            strings =  accommodationServices ;
        }   else if (twoLevelName.equals("科教文化服务")){
            strings =  scienceAndEducationCulturalServices ;
        }    else if (twoLevelName.equals("交通设施服务")){
            strings =  transportationService ;
        }     else if (twoLevelName.equals("公共设施服务")){
            strings =  publicFacilities ;
        }
        listView(strings);
    }
    public void listView(String[] strings) {
        listView2 = (ListView) findViewById(R.id.listView2);

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
            public View getView( final int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
//               final int i  = position;
                button=(Button)view.findViewById(R.id.step) ;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent=new Intent();
                        intent.putExtra("name",data.get(position).get("text").toString())  ;
                        intent.setClass(SecondaryActivity.this,MyActivity.class);
                        startActivity(intent);
                    }
                });
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent();
                        intent.putExtra("cententName",data.get(position).get("text").toString())  ;

                        intent.setClass(SecondaryActivity.this,ThirdActivity.class);
                        startActivity(intent);

                    }
                });
                return view ;    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
        listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                intent.setClass(SecondaryActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });

        backButton= (ImageButton) findViewById(R.id.restaurant_nav_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(SecondaryActivity.this,FirstActivity.class);
                startActivity(intent);
                SecondaryActivity.this.finish();
            }
        });

      }

}
