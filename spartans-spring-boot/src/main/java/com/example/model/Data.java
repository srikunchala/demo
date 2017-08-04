package com.example.model;

public class Data
{
    private String drilldown;

    private String name;

    private Integer y;

    public String getDrilldown ()
    {
        return drilldown;
    }

    public void setDrilldown (String drilldown)
    {
        this.drilldown = drilldown;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Integer getY ()
    {
        return y;
    }

    public void setY (Integer y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [drilldown = "+drilldown+", name = "+name+", y = "+y+"]";
    }
}
