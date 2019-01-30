package com.example.postgistest.GeometryTools.JTSGeometryConverter.Converters;

import com.example.postgistest.GeometryTools.Geometry;

public class JTSGeometryConverterFactory {

    public JTSGeometryConverterInterface getGeometryConverter(com.example.postgistest.GeometryTools.Geometry geometry){
        String geometryType = geometry.getType();
        return getJtsGeometryConverterInterface(geometryType);
    }


    public JTSGeometryConverterInterface getGeometryConverter(com.vividsolutions.jts.geom.Geometry jtsGeometry){
        String geometryType = jtsGeometry.getGeometryType();
        return getJtsGeometryConverterInterface(geometryType);
    }

    private JTSGeometryConverterInterface getJtsGeometryConverterInterface(String geometryType) {
        if (geometryType.equals("Polygon"))
            return new PolygonJTSGeometryConverter();
        else if(geometryType.equals("Point"))
            return new PointJTSGeometryConverter();
        else if(geometryType.equals("Line") || geometryType.equals("LineString"))
            return new LineStringJTSGeometryConverter();

        return null;
    }

}
