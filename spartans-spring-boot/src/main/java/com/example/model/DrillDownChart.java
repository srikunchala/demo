package com.example.model;

import java.util.List;

public class DrillDownChart
{
    private String name;

    private Data[] data;
    private List<DrillDownData> drill;

    private boolean colorByPoint;
    
	public List<DrillDownData> getDrill() {
		return drill;
	}

	public void setDrill(List<DrillDownData> drill) {
		this.drill = drill;
	}

	public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public boolean getColorByPoint ()
    {
        return colorByPoint;
    }

    public void setColorByPoint (boolean colorByPoint)
    {
        this.colorByPoint = colorByPoint;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", data = "+data+", colorByPoint = "+colorByPoint+"]";
    }
}
	