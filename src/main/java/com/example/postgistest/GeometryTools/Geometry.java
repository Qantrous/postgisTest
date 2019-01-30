package com.example.postgistest.GeometryTools;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Geometry {

    @NotNull
    private String type;

    @NotNull
    private List<Object> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Object> coordinates) {
        this.coordinates = coordinates;
    }
}