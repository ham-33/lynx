package marvtechnology.lynx.db.models;

import java.util.UUID;

public class CountryModel {
    private UUID id;
    private String name;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
