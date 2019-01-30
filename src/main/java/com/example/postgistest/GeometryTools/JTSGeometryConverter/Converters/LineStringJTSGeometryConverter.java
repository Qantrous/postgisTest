package com.example.postgistest.GeometryTools.JTSGeometryConverter.Converters;


import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

import java.util.ArrayList;

public class LineStringJTSGeometryConverter implements JTSGeometryConverterInterface {

    private final int SRID = 4326;
    private String GEOMETRY_TYPE_NAME = "LineString";

    @Override
    public Geometry convert(com.example.postgistest.GeometryTools.Geometry naprGeometry) {

        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (Object coordinate : naprGeometry.getCoordinates()) {
            Double x = ((ArrayList<Double>) coordinate).get(0);
            Double y = ((ArrayList<Double>) coordinate).get(1);
            coordinates.add(new Coordinate(x, y));
        }
        CoordinateSequence coordinateSequence = new CoordinateArraySequence(coordinates.toArray(new Coordinate[coordinates.size()]));
        return new LineString(coordinateSequence, new GeometryFactory(new PrecisionModel(), SRID));
    }

    public com.example.postgistest.GeometryTools.Geometry convert(Geometry jtsGeometry) {
        com.example.postgistest.GeometryTools.Geometry geometry = new com.example.postgistest.GeometryTools.Geometry();
        geometry.setType(GEOMETRY_TYPE_NAME);
        Coordinate[] coordinates = jtsGeometry.getCoordinates();
        ArrayList<Object> convertedOrdinatesList = new ArrayList<>();
        for (int i = 0; i < coordinates.length; i++) {
            ArrayList<Double> cur = new ArrayList<>();
            cur.add(coordinates[i].x);
            cur.add(coordinates[i].y);
            convertedOrdinatesList.add(cur);
        }

        geometry.setCoordinates(convertedOrdinatesList);

        return geometry;
    }
}
