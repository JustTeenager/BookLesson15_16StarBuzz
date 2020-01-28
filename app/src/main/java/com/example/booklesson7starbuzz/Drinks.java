package com.example.booklesson7starbuzz;

public class Drinks {
    private String name;
    private String description;
    private int imageResourceId;
    private Drinks(String name,String description,int ResourceId){
        this.name=name;
        this.description=description;
        this.imageResourceId=ResourceId;
    }
    public String GetName(){
        return name;
    }
    public String Getdescription() {
        return description;
    }
    public int GetImageId(){
        return imageResourceId;
    }
    public String toString(){
        return this.name;
    }
    public static final Drinks [] drinks ={
            new Drinks("Latte","A couple of espresso shots with steamed milk",R.drawable.latte),
            new Drinks("Cappuccino","Espresso,hot milk and a steamed milk foam",R.drawable.cappuccino),
            new Drinks("Filter","Highest quality beans roasted and brewed flash",R.drawable.filter)
    };
}
