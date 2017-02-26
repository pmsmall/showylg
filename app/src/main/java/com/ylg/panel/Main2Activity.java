package com.ylg.panel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        String result = " 云麓谷工作室，成立于2013年，前身是2000年成立的中国大学生勤工助学在线，是中南大学网络文化服务中心的重要组成部分，隶属于中南大学学生工作部（处）。奉行“技术中成长，服务中育人”的理念，多年来创作了一批批“富有特色、导向正确、影响深远”的网络文化微产品，服务师生。其中，由我们提供技术支持的辅导员技能大赛系统，在湖南省高校广泛使用，有利于湖南省辅导员素质的提升。另外，云麓谷服务号作为中南大学唯一的信息服务型多功能综合性微信号，兼具娱乐性、实用性、互动性于一体，目前拥有粉丝量15000余人 ，举办的“最美辅导员”活动，信息接收量达693912。查空教室，四六级成绩，计算机成绩，找人等多种快捷的功能广受学生欢迎，最近的一次四六级查询，一天内的查询量就达到77977次。通过交互型微产品，云麓工作室宣传网络德育，加强校园网络文明的构建力量，唱响网络思想文化主旋律。";
        String result = "云麓谷工作室，前身是2000年成立的中国大学生勤工助学在线，是中南大学网络文化服务中心的重要组成部分，隶属于校党委学生工作部（处）。\n" +
                "习近平总书记在全国高校思想政治工作会议上强调：要运用新媒体新技术使工作活起来，推动思想政治工作传统优势同信息技术高度融合，增强时代感和吸引力。为此，工作室秉持“技术中成长，服务中育人”的理念。\n" +
                "在“技术服务”方面，平台创作了一大批“富有特色、导向正确、影响深远”的网络文化微产品。其中，由我们技术开发的辅导员技能大赛系统，在湖南省高校广泛使用；另外，云麓谷服务号作为学校唯一的信息服务型多功能综合性微信号，兼具娱乐性、实用性、互动性于一体，目前拥有粉丝量15000余人 ，举办的“最美辅导员”活动，信息接收量达693912次。查空教室，查四六级成绩、计算机成绩，找同学、找老师等多种便捷的功能广受师生欢迎，最近的一次四六级成绩查询，一天内的查询量就达到77977次。多年来为一大批优秀学生提供了锻炼成长的平台，从我们这里走出去的毕业生大多进入五百强等知名企业。\n" +
                "在\"服务育人\"方面，云麓谷微信公众号从学生工作的角度传播正能量，去年推出的张尧学校长在新生开学典礼、毕业典礼上的讲话、长征主题系列推送等广受关注；云麓谷微博积极运用当前受众较广的直播技术，对学校重大思政活动、会议等进行网络高清直播，广受学生、家长、和社会欢迎；云麓园BBS论坛是当前国内排名靠前的校内社区论坛，共计有注册会员14.5万人，发帖总数达176万余个，云麓园BBS微信公众号定期推送学生喜闻乐见的文化产品，引领积极向上的校园生活方式。\n" +
                "云麓谷工作室坚持从技术和服务两方面共同交织加强校园网络文明建设，形成了一个立体的网络思想政治教育阵地，唱响校园网络思想文化主旋律。";
        TextView t =(TextView)findViewById(R.id.textView2);
        t.setText(result);
    }
}