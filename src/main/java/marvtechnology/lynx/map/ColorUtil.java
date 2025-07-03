package marvtechnology.lynx.map;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public final class ColorUtil {
    private ColorUtil() {}

    public static String randomHex() {
        float h = ThreadLocalRandom.current().nextFloat();
        int rgb = Color.HSBtoRGB(h, 0.8f, 0.9f);
        return String.format("#%06X", 0xFFFFFF & rgb);
    }

    public static Color fromHex(String hex) {
        return Color.decode(hex);
    }

    /**
     * Lighten the given color by the supplied fraction.
     *
     * @param color   Base color
     * @param fraction Amount to lighten (0-1)
     * @return Lightened color
     */
    public static Color lighten(Color color, float fraction) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        r += Math.round((255 - r) * fraction);
        g += Math.round((255 - g) * fraction);
        b += Math.round((255 - b) * fraction);
        return new Color(r, g, b, color.getAlpha());
    }
}
