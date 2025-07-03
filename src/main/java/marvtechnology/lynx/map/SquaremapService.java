package marvtechnology.lynx.map;

import xyz.jpenilla.squaremap.api.Squaremap;
import xyz.jpenilla.squaremap.api.SquaremapProvider;

/**
 * Provides access to Squaremap API.
 */
public class SquaremapService {
    public Squaremap get() {
        return SquaremapProvider.get();
    }
}
