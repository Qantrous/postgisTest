package com.example.postgistest.GeometryTools.JTSGeometryConverter.Converters;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolygonJTSGeometryConverter implements JTSGeometryConverterInterface {

    private final int SRID = 4326;

    private String GEOMETRY_TYPE_NAME = "Polygon";

    @Override
    public com.example.postgistest.GeometryTools.Geometry convert(Geometry jtsGeometry) {
        com.example.postgistest.GeometryTools.Geometry geometry = new com.example.postgistest.GeometryTools.Geometry();
        geometry.setType(GEOMETRY_TYPE_NAME);
        Coordinate[] ordinates = jtsGeometry.getCoordinates();
        ArrayList<Object> convertedOrdinatesList = new ArrayList<>();
        for (int i = 0; i < ordinates.length; i++) {
            ArrayList<Double> cur = new ArrayList<>();
            cur.add(ordinates[i].x);
            cur.add(ordinates[i].y);
            convertedOrdinatesList.add(cur);
        }
        Collections.reverse(convertedOrdinatesList);
        ArrayList<Object> geometryCoordinates = new ArrayList<>();
        geometryCoordinates.add(convertedOrdinatesList);
        geometry.setCoordinates(geometryCoordinates);

        return geometry;
    }

    @Override
    public Geometry convert(com.example.postgistest.GeometryTools.Geometry jtsGeometry) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), SRID);
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (List coordinate : (List<List<Object>>)jtsGeometry.getCoordinates().get(0)) {
            double x;
            try {
                 x = (double) coordinate.get(0);
            } catch (Exception e){
                Integer intTest = (Integer) coordinate.get(0);
                x = intTest.doubleValue();
            }
            double y;
            try {
                y = (double) coordinate.get(1);
            } catch (Exception e){
                Integer intTest = (Integer) coordinate.get(1);
                y = intTest.doubleValue();
            }
            coordinates.add(new Coordinate(x, y));
        }
        CoordinateSequence coordinateSequence = new CoordinateArraySequence(coordinates.toArray(new Coordinate[coordinates.size()]));
        LinearRing linearRing = geometryFactory.createLinearRing(coordinateSequence);
        Geometry result = new Polygon(linearRing, null, geometryFactory);
        return result;
    }
}
