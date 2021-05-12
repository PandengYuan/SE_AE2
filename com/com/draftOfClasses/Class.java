package com.draftOfClasses;

public class Class {
    private int ClassNo;
    private String ClassName;

    public Class(int num, String name)
    {
        ClassNo = num;
        ClassName = name;
    }

    public int getClassNo() {
        return ClassNo;
    }

    public void setClassNo(int classNo) {
        ClassNo = classNo;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }
}
