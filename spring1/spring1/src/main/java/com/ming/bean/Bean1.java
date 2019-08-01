package com.ming.bean;

import java.util.*;

public class Bean1 {
    //测试普通属性的注入
    private int intValue;

    private String strValue;

    private List listValue;

    private Map mapValue;

    private Set setValue;

    private String [] arrayStr;

    private Date date;



    //默认的构造方法(yes Or no?)
    public Bean1(){

    }

    //DI


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public List getListValue() {
        return listValue;
    }

    public void setListValue(List listValue) {
        this.listValue = listValue;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    public Set getSetValue() {
        return setValue;
    }

    public void setSetValue(Set setValue) {
        this.setValue = setValue;
    }

    public String[] getArrayStr() {
        return arrayStr;
    }

    public void setArrayStr(String[] arrayStr) {
        this.arrayStr = arrayStr;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "intValue=" + intValue +
                ", strValue='" + strValue + '\'' +
                ", listValue=" + listValue +
                ", mapValue=" + mapValue +
                ", setValue=" + setValue +
                ", arrayStr=" + Arrays.toString(arrayStr) +
                '}';
    }
}
