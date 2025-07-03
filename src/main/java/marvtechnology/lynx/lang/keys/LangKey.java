package marvtechnology.lynx.lang.keys;

/**
 * Enumeration of language message keys used by the plugin.
 */
public enum LangKey {
    GENERIC_NO_PERMISSION,
    GENERIC_PLAYER_ONLY,
    GENERIC_CONSOLE_ONLY;

    public String path() {
        return name().toLowerCase().replace('_', '-');
    }
}
