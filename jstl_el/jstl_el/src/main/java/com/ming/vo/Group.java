package com.ming.vo;

public class Group {

    private String gName;

    public Group(){

    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "gName='" + gName + '\'' +
                '}';
    }
}
