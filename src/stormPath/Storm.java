package stormPath;

import java.util.ArrayList;

public class Storm {
	private String name;
	private ArrayList cities;
	private int year;

	public Storm(String name, int year) {
		this.name = name;
		this.year = year;
		this.cities = new ArrayList();
	}

	public String getName(){
		return this.name;}

    public int getYear(){
        return this.year;}
8
    public boolean equals(Storm s){
        if (this.name.equals(s.getName()))
            return true;
        return false;}

    public void addCity(City c){
        this.cities.add(c);
        if (!c.getStorms().contains(this))
            c.addStorm(this);
    }

    public ArrayList getCities(){
        return this.cities;
    }

    @Override
    public String toString(){
        String result = this.getName() + ", " + this.getYear() + System.lineSeparator();
        for (int i = 0; i < this.cities.size(); i++)
            result += (((City)this.cities.get(i)).getName() + System.lineSeparator());
        result = result.substring(0,result.length() - 1);
        return result;
    }
}
