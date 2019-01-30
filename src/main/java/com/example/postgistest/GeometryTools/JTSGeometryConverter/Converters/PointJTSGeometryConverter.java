package com.example.postgistest.GeometryTools.JTSGeometryConverter.Converters;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

import java.util.ArrayList;
import java.util.List;

public class PointJTSGeometryConverter implements JTSGeometryConverterInterface {

    private final int SRID = 4326;
    private String GEOMETRY_TYPE_NAME = "Point";

    @Override
    public Geometry convert(com.example.postgistest.GeometryTools.Geometry geometry) {
        List<Coordinate> coordinates = new ArrayList<>();
        double x = Double.parseDouble(geometry.getCoordinates().get(0).toString());
        double y = Double.parseDouble(geometry.getCoordinates().get(1).toString());
        coordinates.add(new Coordinate(x,y));
        CoordinateSequence coordinateSequence = new CoordinateArraySequence(coordinates.toArray(new Coordinate[coordinates.size()]));
        return new Point(coordinateSequence, new GeometryFactory(new PrecisionModel(), SRID));
    }

    public com.example.postgistest.GeometryTools.Geometry convert(Geometry jtsGeometry) {
        com.example.postgistest.GeometryTools.Geometry geometry = new com.example.postgistest.GeometryTools.Geometry();
        geometry.setType(GEOMETRY_TYPE_NAME);
        Coordinate coordinate = jtsGeometry.getCoordinate();
        ArrayList<Object> convertedList = new ArrayList<>();
        convertedList.add(coordinate.x);
        convertedList.add(coordinate.y);
        geometry.setCoordinates(convertedList);
        return geometry;
    }
}
