package com.ylg.panel.js.tools;

/**
 * Created by 天楠 on 2016/11/26.
 */

public class Paramer {
    public static final float orign_bitmap_width = 4406;
    public static final float orign_bitmap_height = 2480;
    public static final float oralCenterX = 1440;
    public static final float oralCenterY = 1254;
    public static final float r = 1246;
    public static final float godCenterX = 1074.5f, godCenterY = 673;
    public static final float gradeCenterX = 1347, gradeCenterY = 562.5f;
    public static final float allCenterX = 1628, allCenterY = 585.5f;
    public static final float girlCenterX = 1867, girlCenterY = 710.5f;
    public static final float teacherCenterX = 2041, teacherCenterY = 907;
    public static final float with = 1439 - 1203, height = 678 - 441;
    public static final double degree = Math.atan(with / 2 / Math.sqrt(Math.pow((gradeCenterX - oralCenterX), 2) + Math.pow((gradeCenterY - oralCenterY), 2)));

    public static final float yellowX = 661, yellowY = 1680;
    public static final float schoolX = 582, schoolY = 1434;
    public static final float inX = 558.5f, inY = 1167.5f;
    public static final float carX = 626, carY = 917.5f;
    public static final float laoxiangX = 763, laoxiangY = 685.5f;

    public static final float talkX = 1688, talkY = 2117.5f;
    public static final float gameX = 1419.5f, gameY = 2149.5f;
    public static final float daohangX = 1150, daohangY = 2093.5f;
    public static final float repairX = 912.5f, repairY = 1962.5f;

    public static final float[] fudaoyuan = {2109, 1030, 3082, 1248};
    public static final float[] xinlijiankang = {2121, 1279, 2988, 1492};
    public static final float[] jianxingwang = {2037, 1531, 3501, 1739};
    public static final float[] yingping = {3027, 1734, 3797, 1947};
    public static final float[] yuqing = {2907, 1981, 3673, 2167};
    public static final float[] peixun = {2709, 2232, 3819, 2401};
    public static final float[][] web = {fudaoyuan, xinlijiankang, jianxingwang, yingping, yuqing, peixun};


    /**
     * 利用向量法，两个向量做叉乘获取sin值，然后计算角度
     *
     * @param centerX 标准点x坐标
     * @param centerY 标准点y坐标
     * @param x       目标x坐标
     * @param y       目标y坐标
     * @return 匹配成功返回true
     */
    public static boolean isIn(float centerX, float centerY, float x, float y) {
        float dx1 = centerX - oralCenterX;
        float dy1 = centerY - oralCenterY;
        float dx2 = x - oralCenterX;
        float dy2 = y - oralCenterY;
        double l1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
        double l2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        float dx3 = centerX - x;
        float dy3 = centerY - y;
        double l3 = Math.sqrt(dx3 * dx3 + dy3 * dy3);
        double degree1 = Math.acos((l1 * l1 + l2 * l2 - l3 * l3) / (2 * l1 * l2));
        double d = Math.abs(dx1 * dy2 - dx2 * dy1) / l1;
        return (with / 2 >= d && degree1 > 0 || (centerX == x && centerY == y)) && (l1 + with / 2 >= l2 && l1 - with / 2 <= l2);
    }

    public static boolean inGod(float x, float y) {
//        Log.d("inGod","inGod");
        return isIn(godCenterX, godCenterY, x, y);
    }

    public static boolean inGrade(float x, float y) {
//        Log.d("inGrade","inGrade");
        return isIn(gradeCenterX, gradeCenterY, x, y);
    }

    public static boolean inAll(float x, float y) {
//        Log.d("inAll","inAll");
        return isIn(allCenterX, allCenterY, x, y);
    }

    public static boolean inGirl(float x, float y) {
//        Log.d("inGirl","inGirl");
        return isIn(girlCenterX, girlCenterY, x, y);
    }

    public static boolean inTeacher(float x, float y) {
//        Log.d("inTeacher","inTeacher");
        return isIn(teacherCenterX, teacherCenterY, x, y);
    }

    public static boolean inYellow(float x, float y) {
//        Log.d("inGod","inGod");
        return isIn(yellowX, yellowY, x, y);
    }

    public static boolean inSchool(float x, float y) {
//        Log.d("inGrade","inGrade");
        return isIn(schoolX, schoolY, x, y);
    }

    public static boolean inIn(float x, float y) {
//        Log.d("inAll","inAll");
        return isIn(inX, inY, x, y);
    }

    public static boolean inCar(float x, float y) {
//        Log.d("inGirl","inGirl");
        return isIn(carX, carY, x, y);
    }

    public static boolean inLaoxiang(float x, float y) {
//        Log.d("inTeacher","inTeacher");
        return isIn(laoxiangX, laoxiangY, x, y);
    }

    public static boolean inTalk(float x, float y) {
//        Log.d("inGrade","inGrade");
        return isIn(talkX, talkY, x, y);
    }

    public static boolean inGame(float x, float y) {
//        Log.d("inAll","inAll");
        return isIn(gameX, gameY, x, y);
    }

    public static boolean inDaohang(float x, float y) {
//        Log.d("inGirl","inGirl");
        return isIn(daohangX, daohangY, x, y);
    }

    public static boolean inRepair(float x, float y) {
//        Log.d("inTeacher","inTeacher");
        return isIn(repairX, repairY, x, y);
    }

    public static boolean inWeb(int i, float x, float y) {
        return x >= web[i][0] && x <= web[i][2] && y >= web[i][1] && y <= web[i][3];
    }
}
