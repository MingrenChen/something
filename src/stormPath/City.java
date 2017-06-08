package stormPath;

import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList storms;

	public City(String name) {
		this.name = name;
		this.storms = new ArrayList();}

	public boolean wasHit(Storm s) {
	    if (this.storms.contains(s))
	        return true;
        else
            return false;
        }

    public boolean onSamePath(City c) {
        for (int i = 0; i < this.storms.size(); i++)
            if (c.getStorms().contains(((Storm)this.storms.get(i))))
                return true;
        return false;
    }

    public ArrayList getStorms(){
	    return this.storms;
    }

    public void addStorm(Storm s) {
	    this.storms.add(s);
        if (!s.getCities().contains(this))
            s.addCity(this);
    }


    public boolean equals(City c){
	    if (!this.name.equals(c.getName()))
	        return false;
        if (this.storms.size() != (c.getStorms().size()))
            return false;
        for (int i = 0; i < this.storms.size(); i++)
            if (!this.storms.contains((Storm)c.getStorms().get(i)))
                return false;
        return true;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        String result = this.getName() + " (";
        if (this.storms.isEmpty())
            return (result + ")");
        for (int i = 0; i < this.storms.size(); i++)
            result += (((Storm)this.storms.get(i)).getName() + ", ");
        result = result.substring(0,result.length() - 2);
        //System.out.println(result);
        result += ")";
        return result;
    }
}


