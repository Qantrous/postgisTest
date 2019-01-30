package com.example.postgistest.GeometryTools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FeatureCollection {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type = "FeatureCollection";

    private List<Feature> features = new ArrayList<Feature>();

    public List<Feature> getFeatures() {
        return features;
    }

    public FeatureCollection(List<Feature> features){
        this.features = features;
    }

    public FeatureCollection() {
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void add(Feature feature){
        this.features.add(feature);
    }

    public void addAll(Collection<Feature> features){
        this.features.addAll(features);
    }

}
