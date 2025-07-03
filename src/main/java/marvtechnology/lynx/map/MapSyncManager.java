package marvtechnology.lynx.map;

import marvtechnology.lynx.country.Country;
import marvtechnology.lynx.country.CountryManager;
import org.bukkit.Location;
import xyz.jpenilla.squaremap.api.BukkitAdapter;
import xyz.jpenilla.squaremap.api.Key;
import xyz.jpenilla.squaremap.api.MapWorld;
import xyz.jpenilla.squaremap.api.Point;
import xyz.jpenilla.squaremap.api.SimpleLayerProvider;
import xyz.jpenilla.squaremap.api.Squaremap;
import xyz.jpenilla.squaremap.api.SquaremapProvider;
import xyz.jpenilla.squaremap.api.marker.Icon;
import xyz.jpenilla.squaremap.api.marker.Marker;
import xyz.jpenilla.squaremap.api.marker.MarkerOptions;
import xyz.jpenilla.squaremap.api.marker.Polygon;

import java.awt.Color;

public class MapSyncManager {
    private final CountryManager countryManager;
    private SimpleLayerProvider layer;

    public MapSyncManager(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    private void ensureLayer() {
        if (layer != null) return;
        Squaremap squaremap = SquaremapProvider.get();
        for (MapWorld world : squaremap.mapWorlds()) {
            layer = SimpleLayerProvider.builder("Lynx Countries").build();
            world.layerRegistry().register(Key.of("lynx-countries"), layer);
        }
    }

    public void sync() {
        ensureLayer();
        layer.clearMarkers();
        for (Country country : countryManager.getCountries()) {
            Location loc = country.getCapital().getLocation();
            Point center = BukkitAdapter.point(loc);
            double size = 10.0; // placeholder territory
            Polygon poly = Marker.polygon(
                    Point.point(center.x() - size, center.z() - size),
                    Point.point(center.x() + size, center.z() - size),
                    Point.point(center.x() + size, center.z() + size),
                    Point.point(center.x() - size, center.z() + size)
            );
            Color c = country.getColor();
            poly.markerOptions(MarkerOptions.builder()
                    .strokeColor(c)
                    .fillColor(c)
                    .fillOpacity(0.5)
                    .build());
            layer.addMarker(Key.of(country.getId().toString()), poly);

            Icon icon = new Icon(center, center, center, Key.of("default_star"), 16, 16);
            icon.markerOptions(MarkerOptions.builder().strokeColor(c).build());
            layer.addMarker(Key.of(country.getId().toString() + "-cap"), icon);
        }

public class MapSyncManager {
    public void sync() {
        // Placeholder for Squaremap sync

    }
}
