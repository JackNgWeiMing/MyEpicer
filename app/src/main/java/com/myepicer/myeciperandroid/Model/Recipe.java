package com.myepicer.myeciperandroid.Model;

import com.myepicer.myeciperandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 15/6/2017.
 */

public class Recipe {

    private String name;
    private String level;
    private String time;
    private double cost;
    private int picture;

    public Recipe(String name, String level, String time, double cost) {
        this.name = name;
        this.level = level;
        this.time = time;
        this.cost = cost;
    }

    public Recipe(String name, String level, String time, double cost, int picture) {
        this(name, level,time,cost);
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getTime() {
        return time;
    }

    public double getCost() {
        return cost;
    }

    public int getPicture() {
        return picture;
    }

    public static Recipe getInstance(){
        return new Recipe("Transditinal Steamed Eggs","Beg","30min",10);
    }

    public static List<Recipe> getListInstance(){
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Transditinal Steamed Eggs","Beg","30min",10, R.drawable.chinese_steamed_egg));
        recipeList.add(new Recipe("Grandma Steamed Egg","Beg","30min",10,R.drawable.chinese_steamed_egg2));
        recipeList.add(new Recipe("Special garden steamed eggs","Beg","30min",10,R.drawable.tranditional_steamed_egg2));
        return recipeList;
    }
}
