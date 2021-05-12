package com.draftOfClasses;

import java.util.ArrayList;

public class LoC {
    private ArrayList<Class> listOfClass = new ArrayList<Class>();
    private int index=0;

    public void addClass (Class c)
    {
        listOfClass.add(c);
    }

    public void subClass (Class c)
    {
        listOfClass.remove(c);
    }

    public Object findClass(String n)
    {
        for (Class ofClass : listOfClass) {
            if (ofClass.getClassName().equals(n))
                return ofClass;
        }
        return null;
    }

    public void reset()
    {
        listOfClass.clear();
    }

    public Class next()
    {
        return (index==listOfClass.size())? null : listOfClass.get(index);
    }

    public boolean hasNext()
    {
        return index<listOfClass.size();
    }



}
