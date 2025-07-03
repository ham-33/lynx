package marvtechnology.lynx.country;

import java.awt.Color;
import java.util.UUID;

public class Country {
    private final UUID id;
    private final String name;
    private final Capital capital;
    private final Color color;

    public Country(UUID id, String name, Capital capital, Color color) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.color = color;
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

    public Color getColor() {
        return color;
    }
}
