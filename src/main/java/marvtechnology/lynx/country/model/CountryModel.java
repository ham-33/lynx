package marvtechnology.lynx.country.model;

import java.util.UUID;

/**
 * Basic data model for a country.
 */
public class CountryModel {
    private UUID id;
    private String name;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
