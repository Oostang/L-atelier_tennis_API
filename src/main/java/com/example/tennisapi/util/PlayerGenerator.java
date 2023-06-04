package com.example.tennisapi.util;

import com.example.tennisapi.model.*;

public class PlayerGenerator {

    private static final String POL_URL = "https://youtu.be/dQw4w9WgXcQ";

    private PlayerGenerator() {
    }

    public static Player getNovak() {
        Player novak = new Player();
        novak.setId(52);
        novak.setFirstName("Novak");
        novak.setLastName("Djokovic");
        novak.setShortName("N.DJO");
        novak.setSex('M');
        novak.setCountry(new Country("https://data.latelier.co/training/tennis_stats/resources/Serbie.png", "SRB"));
        novak.setPicture("https://data.latelier.co/training/tennis_stats/resources/Djokovic.png");
        Data data = new Data();
        data.setRank((short) 2);
        data.setPoints(2542);
        data.setWeight(80000);
        data.setHeight((short) 188);
        data.setAge((byte) 31);
        data.setLast(new char[]{'1', '1', '1', '1', '1'});
        novak.setData(data);
        return novak;
    }

    public static Player getVenus() {
        Player venus = new Player();
        venus.setId(95);
        venus.setFirstName("Venus");
        venus.setLastName("Williams");
        venus.setShortName("V.WIL");
        venus.setSex('F');
        venus.setCountry(new Country("https://data.latelier.co/training/tennis_stats/resources/USA.png", "USA"));
        venus.setPicture("https://data.latelier.co/training/tennis_stats/resources/Venus.webp");
        Data data = new Data();
        data.setRank((short) 52);
        data.setPoints(1105);
        data.setWeight(74000);
        data.setHeight((short) 185);
        data.setAge((byte) 38);
        data.setLast(new char[]{'0', '1', '0', '0', '1'});
        venus.setData(data);
        return venus;
    }

    public static Player getStan() {
        Player stan = new Player();
        stan.setId(65);
        stan.setFirstName("Stan");
        stan.setLastName("Wawrinka");
        stan.setShortName("S.WAW");
        stan.setSex('M');
        stan.setCountry(new Country("https://data.latelier.co/training/tennis_stats/resources/Suisse.png", "SUI"));
        stan.setPicture("https://data.latelier.co/training/tennis_stats/resources/Wawrinka.png");
        Data data = new Data();
        data.setRank((short) 21);
        data.setPoints(1784);
        data.setWeight(81000);
        data.setHeight((short) 183);
        data.setAge((byte) 33);
        data.setLast(new char[]{'1', '1', '1', '0', '1'});
        stan.setData(data);
        return stan;
    }

    public static Player getSerena() {
        Player serena = new Player();
        serena.setId(102);
        serena.setFirstName("Serena");
        serena.setLastName("Williams");
        serena.setShortName("S.WIL");
        serena.setSex('F');
        serena.setCountry(new Country("https://data.latelier.co/training/tennis_stats/resources/USA.png", "USA"));
        serena.setPicture("https://data.latelier.co/training/tennis_stats/resources/Serena.png");
        Data data = new Data();
        data.setRank((short) 10);
        data.setPoints(3521);
        data.setWeight(72000);
        data.setHeight((short) 175);
        data.setAge((byte) 37);
        data.setLast(new char[]{'0', '1', '1', '1', '0'});
        serena.setData(data);
        return serena;
    }

    public static Player getRafael() {
        Player rafael = new Player();
        rafael.setId(17);
        rafael.setFirstName("Rafael");
        rafael.setLastName("Nadal");
        rafael.setShortName("R.NAD");
        rafael.setSex('M');
        rafael.setCountry(new Country("https://data.latelier.co/training/tennis_stats/resources/Espagne.png", "ESP"));
        rafael.setPicture("https://data.latelier.co/training/tennis_stats/resources/Nadal.png");
        Data data = new Data();
        data.setRank((short) 1);
        data.setPoints(1982);
        data.setWeight(85000);
        data.setHeight((short) 185);
        data.setAge((byte) 33);
        data.setLast(new char[]{'1', '0', '0', '0', '1'});
        rafael.setData(data);
        return rafael;
    }

    public static Player getRick() {
        Player rick = new Player();
        rick.setId(77);
        rick.setFirstName("Rick");
        rick.setLastName("Astley");
        rick.setShortName("R.AST");
        rick.setSex('M');
        rick.setCountry(new Country(POL_URL, "POL"));
        rick.setPicture("https://i0.wp.com/boingboing.net/wp-content/uploads/2021/02/astley.jpg?resize=930%2C561&ssl=1");
        Data data = new Data();
        data.setRank((short) 50);
        data.setPoints(9999);
        data.setWeight(70000);
        data.setHeight((short) 170);
        data.setAge((byte) 31);
        data.setLast(new char[]{'1', '1', '1', '1', '1'});
        rick.setData(data);
        return rick;
    }

    public static Player getYannick() {
        Player yannick = new Player();
        yannick.setId(420);
        yannick.setFirstName("Yannick");
        yannick.setLastName("Noah");
        yannick.setShortName("Y.NOA");
        yannick.setSex('M');
        yannick.setCountry(new Country(POL_URL, "POL"));
        yannick.setPicture(POL_URL);
        Data data = new Data();
        data.setRank((short) 3);
        data.setPoints(9999);
        data.setWeight(30000);
        data.setHeight((short) 190);
        data.setAge((byte) 70);
        data.setLast(new char[]{'1', '1', '1', '1', '1'});
        yannick.setData(data);
        return yannick;
    }

    public static Player getLeroy() {
        Player leroy = new Player();
        leroy.setId(117);
        leroy.setFirstName("Leroooooooooooooy");
        leroy.setLastName("Jenkins");
        leroy.setShortName("L.JEN");
        leroy.setSex('M');
        leroy.setCountry(new Country(POL_URL, "POL"));
        leroy.setPicture(POL_URL);
        Data data = new Data();
        data.setRank((short) 800);
        data.setPoints(-3000);
        data.setWeight(100000);
        data.setHeight((short) 190);
        data.setAge((byte) 70);
        data.setLast(new char[]{'1', '1', '1', '1', '1'});
        leroy.setData(data);
        return leroy;
    }

}
