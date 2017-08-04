package com.example.model;

public class DrillDownData
{
    private String id;

    private String name;

    private Object[][] data;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Object[][] getData ()
    {
        return data;
    }

    public void setData (Object[][] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name = "+name+", data = "+data+"]";
    }
}
