package com.example.postgistest.GeometryTools;


import com.example.postgistest.GeometryTools.JTSGeometryConverter.JTSGeometryConverter;

import java.util.HashMap;
import java.util.Map;

public class Feature {

    public static final String PLACE_ID = "place_id";
    public static final String FILED_VALUE_PAIR = "field_value_pair";
    public static final String CREATOR_ID = "user_id";
    public static String CATEGORY_ID = "category_id";
    private String type = "Feature";
    private Geometry geometry;
    private Map<String, Object> properties = new HashMap<>();

    public Feature() {
    }

    public Feature(Geometry geometry, Map<String, Object> properties){
        this.geometry = geometry;
        this.properties = properties;
    }


    public Feature(com.vividsolutions.jts.geom.Geometry geometry, Map<String, Object> properties) {
        this(JTSGeometryConverter.convert(geometry), properties);
    }


    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void addProperty(String key, String value) {
        properties.put(key, value);
    }
}
