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
 * Date: 13-10-17
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
public class ThirdActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private ListView listView3;
    private ImageButton thirdBackButton;
    private Button button;
    private ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ?>>();
    String[] chineseFood = new String[]{"中餐厅","综合酒楼","四川菜(川菜)","广东菜（粤菜）","山东菜（鲁菜)","江苏菜 ","浙江菜","上海菜","湖南菜（湘菜) ","福建菜 ","北京菜","湖北菜（鄂菜)","东北菜","云贵菜","西北菜","老字号 ","火锅店","特色／地方风味餐厅 ","海鲜酒楼 ","中式素菜馆 ","清真菜馆","台湾菜 ","潮州菜"};
    String[] foreignFood = new String[]{"外国餐厅 ","西餐厅（综合风味）","日本料理","韩国料理 ","法式菜品餐厅","意式菜品餐厅","泰国／越南菜品餐厅 ","地中海风格菜品","美式风味","印度风味","英国式菜品餐厅","牛扒店(扒房)","俄国菜","德国菜","巴西菜","墨西哥菜","其它亚洲菜"};
    String[] fastFood = new String[]{"快餐厅","肯德基","麦当劳","必胜客","永和豆浆","茶餐厅","大家乐 ","大快活","美心","吉野家 ","仙跡岩"};
    String[] leisureEntertainment =new String[]{"休闲餐饮场所"};
    String[] coffeeHouse =new String[]{"咖啡厅","星巴克咖啡 ","上岛咖啡","Pacific Coffee Company ","巴黎咖啡店"};
    String[] theAuthor =new String[]{"茶艺馆"};
    String[] coldDrinkShop =new String[]{"冷饮店"};
    String[] pastryShop =new String[]{"糕饼店"};
    String[] sweetShop =new String[]{"甜品店"};
    String[] shopAbout=new String[]{"购物相关场所"};
    String[] market=new String[]{"商场","购物中心","普通商场","免税品店"};
    String[] convenienceStore=new String[]{"便民商店／便利店","7-ELEVEN便利店","OK便利店"};
    String[] HomeAppliance=new String[]{"家电电子卖场","综合家电商场","国美","大中","苏宁","手机销售","数码电子","丰泽","镭射"};
    String[] SuperMarket=new String[]{"超市","家乐福","沃尔玛","华润","北京华联","上海华联","麦德龙","万客隆","华堂易","初莲花","好又多","屈臣氏","乐购","惠康超市","百佳超市","万宁超市" };
    String[] petMarket=new String[]{"花鸟鱼虫市场","花卉市场","宠物市场"};
    String[] homeBuildingMaterialsMarket=new String[]{"家居建材市场","家具建材综合市场","家具城","建材五金市场","厨卫市场","布艺市场","灯具瓷器市场"};
    String[] comprehensiveMarket=new String[]{"综合市场","小商品市场","旧货市场","农副产品市场","果品市场","蔬菜市场","水产海鲜市场"};
    String[] stationeryShop=new String[]{"文化用品店"};
    String[] sportingGoodsStore=new String[]{"体育用品店","李宁专卖店","耐克专卖店","阿迪达斯专卖店","锐步专卖店","彪马专卖店","高尔夫用品店","户外用品"};
    String[] characteristicsOfTheMall=new String[]{"特色商业街","步行街"};
    String[] clothingShoesAndHatsShop=new String[]{"服装鞋帽皮具店","品牌服装店","品牌鞋店","品牌皮具店"};
    String[] store=new String[]{"专营店","古玩字画店","珠宝首饰工艺品","钟表店","眼镜店","书店","音像店","儿童用品店","自行车专卖店","礼品饰品店","烟酒专卖店","宠物用品店","摄影器材店","宝马生活方式"};
    String[] specialBusinessPlace =new String[]{"特殊买卖场所","拍卖行","典当行"};
    String[] personalItems =new String[]{"其它个人用品店","莎莎"};
    String[] lifeServicePlace=new String[]{"生活服务场所"};
    String[] travelAgency =new String[]{"旅行社"};
    String[] InformationConsultationCenter=new String[]{"信息咨询中心"};
    String [] theTicketOffice =new String[]{"售票处","飞机票代售点","火车票代售点","长途汽车票代售点","船票代售点","公交卡／月票代售点","公园景点售票处"};
    String[] thePostOffice =new  String[]{"邮局","邮政速递"};
    String[] logestic=new String[]{"物流速递"};
    String[] telecomBusinessHall=new String[]{"电讯营业厅","中国电信营业厅","中国网通营业厅","中国移动营业厅","中国联通营业厅","中国铁通营业厅","中国卫通营业厅","和记电讯","数码通电讯","电讯盈科","中国移动万众/Peoples"};
    String[] firm=new String[]{"事务所","律师事务所","会计师事务所","评估事务所","审计事务所","认证事务所","专利事务所"};
    String[] talentMarket=new  String[]{"人才市场"};
    String[] waterSupplyCompany=new  String[]{"自来水营业厅"};
    String[] electricPowerBusinessHall=new  String[]{"电力营业厅"};
    String[] beautyParlor=new  String[]{"美容美发店"};
    String[] siteMaintenance=new  String[]{"维修站点"};
    String[] photographyPhotoShop=new  String[]{"摄影冲印店"};
    String[] bathingPlace=new  String[]{"洗浴推拿场所"};
    String[] laundress=new  String[]{"洗衣店"};
    String[] intermediary =new  String[]{"中介机构"};
    String[] remover=new  String[]{"搬家公司"};
    String[] lotteryTicketSales =new  String[]{"彩票彩券销售点","马会投注站"};
    String[] funeralFacilities=new  String[]{"丧葬设施","陵园","公墓","殡仪馆"};
    String[] sportServe=new  String[]{"体育休闲服务场所"};
    String[] sportPlace=new  String[]{"运动场所","综合体育馆","保龄球馆","网球场","篮球场馆","足球场","滑雪场","溜冰场","户外健身场所","海滨浴场","游泳馆","健身中心","乒乓球馆","台球厅","壁球场","马术俱乐部","赛马场","橄榄球场","羽毛球场","跆拳道场馆"};
    String[] golfAbout=new String[]{"高尔夫相关","高尔夫球场","高尔夫练习场"};
    String[] amusementPlace=new String[]{"娱乐场所","夜总会","ＫＴＶ","迪厅","酒吧","游戏厅","棋牌室","博采中心","网吧"};
    String[] vacationPlace=new String[]{"度假疗养场所","度假村","疗养院"};
    String[] arderPlace=new String[]{"休闲场所","游乐场","垂钓园","采摘园","露营地","水上活动中心"};
    String[]filmPlace=new String[]{"影剧院相关","电影院","音乐厅","剧场"};
    String [] finance=new String[]{"金融保险机构"};
    String[] bank=new String[]{"银行","中国人民银行","国家开发银行","中国进出口银行","中国银行","中国工商银行","中国建设银行","中国农业银行","交通银行","招商银行","华夏银行","中信银行","中国民生银行","中国光大银行","上海银行","上海浦东发展银行","深圳发展银行","深圳市商业银行","兴业银行","北京银行","广东发展银行","中国信合","香港恒生银行","东亚银行","美国花旗银行","渣打银行","汇丰银行","荷兰银行","美国运通银行","瑞士友邦银行","美国银行","蒙特利尔银行","纽约银行","苏格兰皇家银行","法国兴业银行","德意志银行","日本三菱东京日联银行","巴克莱银行","摩根大通银行","中国邮政储蓄","香港星展银行","南洋商业银行","上海商业银行","永亨银行","香港永隆银行","创兴银行","大新银行","中信嘉华银行","大众银行(香港)"};
    String [] bankAbout =new String[]{"银行相关"};
    String []ATM=new String[]{"自动提款机","中国银行ATM","中国工商银行ATM","中国建设银行ATM","中国农业银行ATM","交通银行ATM","招商银行ATM","华夏银行ATM","中信银行ATM","中国民生银行ATM","中国光大银行ATM","上海银行ATM","上海浦东发展银行ATM","深圳发展银行ATM","深圳市商业银行ATM","兴业银行ATM","北京银行ATM","广东发展银行","中国信合ATM","香港恒生银行ATM","东亚银行ATM","美国花旗银行ATM","渣打银行ATM","汇丰银行ATM","荷兰银行ATM","美国运通银行ATM","瑞士友邦银行ATM","美国银行ATM","蒙特利尔银行ATM","纽约银行ATM","苏格兰皇家银行ATM","法国兴业银行ATM","日本三菱东京日联银行ATM","巴克莱银行ATM","摩根大通银行ATM","中国邮政储蓄ATM","香港星展银行ATM","南洋商业银行ATM","上海商业银行ATM","永亨银行ATM","香港永隆银行ATM","大新银行ATM","中信嘉华银行ATM","大众银行(香港)ATM"};
    String [] insure=new String[]{"保险公司","中国人民保险公司","中国人寿保险公司","中国平安保险公司","中国再保险公司","中国太平洋保险公司","新华人寿保险公司","华泰财产保险股份有限公司","泰康人寿保险公司"};
    String []paper=new String[]{"证券公司","证券营业厅"};
    String []financeCompany=new String[]{"财务公司"};
    String [] healthCareSettings=new String[]{"医疗保健服务场所"};
    String[] polyclinic=new String[]{"综合医院","三级甲等医院","卫生院"};
    String [] specialHospital=new String[]{"专科医院","整形美容","口腔医院","眼科医院","耳鼻喉医院","胸科医院","骨科医院","肿瘤医院","脑科医院","妇科医院","精神病医院","传染病医院"};
    String []clinic=new String[]{"诊所"};
    String []emergencyCenter=new String[]{"急救中心"};
    String []iodp=new String[]{"疾病预防"};
    String []healthCareAbout=new String[]{"医药保健相关","药房","医疗保健用品"};
    String []animalHealthFacilities=new String[]{"动物医疗场所","宠物诊所","兽医站"};
    String [] accommodationAbout=new String[]{"住宿服务相关"};
    String [] hotel=new String[]{"宾馆酒店","六星级宾馆","五星级宾馆","四星级宾馆","三星级宾馆","经济型连锁酒店"};
    String[] hotelGuestHouse=new String[]{"旅馆招待所","青年旅社"};
    String [] scienceAndEducationCulturalServices=new String[]{"科教文化场所"};
    String [] museum=new String[]{"博物馆","奥迪博物馆","奔驰博物馆"};
    String [] exhibitionHall=new String[]{"展览馆"};
    String [] conventionCenter=new String[]{"会展中心"};
    String [] gallery=new String[]{"美术馆"};
    String [] library=new String[]{"图书馆"};
    String [] scienceTechnologyMuseum=new String[]{"科技馆"};
    String [] planetarium=new String[]{"天文馆"};
    String [] culturalCenter=new String[]{"文化馆"};
    String [] archives =new String[]{"档案馆"};
    String [] artTroupe=new String[]{"文艺团体"};
    String [] media=new String[]{"传媒机构","电视台","电台","报社","杂志社","出版社"};
    String [] school=new String[]{"学校","高等院校","中学","小学","幼儿园","成人教育","职业技术学校"};
    String [] scientificResearch=new String[]{"科研机构"};
    String [] training=new String[]{"培训机构"};
    String [] drivingSchool=new String[]{"驾校"};
    String [] transportationServiceAbout=new String[]{"交通服务相关"};
    String [] airport =new String[]{"飞机场"};
    String [] depot=new String[]{"火车站"};
    String [] port=new String[]{"港口码头","客运港","车渡口","人渡口"};
    String [] coachStation=new String[]{"长途汽车站"};
    String [] subwayStation =new String[]{"地铁站"};
    String [] lightRailStation=new String[]{"轻轨站"};
    String [] busStation=new String[]{"公交车站相关","旅游专线车站","普通公交站"};
    String [] BanCheZhan =new String[]{"班车站"};
    String [] parkingLot =new String[]{"停车场相关","室内停车场","室外停车场","停车换乘点"};
    String [] transitPort =new String[]{"过境口岸"};
    String [] communalFacilities=new String[]{"公共设施"};
    String [] kiosk=new String[]{"报刊亭"};
    String []  publicTelephone=new String[]{"公用电话"};
    String [] publicToilet=new String[]{"公共厕所"};
    String [] emergencyShelter =new String[]{"紧急避难场所"};






    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third);
       String []  strings1 = new String[]{};
       String  threeLevel =  getIntent().getStringExtra("cententName");
        TextView title= (TextView) findViewById(R.id.thirdTitle);
        title.setText(threeLevel);
        if(threeLevel.equals("中餐厅")){
           strings1 = chineseFood;
        } else if(threeLevel.equals("外国餐厅")){
            strings1=foreignFood;
        }  else if(threeLevel.equals("快餐厅")){
            strings1=fastFood;
        }  else if(threeLevel.equals("休闲餐饮场所")){
            strings1=leisureEntertainment;
        }  else if(threeLevel.equals("咖啡厅")){
            strings1=coffeeHouse;
        }   else if(threeLevel.equals("茶艺馆")){
            strings1=theAuthor;
        }  else if(threeLevel.equals("冷饮店")){
            strings1=coldDrinkShop;
        }    else if(threeLevel.equals("糕饼店")){
            strings1=pastryShop;
        }  else if(threeLevel.equals("甜品店")){
            strings1=sweetShop;
        } else if(threeLevel.equals("购物相关场所")){
            strings1=shopAbout;
        }  else if(threeLevel.equals("商场")){
            strings1=market;
        }  else if(threeLevel.equals("便民商店／便利店")){
            strings1=convenienceStore;
        }  else if(threeLevel.equals("家电电子卖场")){
            strings1=HomeAppliance;
        }  else if(threeLevel.equals("超级市场")){
            strings1=SuperMarket;
        }   else if(threeLevel.equals("花鸟鱼虫市场")){
            strings1=petMarket;
        }  else if(threeLevel.equals("家居建材市场")){
            strings1=homeBuildingMaterialsMarket;
        }    else if(threeLevel.equals("综合市场")){
            strings1=comprehensiveMarket;
        }  else if(threeLevel.equals("文化用品店")){
            strings1=stationeryShop;
        } else if(threeLevel.equals("体育用品店")){
            strings1=sportingGoodsStore;
        }  else if(threeLevel.equals("特色商业街")){
            strings1=characteristicsOfTheMall;
        }  else if(threeLevel.equals("服装鞋帽皮具店")){
            strings1=clothingShoesAndHatsShop;
        }  else if(threeLevel.equals("专卖店")){
            strings1=store;
        } else if(threeLevel.equals("特殊买卖场所")){
            strings1=specialBusinessPlace;
        }  else if(threeLevel.equals("个人用品/化妆品店")){
            strings1=personalItems;
        }   else if(threeLevel.equals("生活服务场所")){
            strings1=lifeServicePlace;
        }  else if(threeLevel.equals("旅行社")){
            strings1=travelAgency;
        }  else if(threeLevel.equals("信息咨询中心")){
            strings1=InformationConsultationCenter;
        }  else if(threeLevel.equals("售票处")){
            strings1=theTicketOffice;
        }   else if(threeLevel.equals("邮局")){
            strings1=thePostOffice;
        }  else if(threeLevel.equals("物流速递")){
            strings1=logestic;
        }    else if(threeLevel.equals("电讯营业厅")){
            strings1=telecomBusinessHall;
        }  else if(threeLevel.equals("事务所")){
            strings1=firm;
        } else if(threeLevel.equals("人才市场")){
            strings1=talentMarket;
        }  else if(threeLevel.equals("自来水营业厅")){
            strings1=waterSupplyCompany;
        }  else if(threeLevel.equals("电力营业厅")){
            strings1=electricPowerBusinessHall;
        }  else if(threeLevel.equals("美容美发店")){
            strings1=beautyParlor ;
        }  else if(threeLevel.equals("维修站点")){
            strings1=siteMaintenance ;
        }   else if(threeLevel.equals("摄影冲印店")){
            strings1=photographyPhotoShop ;
        }  else if(threeLevel.equals("洗浴推拿场所")){
            strings1=bathingPlace ;
        }    else if(threeLevel.equals("洗衣店")){
            strings1=laundress ;
        }  else if(threeLevel.equals("中介机构")){
            strings1=intermediary ;
        } else if(threeLevel.equals("搬家公司")){
            strings1=remover ;
        }  else if(threeLevel.equals("彩票彩券销售点")){
            strings1=lotteryTicketSales ;
        }  else if(threeLevel.equals("丧葬设施")){
            strings1=funeralFacilities;
        }    else if(threeLevel.equals("体育休闲服务场所")){
            strings1=sportServe ;
        }  else if(threeLevel.equals("运动场馆")){
            strings1=sportPlace ;
        }    else if(threeLevel.equals("高尔夫相关")){
            strings1=golfAbout ;
        }  else if(threeLevel.equals("娱乐场所")){
            strings1=amusementPlace ;
        } else if(threeLevel.equals("度假疗养场所")){
            strings1=vacationPlace ;
        }  else if(threeLevel.equals("休闲场所")){
            strings1=arderPlace ;
        }  else if(threeLevel.equals("影剧院")){
            strings1=filmPlace;
        } else if(threeLevel.equals("金融保险服务机构")){
            strings1 = finance;
        } else if(threeLevel.equals("银行")){
            strings1=bank;
        }  else if(threeLevel.equals("银行相关")){
            strings1=bankAbout;
        }  else if(threeLevel.equals("自动提款机")){
            strings1=ATM;
        }  else if(threeLevel.equals("保险公司")){
            strings1=insure;
        }   else if(threeLevel.equals("证券公司")){
            strings1=paper;
        }  else if(threeLevel.equals("财务公司")){
            strings1=financeCompany;
        }    else if(threeLevel.equals("医疗保健服务场所")){
            strings1 = healthCareSettings;
        } else if(threeLevel.equals("综合医院")){
            strings1=polyclinic;
        }  else if(threeLevel.equals("专科医院")){
            strings1=specialHospital;
        }  else if(threeLevel.equals("诊所")){
            strings1=clinic;
        }  else if(threeLevel.equals("急救中心")){
            strings1=emergencyCenter;
        }   else if(threeLevel.equals("疾病预防机构")){
            strings1=iodp;
        }  else if(threeLevel.equals("医药保健相关")){
            strings1=healthCareAbout;
        }else if(threeLevel.equals("动物医疗场所")){
            strings1=animalHealthFacilities;
        } else if(threeLevel.equals("住宿服务相关")){
            strings1 = accommodationAbout;
        } else if(threeLevel.equals("宾馆酒店")){
            strings1=hotel;
        }  else if(threeLevel.equals("旅馆招待所")){
            strings1=hotelGuestHouse;
        }  else if(threeLevel.equals("科教文化场所")){
            strings1 = scienceAndEducationCulturalServices;
        } else if(threeLevel.equals("博物馆")){
            strings1=museum;
        }  else if(threeLevel.equals("展览馆")){
            strings1=exhibitionHall;
        }  else if(threeLevel.equals("会展中心")){
            strings1=conventionCenter;
        }  else if(threeLevel.equals("美术馆")){
            strings1=gallery;
        }   else if(threeLevel.equals("图书馆")){
            strings1=library;
        }  else if(threeLevel.equals("科技馆")){
            strings1=scienceTechnologyMuseum;
        }else if(threeLevel.equals("天文馆")){
            strings1=planetarium;
        } else if(threeLevel.equals("文化馆")){
            strings1=culturalCenter;
        }  else if(threeLevel.equals("档案馆")){
            strings1=archives;
        }  else if(threeLevel.equals("文艺团体")){
            strings1=artTroupe;
        }  else if(threeLevel.equals("传媒机构")){
            strings1=media;
        }  else if(threeLevel.equals("学校")){
            strings1=school;
        }   else if(threeLevel.equals("科研机构")){
            strings1=scientificResearch;
        }  else if(threeLevel.equals("培训机构")){
            strings1=training;
        }else if(threeLevel.equals("驾校")){
            strings1=drivingSchool;
        }  else if(threeLevel.equals("交通服务相关")){
            strings1 = transportationServiceAbout;
        } else if(threeLevel.equals("飞机场")){
            strings1=airport;
        }  else if(threeLevel.equals("火车站")){
            strings1=depot;
        }  else if(threeLevel.equals("港口码头")){
            strings1=port;
        }  else if(threeLevel.equals("长途汽车站")){
            strings1=coachStation;
        }   else if(threeLevel.equals("地铁站")){
            strings1=subwayStation;
        }  else if(threeLevel.equals("轻轨站")){
            strings1=lightRailStation;
        }else if(threeLevel.equals("公交车站")){
            strings1=busStation;
        }  else if(threeLevel.equals("班车站")){
            strings1=BanCheZhan;
        }  else if(threeLevel.equals("停车场")){
            strings1=parkingLot;
        }  else if(threeLevel.equals("过境口岸")){
            strings1=transitPort;
        }  else if(threeLevel.equals("公共设施")){
            strings1 = communalFacilities;
        } else if(threeLevel.equals("报刊亭")){
            strings1=kiosk;
        }  else if(threeLevel.equals("公用电话")){
            strings1=publicTelephone;
        }  else if(threeLevel.equals("公共厕所")){
            strings1=publicToilet;
        }  else if(threeLevel.equals("紧急避难场所")){
            strings1=emergencyShelter;
        }

        listView(strings1);

    }


    public void listView(String[] strings) {
        listView3 = (ListView) findViewById(R.id.listView3);
        for (int i = 0; i < strings.length; i++) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("text", strings[i]) ;
            data.add(item);
        }
        Intent intent = getIntent();
        String s =  intent.getStringExtra("cententName");
        int index=   intent.getIntExtra("cententIndex",1);
        Toast.makeText(ThirdActivity.this,"name= "+s+"  index="+index,Toast.LENGTH_SHORT);
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
                        Intent intent=new Intent();
                        intent.putExtra("name",data.get(position).get("text").toString())  ;
                        intent.setClass(ThirdActivity.this,MyActivity.class);
                        startActivity(intent);
                    }
                });
                button.setVisibility(View.INVISIBLE);
                return view;    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
        listView3.setAdapter(adapter);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                intent.setClass(ThirdActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });
        thirdBackButton= (ImageButton) findViewById(R.id.western_nav_back);
        thirdBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
