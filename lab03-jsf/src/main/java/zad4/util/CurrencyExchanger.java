package zad4.util;

import java.util.HashMap;

public class CurrencyExchanger
{
    private static HashMap<String, Double> currencies = new HashMap<String, Double>()
    {
        {
            put("PLN", 1.0);
            put("EUR", 4.3);
            put("USD", 3.7);
        }
    };

    public static double changeToPLN(String currency, double number)
    {
        return Math.round(currencies.get(currency) * number * 100.0) / 100.0;
    }
}
