package com.example.model;

import java.util.List;

public class Chartpojo {

	 private String name;

	    private List<Integer> data;

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

//	    public String[] getData ()
//	    {
//	        return data;
//	    }
//
//	    public void setData (String[] data)
//	    {
//	        this.data = data;
//	    }
	    
	    

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [name = "+name+", data = "+data+"]";
	    }

		public List<Integer> getData() {
			return data;
		}

		public void setData(List<Integer> data) {
			this.data = data;
		}
	}
				
