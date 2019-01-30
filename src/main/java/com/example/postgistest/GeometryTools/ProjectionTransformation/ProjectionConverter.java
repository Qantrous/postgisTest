
package com.example.postgistest.GeometryTools.ProjectionTransformation;

/**
 *
 * @author Administrator
 */
public class ProjectionConverter {
    
    private static final double rpi = 20037508.34;
    private static final double pi = 3.14159265358979;
    
    public static double googleX2Lon(double x){
        return ((rpi + x) / (2 * rpi)) * 360 - 180;
    }
            
    public static double googleY2Lat(double y){
        return Math.atan(Math.sinh(pi * (1 - ((rpi - y) / rpi)))) * 180 / pi;
    }


    public static BoundingBox tile2boundingBox(final int x, final int y, final int zoom) {
        BoundingBox bb = new BoundingBox();
        bb.north = tile2lat(y, zoom);
        bb.south = tile2lat(y + 1, zoom);
        bb.west = tile2lon(x, zoom);
        bb.east = tile2lon(x + 1, zoom);
        return bb;
    }

    static double tile2lon(int x, int z) {
        return x / Math.pow(2.0, z) * 360.0 - 180;
    }

    static double tile2lat(int y, int z) {
        double n = Math.PI - (2.0 * Math.PI * y) / Math.pow(2.0, z);
        return Math.toDegrees(Math.atan(Math.sinh(n)));
    }
}
