package marvtechnology.lynx.country;

import java.awt.Color;

import marvtechnology.lynx.map.ColorUtil;
import java.util.UUID;

public class Country {
    private final UUID id;
    private final String name;
    private final Capital capital;
    private final String colorHex;

    public Country(UUID id, String name, Capital capital, String colorHex) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.colorHex = colorHex;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Capital getCapital() {
        return capital;
    }

    public String getColorHex() {
        return colorHex;
    }

    public Color getColor() {
        return ColorUtil.fromHex(colorHex);
    }
}
