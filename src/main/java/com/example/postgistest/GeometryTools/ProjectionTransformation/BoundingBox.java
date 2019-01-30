package com.example.postgistest.GeometryTools.ProjectionTransformation;

public class BoundingBox {

    double north;
    double south;
    double east;
    double west;

    @Override
    public String toString() {
        return "BoundingBox{" +
                "north=" + north +
                ", south=" + south +
                ", east=" + east +
                ", west=" + west +
                '}';
    }
}
