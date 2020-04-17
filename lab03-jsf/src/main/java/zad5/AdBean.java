package zad5;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Named
@ApplicationScoped
public class AdBean
{
    private int clickCounter;
    private ArrayList<String> ads;
    private HashMap<String, String> redirectURLs;
    private String randAd;

    @PostConstruct
    public void init()
    {
        clickCounter = 0;
        ads = new ArrayList<>();
        ads.add("https://i.imgur.com/JJ90Ngr.png");
        ads.add("https://i.imgur.com/sjWa9aX.png");
        ads.add("https://imgur.com/GJ7R9f7.png");

        redirectURLs = new HashMap<>();
        redirectURLs.put("https://i.imgur.com/JJ90Ngr.png", "https://www.aliorbank.pl/");
        redirectURLs.put("https://i.imgur.com/sjWa9aX.png", "https://pilot.wp.pl/tv/");
        redirectURLs.put("https://imgur.com/GJ7R9f7.png", "https://www.neonet.pl/");

    }

    public int getClickCounter()
    {
        return clickCounter;
    }

    public void setClickCounter(int clickCounter)
    {
        this.clickCounter = clickCounter;
    }

    public String randomAd()
    {
        Random r = new Random();
        int id = r.nextInt(ads.size());
        randAd = ads.get(id);
        return randAd;
    }



    public void adRedirect()
    {
        clickCounter++;
        System.out.println(clickCounter);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect(redirectURLs.get(randAd));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
