package marvtechnology.lynx.country;

import java.util.UUID;

public class Request {
    private final UUID sender;
    private final UUID targetCountry;

    public Request(UUID sender, UUID targetCountry) {
        this.sender = sender;
        this.targetCountry = targetCountry;
    }

    public UUID getSender() {
        return sender;
    }

    public UUID getTargetCountry() {
        return targetCountry;
    }
}
