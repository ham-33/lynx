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
}
