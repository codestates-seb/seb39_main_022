package main.wheelmaster.wheelcenter.utils;

import static java.lang.Math.*;

public abstract class WheelCenterUtils {

    private static final double RADIUS = 6371.0088; // 지구의 반지름

    public static double harversineDistance(double srcLatitude, double srcLongitude, double destLatitude, double destLongitude){

        // 위도와 경도의 차이
        double deltaLat = toRadians(srcLatitude - destLatitude);
        double deltaLon = toRadians(srcLongitude - destLongitude);

        double apply = pow(sin(deltaLat/2), 2) + pow(sin(deltaLon/2),2) * cos(srcLatitude) * cos(destLatitude);

        return RADIUS * 2 * asin(sqrt(apply));

    }
}
