package zad2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkspertPiwny
{

    private static HashMap<String, String> piwerka = new HashMap<String, String>() {{
        put("ciemny", "perelka");
        put("bursztynowy", "harnold");
        put("slomkowy", "wojak");
    }};

    public static String dejPiwerko(String s)
    {
        return piwerka.get(s);
    }
}
