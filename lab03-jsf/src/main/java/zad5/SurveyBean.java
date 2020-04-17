package zad5;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class SurveyBean implements Serializable
{
    private String fullName;
    private String email;
    private int age;
    private String gender;
    private String education;
    private int height;
    private String menChest;
    private String menWaist;
    private String womenBust;
    private String womenCup;
    private String womenWaist;
    private String womenHips;

    private String clothesMoney;
    private String buyingFreq;
    private String color;
    private ArrayList<String> clothesType;

    private String summaryClothesType;

    @PostConstruct
    public void init()
    {
        height = 170;
        age = 18;
    }


    public void summaryMaker()
    {
        StringBuilder sb = new StringBuilder();
        for(String s : clothesType)
        {
            sb.append(s).append(", ");
        }
        if(sb.length() > 2) sb.setLength(sb.length() - 2);

        summaryClothesType = sb.toString();
    }

    public String getSummaryClothesType()
    {
        return summaryClothesType;
    }

    public void setSummaryClothesType(String summaryClothesType)
    {
        this.summaryClothesType = summaryClothesType;
    }

    public String getBuyingFreq()
    {
        return buyingFreq;
    }

    public void setBuyingFreq(String buyingFreq)
    {
        this.buyingFreq = buyingFreq;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public ArrayList<String> getClothesType()
    {
        return clothesType;
    }

    public void setClothesType(ArrayList<String> clothesType)
    {
        this.clothesType = clothesType;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getEducation()
    {
        return education;
    }

    public void setEducation(String education)
    {
        this.education = education;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getMenChest()
    {
        return menChest;
    }

    public void setMenChest(String menChest)
    {
        this.menChest = menChest;
    }

    public String getMenWaist()
    {
        return menWaist;
    }

    public void setMenWaist(String menWaist)
    {
        this.menWaist = menWaist;
    }

    public String getWomenBust()
    {
        return womenBust;
    }

    public void setWomenBust(String womenBust)
    {
        this.womenBust = womenBust;
    }

    public String getWomenCup()
    {
        return womenCup;
    }

    public void setWomenCup(String womenCup)
    {
        this.womenCup = womenCup;
    }

    public String getWomenWaist()
    {
        return womenWaist;
    }

    public void setWomenWaist(String womenWaist)
    {
        this.womenWaist = womenWaist;
    }

    public String getWomenHips()
    {
        return womenHips;
    }

    public void setWomenHips(String womenHips)
    {
        this.womenHips = womenHips;
    }

    public String getClothesMoney()
    {
        return clothesMoney;
    }

    public void setClothesMoney(String clothesMoney)
    {
        this.clothesMoney = clothesMoney;
    }
}
