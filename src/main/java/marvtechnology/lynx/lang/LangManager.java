package marvtechnology.lynx.lang;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangManager {
    private ResourceBundle bundle;

    public void load(Locale locale) {
        bundle = ResourceBundle.getBundle("languages/messages", locale);
    }

    public String get(String key) {
        return bundle != null ? bundle.getString(key) : key;
    }
}
