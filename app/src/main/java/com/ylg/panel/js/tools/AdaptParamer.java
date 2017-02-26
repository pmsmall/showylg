package com.ylg.panel.js.tools;

/**
 * Created by 天楠 on 2016/11/26.
 */

public class AdaptParamer {
    private float trueWidth;
    private float trueHeight;

    public AdaptParamer(float trueWidth, float trueHeight) {
        this.trueWidth = trueWidth;
        this.trueHeight = trueHeight;
    }

    public float getRelativeX(float x) {
        float n = Math.min(trueWidth / Paramer.orign_bitmap_width, trueHeight / Paramer.orign_bitmap_height);
        return (x > trueWidth / 2) ? ((x - trueWidth / 2) / n + Paramer.orign_bitmap_width / 2) : (Paramer.orign_bitmap_width / 2 - (trueWidth / 2 - x) / n);
    }

    public float getRelativeY(float y) {
        float n = Math.min(trueWidth / Paramer.orign_bitmap_width, trueHeight / Paramer.orign_bitmap_height);
        return (y > trueHeight / 2) ? ((y - trueHeight / 2) / n + Paramer.orign_bitmap_height / 2) : (Paramer.orign_bitmap_height / 2 - (trueHeight / 2 - y) / n);
    }

    public boolean inGod(float x, float y) {
        System.out.println("");
        return Paramer.inGod(getRelativeX(x), getRelativeY(y));
    }

    public boolean inGrade(float x, float y) {
        return Paramer.inGrade(getRelativeX(x), getRelativeY(y));
    }

    public boolean inAll(float x, float y) {
        return Paramer.inAll(getRelativeX(x), getRelativeY(y));
    }

    public boolean inGirl(float x, float y) {
        return Paramer.inGirl(getRelativeX(x), getRelativeY(y));
    }

    public boolean inTeacher(float x, float y) {
        return Paramer.inTeacher(getRelativeX(x), getRelativeY(y));
    }

    public boolean inYellow(float x, float y) {
//        Log.d("inGod","inGod");
        return Paramer.inYellow(getRelativeX(x), getRelativeY(y));
    }

    public boolean inSchool(float x, float y) {
//        Log.d("inGrade","inGrade");
        return Paramer.inSchool(getRelativeX(x), getRelativeY(y));
    }

    public boolean inIn(float x, float y) {
//        Log.d("inAll","inAll");
        return Paramer.inIn(getRelativeX(x), getRelativeY(y));
    }

    public boolean inCar(float x, float y) {
//        Log.d("inGirl","inGirl");
        return Paramer.inCar(getRelativeX(x), getRelativeY(y));
    }

    public boolean inLaoxiang(float x, float y) {
//        Log.d("inTeacher","inTeacher");
        return Paramer.inLaoxiang(getRelativeX(x), getRelativeY(y));
    }

    public boolean inTalk(float x, float y) {
//        Log.d("inGrade","inGrade");
        return Paramer.inTalk(getRelativeX(x), getRelativeY(y));
    }

    public boolean inGame(float x, float y) {
//        Log.d("inAll","inAll");
        return Paramer.inGame(getRelativeX(x), getRelativeY(y));
    }

    public boolean inDaohang(float x, float y) {
//        Log.d("inGirl","inGirl");
        return Paramer.inDaohang(getRelativeX(x), getRelativeY(y));
    }

    public boolean inRepair(float x, float y) {
//        Log.d("inTeacher","inTeacher");
        return Paramer.inRepair(getRelativeX(x), getRelativeY(y));
    }

    public boolean inWeb(int i, float x, float y) {
        return Paramer.inWeb(i, getRelativeX(x), getRelativeY(y));
    }
}
