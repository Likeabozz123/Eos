package xyz.gamars.eos.utils;

import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class MathUtils {

    public static float easeInOutCubic(float time) {
        return time < 0.5 ? 4 * time * time * time : (float) (1 - Math.pow(-2 * time + 2, 3) / 2);
    }

    public static Vector3f parametricSphere(float theta, float phi, float radius) {
        return new Vector3f(Mth.cos(theta) * Mth.sin(phi) * radius, Mth.cos(phi) * radius, Mth.sin(theta) * Mth.sin(phi) * radius);
    }

    public static Vector3f parametricCone(float radius, float theta, int height) {
        return new Vector3f(radius * Mth.cos(theta), height, radius * Mth.sin(theta));
    }

    public static Vector3f parametricCylinder(float radius, float theta, int height) {
        return new Vector3f(radius * Mth.cos(theta), height, radius * Mth.sin(theta));
    }

    public static Vector3f parametricTorus(float majorRadius, int minorRadius, float theta, float phi) {
        return new Vector3f(
                (majorRadius + (minorRadius * Mth.cos(theta))) * Mth.cos(phi),
                minorRadius * Mth.sin(theta),
                (majorRadius + (minorRadius * Mth.cos(theta))) * Mth.sin(phi)
        );
    }

}
