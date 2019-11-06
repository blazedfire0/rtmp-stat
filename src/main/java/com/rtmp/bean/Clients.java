package com.rtmp.bean;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 13:02
 * @描述 TODO
 */
@Getter
public class Clients extends SuperValue{
    private int id;
    private String address;
    private int time;
    private String flashver;
    private int dropped;
    private int avsync;
    private int timestamp;
    private int statue=0;
    private String type="playing";

    @Override
    public void setValue(String tagName,Object value){
        switch (tagName){
            case "id":id = (Integer.parseInt(String.valueOf(value)));break;
            case "address":address = String.valueOf(value);break;
            case "time":time = (Integer.parseInt(String.valueOf(value)));break;
            case "flashver":flashver = String.valueOf(value);break;
            case "dropped":dropped = (Integer.parseInt(String.valueOf(value)));break;
            case "avsync":avsync = (Integer.parseInt(String.valueOf(value)));break;
            case "timestamp":timestamp = (Integer.parseInt(String.valueOf(value)));break;
            case "publishing":type = "publishing";break;
            case "active":statue = 1;break;
            default:break;
        }
    }

    public static void main(String[] args) {
        double t = (double) 5/3;
        double t2 = (double) 7/3;
        System.out.println(t);
        System.out.println(t2);
        System.out.println();
        BigDecimal a = new BigDecimal(5).divide(new BigDecimal(3),2,BigDecimal.ROUND_DOWN);
        BigDecimal b = new BigDecimal(7).divide(new BigDecimal(3),2,BigDecimal.ROUND_DOWN);
        System.out.println(a.doubleValue());
        System.out.println(b.doubleValue());
    }
}
