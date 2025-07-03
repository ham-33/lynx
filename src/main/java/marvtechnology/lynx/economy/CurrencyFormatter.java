package marvtechnology.lynx.economy;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Formats currency amounts.
 */
public class CurrencyFormatter {
    public static String format(double amount, Locale locale) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(amount);
    }
}
