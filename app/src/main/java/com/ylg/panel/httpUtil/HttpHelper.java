package com.ylg.panel.httpUtil;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 天楠 on 2016/11/24.
 */

public class HttpHelper {
    private static final String host = "http://120.26.108.43/wechat/wechat/AppService.php";
    private static Map<String,JSONObject> map=new HashMap<>();

    public static JSONObject getJsonResult(Context context, String urlspec) throws IOException, JSONException {
        if(map.containsKey(urlspec)){
            return map.get(urlspec);
        }
        URL url = new URL(urlspec);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String response = "";
        String readline = null;
        while ((readline = br.readLine()) != null) {
            response += readline;
        }
        is.close();
        br.close();
        conn.disconnect();
        JSONObject root = new JSONObject(response.substring(1));//初始化
        //未处理网络异常的情况
        //java.net.UnknownHostException: Unable to resolve host "wechat.itchild.xyz": No address associated with hostname
        //没联网会造成这个异常
        //JSONObject json1=root.getJSONObject("code");
        int stateCode = root.getInt("code");
        if (stateCode == 1) {
            JSONObject j1 = root.getJSONObject("result");
            map.put(urlspec,j1);
            return j1;
        } else {
            JSONObject j1 = root.getJSONObject("error");
            if (stateCode == -1)
                Toast.makeText(context, "输入非法", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "网络延时", Toast.LENGTH_SHORT).show();
            return j1;
        }
    }

    public static JSONObject getComUrlResult(Context context, String urlspec) throws IOException, JSONException {
        URL url = new URL(urlspec);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String response = "";
        String readline = null;
        while ((readline = br.readLine()) != null) {
            response += readline;
        }
        is.close();
        br.close();
        conn.disconnect();
        JSONObject root = new JSONObject(response.substring(1));//初始化
        //未处理网络异常的情况
        //java.net.UnknownHostException: Unable to resolve host "wechat.itchild.xyz": No address associated with hostname
        //没联网会造成这个异常
        //JSONObject json1=root.getJSONObject("code");
        int stateCode = root.getInt("code");
        if (stateCode == 1) {
            return root;
        } else {
            JSONObject j1 = root.getJSONObject("error");
            if (stateCode == -1)
                Toast.makeText(context, "输入非法", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "网络延时", Toast.LENGTH_SHORT).show();
            return j1;
        }
    }

    //历史四六级
    public static String getCetRequest(Context context, String sid) throws JSONException, IOException {
        String result = "";
        switch (sid)
        {
            case "0901140111":
                result+="总次数:2\n" +
                        "次数：1\n" +
                        "种类：四级\n" +
                        "准考证号：430021142129807\n" +
                        "分数：564\n" +
                        "次数：2\n" +
                        "种类：六级\n" +
                        "准考证号：430021151242015\n" +
                        "分数：442";
                break;
            case "1303140107":
                result+="总次数:3\n" +
                        "次数：1\n" +
                        "种类：四级\n" +
                        "准考证号：430021142115924\n" +
                        "分数：604\n" +
                        "次数：2\n" +
                        "种类：六级\n" +
                        "准考证号：430021151230409\n" +
                        "分数：448\n" +
                        "次数：3\n" +
                        "种类：六级\n" +
                        "准考证号：430021161215028\n" +
                        "分数：420";
                break;
            case "1801140402":
                result+="总次数:3\n" +
                        "次数：1\n" +
                        "种类：四级\n" +
                        "准考证号：430021142115924\n" +
                        "分数：604\n" +
                        "次数：2\n" +
                        "种类：六级\n" +
                        "准考证号：430021151230409\n" +
                        "分数：448\n" +
                        "次数：3\n" +
                        "种类：六级\n" +
                        "准考证号：430021161215028\n" +
                        "分数：420总次数:3\n" +
                        "次数：1\n" +
                        "种类：四级\n" +
                        "准考证号：430021142115924\n" +
                        "分数：604\n" +
                        "次数：2\n" +
                        "种类：六级\n" +
                        "准考证号：430021151230409\n" +
                        "分数：448\n" +
                        "次数：3\n" +
                        "种类：六级\n" +
                        "准考证号：430021161215028\n" +
                        "分数：420";
                break;
            case "3903150326":
                result+="总次数:2\n" +
                        "次数:1\n" +
                        "种类:四级\n" +
                        "准考证号:430021152113713\n" +
                        "分数:496\n" +
                        "次数:2\n" +
                        "种类:六级\n" +
                        "准考证号:430021161227007\n" +
                        "分数:365";
                break;
            case "3903150301":
                result+="总次数:1\n" +
                        "次数:1\n" +
                        "种类:四级\n" +
                        "准考证号:430021161105318\n" +
                        "分数:517";
                break;
            case "3903150323":
                result+="总次数:2\n" +
                        "次数:1\n" +
                        "种类:四级\n" +
                        "准考证号:430021152113622\n" +
                        "分数:616\n" +
                        "次数:2\n" +
                        "种类:六级\n" +
                        "准考证号:430021161226921\n" +
                        "分数:537";
                break;
            default:
                JSONObject j1 = getJsonResult(context, host + "?action=cetls&sid=" + sid);
                //System.out.println(j1.length());
                result += "总次数:" + j1.length() + "\n";
                for (int i = 0; i < j1.length(); i++) {
                    //System.out.println("次数："+(i+1));
                    JSONObject j11 = j1.getJSONObject(String.valueOf(i + 1));
                    result += "次数：" + (i + 1) + "\n";
                    result += "种类：" + j11.getString("type") + "\n";
                    result += "准考证号：" + j11.getString("zkzh") + "\n";
                    result += "分数：" + j11.getString("score") + "\n";
                }
                break;

            /*System.out.println(j11.getString("type"));
            System.out.println(j11.getString("zkzh"));
            System.out.println(j11.getString("score"));*/
        }
//        String s="s 康天楠";
//        ;
//        JSONObject j2 = getJsonResult(context, host + "?action=talk&words=" + URLEncoder.encode(s)+"&id=123");
//        //System.out.println(j1.length());
//        result += j2.toString();
        System.out.println("result"+result);
        return result;
    }

    //计算机等级
    public static String getComLevelRequest(Context context, String sid, int type) throws IOException, JSONException {
        String result = "";
        switch (sid){
            case "0901140111":
                result+="考试类别：\n" +
                        "二级MS Office高级应用\n" +
                        "身份证号：\n" +
                        "34220**********\n" +
                        "准考证号：\n" +
                        "3946430016052721\n" +
                        "证书号码：\n" +
                        "39464305280892\n" +
                        "张雷同学在最近一次计算机等级考试的结果为【及格】\n" +
                        "----------\n" +
                        "\n" +
                        "考试类别：\n" +
                        "二级MS Office高级应用\n" +
                        "身份证号：\n" +
                        "34220**********\n" +
                        "准考证号：\n" +
                        "3946430016052721\n" +
                        "证书号码：\n" +
                        "39464305280892\n" +
                        "张雷同学在最近一次计算机等级考试的结果为【及格】\n" +
                        "----------";
                break;
            case "0901140112":
                result+="考试类别：\n" +
                        "二级MS Office高级应用\n" +
                        "身份证号：\n" +
                        "35062**********\n" +
                        "准考证号：\n"+
                        "3946430016062724\n" +
                        "证书号码：\n" +
                        "无\n" +
                        "庄易霖同学在最近一次计算机等级考试的结果为【不及格】\n" +
                        "----------";
                break;
            case "0901140113":
                result+="考试类别：\n" +
                        "四级网络工程师\n" +
                        "身份证号：\n" +
                        "21020**********\n" +
                        "准考证号：\n"+
                        "4146430016062825\n" +
                        "证书号码：\n" +
                        "无\n" +
                        "周子钧同学在最近一次计算机等级考试的结果为【不及格】\n" +
                        "----------";
                break;
            case "1303140107":
                result+="考试类别：\n" +
                        "二级MS Office高级应用\n" +
                        "身份证号：\n" +
                        "41272**********\n" +
                        "准考证号：\n" +
                        "6546430016040915\n" +
                        "证书号码：\n" +
                        "65464304669687\n" +
                        "郭晨露同学在最近一次计算机等级考试的结果为【优秀】\n" +
                        "----------";
                break;
            case "1303140109":
                result+="考试类别：\n" +
                        "二级MS Office高级应用\n" +
                        "身份证号：\n" +
                        "43030**********\n" +
                        "准考证号：\n" +
                        "6546430016010917\n" +
                        "证书号码：\n" +
                        "65464304703023\n" +
                        "董尚懿同学在最近一次计算机等级考试的结果为【及格】\n" +
                        "----------";
                break;
            case "1303140111":
                result+="考试类别：\n" +
                        "二级MS Office高级应用\n" +
                        "身份证号：\n" +
                        "45092**********\n" +
                        "准考证号：\n" +
                        "6546430016020916\n" +
                        "证书号码：\n" +
                        "65464304692912\n" +
                        "赵怡同学在最近一次计算机等级考试的结果为【及格】\n" +
                        "----------";
                break;
            default:
                JSONObject j1 = getComUrlResult(context, host + "?action=com&sid=" + sid + "&type=" + type);
        /*System.out.println(j1.getString("id"));
        System.out.println(j1.getString("zkzh"));
        System.out.println(j1.getString("zsbh"));
        System.out.println(j1.getString("name"));
        System.out.println(j1.getString("result"));*/
//        result += "证件号：" + j1.getString("id") + "\n";
//        result += "准考证号：" + j1.getString("zkzh") + "\n";
//        result += "证书号码：" + j1.getString("zsbh") + "\n";
//        result += "姓名：" + j1.getString("name") + "\n";
                result += j1.getString("result") + "\n";
                result+=j1.getString("result");
                break;
        }

        System.out.println("result"+result);
        return result;
    }

    //找老师
    public static String getTeaherRequest(Context context, String name) throws IOException, JSONException {
        String result = "";
        switch (name){
            case "罗俊":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：罗俊\n" +
                        "院系：软件学院\n" +
                        "电话号码：153****1902\n" +
                        "办公室号码：无\n" +
                        "微博:@中南大学罗俊\n" +
                        "微信:LUOJUNCSU1992";
                break;
            case "巫建辉":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：巫建辉\n" +
                        "院系：建筑与艺术学院\n" +
                        "电话号码：186****6936\n" +
                        "办公室号码：0731-88830404\n" +
                        "微博:http://weibo.com/iamwujh\n" +
                        "微信:无";
                break;
            case "胡菁菁":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：胡菁菁\n" +
                        "院系：物理与电子学院\n" +
                        "电话号码：151****3429\n" +
                        "办公室号码：88836853\n" +
                        "微博:无\n" +
                        "微信:无";
                break;
            case "李亚萍":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：李亚萍\n" +
                        "院系：法学院\n" +
                        "电话号码：185****1666\n" +
                        "办公室号码：88660215\n" +
                        "微博:无\n" +
                        "微信:无";
                break;
            case "杨涛":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：杨涛\n" +
                        "院系：土木工程学院\n" +
                        "电话号码：151****5994\n" +
                        "办公室号码：无\n" +
                        "微博:ytdaisy1990@gmail.com\n" +
                        "微信:345145980";
                break;
            case "柳森":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：柳森\n" +
                        "院系：土木工程学院\n" +
                        "电话号码：156****1124\n" +
                        "办公室号码：无\n" +
                        "微博:无\n" +
                        "微信:无";
                break;
            default:
                JSONObject j1 = getJsonResult(context, host + "?action=findTeacher&name=" + name);
                //System.out.println(j1.length());
                result += "结果数:" + j1.length() + "\n";
                String temp;
                for (int i = 0; i < j1.length(); i++) {
                    //System.out.println("次数："+(i+1));
                    JSONObject j11 = j1.getJSONObject(String.valueOf(i + 1));
                    result += "结果" + (i + 1) + "\n";
                    result += "姓名：" + j11.getString("name") + "\n";
                    result += "学院：" + j11.getString("yx") + "\n";
                    result += "电话号码：" + j11.getString("phone") + "\n";
                    result += "办公室号码：" + j11.getString("officePhone") + "\n";
                    temp = j11.getString("weibo");
                    if (!temp.equals("null"))
                        result += "微博：" + temp + "\n";
                    temp = j11.getString("weixin");
                    if (!temp.equals("null"))
                        result += "微信：" + temp + "\n";
            /*System.out.println(j11.getString("name"));
            System.out.println(j11.getString("yx"));
            System.out.println(j11.getString("officePhone"));
            System.out.println(j11.getString("weibo"));
            System.out.println(j11.getString("wetString("phone"));
            System.out.println(j11.geixin"));*/
                }
                break;
        }
        System.out.println("result"+result);
        return result;
    }

    //找学生
    public static String getStuRequest(Context context, String name) throws IOException, JSONException {
        String result = "";
        switch (name){
            case "陈紫欣":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名：陈紫欣\n" +
                        "性别：女\n" +
                        "院系：外国语学院\n" +
                        "班级：英语1404\n" +
                        "电话号码：147****3552\n" +
                        "籍贯：广东";
                break;
            case "康天楠":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:康天楠\n" +
                        "性别:男\n" +
                        "院系:信息科学与工程学院\n" +
                        "班级:计算机1504\n" +
                        "电话号码:137****3476\n" +
                        "籍贯:浙江省";
                break;
            case "李凯风":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:李凯风\n" +
                        "性别:男\n" +
                        "院系:信息科学与工程学院\n" +
                        "班级:测控1501\n" +
                        "电话号码:无\n" +
                        "籍贯:江苏省";
                break;
            case "于修彦":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:于修彦\n" +
                        "性别:男\n" +
                        "院系:信息科学与工程学院\n" +
                        "班级:计算机1504\n" +
                        "电话号码:156****2686\n" +
                        "籍贯:河北省";
                break;
            case "罗熙康":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:罗熙康\n" +
                        "性别:男\n" +
                        "院系:湘雅医学院\n" +
                        "班级:精神1501\n" +
                        "电话号码:181****1003\n" +
                        "籍贯:湖北省";
                break;
            case "姬永涛":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:姬永涛\n" +
                        "性别:男\n" +
                        "院系:软件学院\n" +
                        "班级:工程试验班(软件)1503\n" +
                        "电话号码:156****8082\n" +
                        "籍贯:河南省";
                break;
            case "杨柳鑫":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:杨柳鑫\n" +
                        "性别:男\n" +
                        "院系:信息科学与工程学院\n" +
                        "班级:计算机1505\n" +
                        "电话号码:无\n" +
                        "籍贯:江西省";
                break;
            case "邓小兵":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "姓名:邓小兵\n" +
                        "性别:男\n" +
                        "院系:软件学院\n" +
                        "班级:工程试验班(软件)1506\n" +
                        "电话号码:无\n" +
                        "籍贯:湖北省";
                break;
            default:
                JSONObject j1 = getJsonResult(context, host + "?action=findStudent&name=" + name);
//        System.out.println(j1.length());
                result += "结果数:" + j1.length() + "\n";
                String temp;
                for (int i = 0; i < j1.length(); i++) {
//            System.out.println("次数："+(i+1));
                    JSONObject j11 = j1.getJSONObject(String.valueOf(i + 1));
                    result += "结果" + (i + 1) + "\n";
                    result += "姓名：" + j11.getString("name") + "\n";
                    result += "性别：" + j11.getString("sex") + "\n";
                    result += "学院：" + j11.getString("institue") + "\n";
                    result += "班级：" + j11.getString("class") + "\n";
                    temp = j11.getString("qq");
                    if (!temp.equals("null"))
                        result += "qq：" + temp + "\n";
                    result += "电话号码：" + j11.getString("phone") + "\n";
                    result += "籍贯：" + j11.getString("nativeplace") + "\n";
           /* System.out.println(j11.getString("name"));
            System.out.println(j11.getString("sex"));
            System.out.println(j11.getString("institue"));
            System.out.println(j11.getString("class"));
            System.out.println(j11.getString("qq"));
            System.out.println(j11.getString("phone"));
            System.out.println(j11.getString("nativeplace"));*/
                }
        }

        System.out.println("result"+result);
        return result;
    }

    //男女比例
    public static String getRatioRequest(Context context, String text, int type) throws IOException, JSONException {
        String result = "";
        switch (text){
            case "计科":
                result+="结果数:2\n" +
                        "结果1\n" +
                        "查询名：计算机科学与技术\n" +
                        "男生数目：335\n" +
                        "女生数目：138\n" +
                        "结果2\n" +
                        "查询名：信息与计算科学\n" +
                        "男生数目：119\n" +
                        "女生数目：61";
                break;
            case "计算机科学与技术":
                result+="结果数:1\n" +
                        "结果1\n" +
                        "查询名：计算机科学与技术\n" +
                        "男生数目：335\n" +
                        "女生数目：138\n";
                break;
            case "信息与计算科学":
                result+= "结果数:1\n" +"结果2\n" +
                        "查询名：信息与计算科学\n" +
                        "男生数目：119\n" +
                        "女生数目：61";
                break;
            case "英":
            case "英语":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "查询名：英语\n" +
                        "男生数目：93\n" +
                        "女生数目：361";
                break;
            case "软件学院":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "查询名：软件学院\n" +
                        "男生数目：401\n" +
                        "女生数目：148";
                break;
            case "湘雅医学院":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "查询名：湘雅医学院\n" +
                        "男生数目：694\n" +
                        "女生数目：852";
                break;
            case "法学院":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "查询名：法学院\n" +
                        "男生数目：145\n" +
                        "女生数目：309";
                break;
            case "机电工程学院":
            case "机电":
                result+="结果数:1\n" +
                        "结果:1\n" +
                        "查询名：机电\n" +
                        "男生数目：1419\n" +
                        "女生数目：170";
                break;
            default:
                JSONObject j1 = getJsonResult(context, host + "?action=percent&text=" + text + "&type=" + type);
//        System.out.println(j1.length());
                result += "结果数:" + j1.length() + "\n";
                for (int i = 0; i < j1.length(); i++) {
//            System.out.println("次数："+(i+1));
                    JSONObject j11 = j1.getJSONObject(String.valueOf(i + 1));
                    result += "结果" + (i + 1) + "\n";
                    result += "查询名：" + j11.getString("search") + "\n";
                    result += "男生数目：" + j11.getString("boys") + "\n";
                    result += "女生数目：" + j11.getString("girls") + "\n";
           /* System.out.println(j11.getString("search"));
            System.out.println(j11.getString("boys"));
            System.out.println(j11.getString("girls"));*/
                }
        }

        System.out.println("result"+result);
        return result;
    }
}
