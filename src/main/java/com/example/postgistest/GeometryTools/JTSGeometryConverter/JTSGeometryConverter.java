package com.example.postgistest.GeometryTools.JTSGeometryConverter;


import com.example.postgistest.GeometryTools.Geometry;
import com.example.postgistest.GeometryTools.JTSGeometryConverter.Converters.JTSGeometryConverterFactory;

public class JTSGeometryConverter {


    public static com.vividsolutions.jts.geom.Geometry convert(Geometry geometry) {
        try {
            return new JTSGeometryConverterFactory().getGeometryConverter(geometry).convert(geometry);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Geometry convert(com.vividsolutions.jts.geom.Geometry jtsGeometry) {
        try {
            return new JTSGeometryConverterFactory().getGeometryConverter(jtsGeometry).convert(jtsGeometry);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }


}
