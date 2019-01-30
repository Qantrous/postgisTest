package com.example.postgistest.GeometryTools.JTSGeometryConverter.Converters;


import com.example.postgistest.GeometryTools.Geometry;

public interface JTSGeometryConverterInterface {

    com.vividsolutions.jts.geom.Geometry convert(Geometry geometry);

    Geometry convert(com.vividsolutions.jts.geom.Geometry jGeometry);

}
