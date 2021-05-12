package com.draftOfClasses;

public class Class {
    private int classNo;
    private String className;

    public Class(int num, String name)
    {
        classNo = num;
        className = name;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
