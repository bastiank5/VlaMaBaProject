package UtilityPackage;

import java.util.Random;

public class StaticMethods {

    public static Random R = new Random();
    public static long start;
    public static int ProgressLäufer = 0;
    public static boolean Timerstatus = false;

    public static int wuerfleImIntervall(int pMin, int pMax) {
        if (pMin > pMax || pMax == 0) {
            throw new IllegalArgumentException("Minimum cannot be greater than the Maximum, Min: " + pMin + " | Max: " + pMax);
        } else {
            return R.nextInt(pMax - pMin) + pMin;
        }
    }

    public static boolean isNull(Object pOb) {
        return pOb == null;
    }

    public static void validateNotNegativ(double x, String name) {
        if (x < 0) {
            System.out.println(name + " ist negativ");
        }
    }

    public static void Stopwatch_start() {
        start = System.currentTimeMillis();
        Timerstatus = true;
    }

    public static double Stopwatch_elapsedTime() {
        double sek_ms = 1000.0;
        long now = System.currentTimeMillis();
        Timerstatus = false;
        return (now - start) / sek_ms;
    }
}
