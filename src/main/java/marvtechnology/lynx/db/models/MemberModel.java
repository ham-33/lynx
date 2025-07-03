package marvtechnology.lynx.db.models;

import java.util.UUID;

public class MemberModel {
    private UUID playerId;
    private UUID countryId;

    public UUID getPlayerId() { return playerId; }
    public void setPlayerId(UUID playerId) { this.playerId = playerId; }
    public UUID getCountryId() { return countryId; }
    public void setCountryId(UUID countryId) { this.countryId = countryId; }
}
