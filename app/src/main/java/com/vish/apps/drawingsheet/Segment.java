package com.vish.apps.drawingsheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vish on 12/10/2016.
 */

public class Segment {
    private List<Points> points = new ArrayList<Points>();

    public Segment(){
    }

    public void addPoints(int x, int y){
        Points p = new Points(x, y);
        points.add(p);
    }

    public List<Points> getPoints(){
        return points;
    }
}
