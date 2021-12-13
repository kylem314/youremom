package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.*;

import java.util.HashMap;

import org.json.*;


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
class Charlieabout {
    @GetMapping("/charlieabout")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String charlie_about(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "charlieabout"; // returns HTML VIEW (greeting)
    }
    @GetMapping("/about/charlie")
    public String charlie(@RequestParam(name="artist", required=false, defaultValue="Official HIDEDANDISM") String artist, Model model) throws IOException, InterruptedException, ParseException, JSONException {

        List<String> artistList = new ArrayList<String>();
        String [] a = artist.split(" ");

        StringBuilder artistName = new StringBuilder();

        String prefix = "";

        for (String i : a) {
            artistName.append(prefix);
            artistName.append(i);
            prefix = "%20";
        }

        System.out.println(artistName);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://genius.p.rapidapi.com/search?q=" + artistName))
                .header("x-rapidapi-host", "genius.p.rapidapi.com")
                .header("x-rapidapi-key", "4190a7eb73msh31b7a3a5e4814d3p1ffd18jsn5e2c346f8d63")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        JSONObject jo = new JSONObject(response.body());
//        System.out.println(jo);
        JSONObject response_jo = jo.getJSONObject("response");
        JSONArray hitsArray = response_jo.getJSONArray("hits");

        JSONObject firstHit = hitsArray.getJSONObject(0);
//        System.out.println("first hit:" + firstHit.toString());

        JSONObject firstHitResult = (JSONObject) firstHit.get("result");

        String song_art_url = firstHitResult.get("song_art_image_url").toString();
        String song_name = firstHitResult.get("full_title").toString();

        List<Map<String, String>> mapsList = new ArrayList<Map<String, String>>();

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("Profile", "https://github.com/1855387");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("Issues", "https://github.com/kylem314/youremom/issues?q=assignee%3A1855387");
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("Scrum Board", "https://github.com/kylem314/youremom/projects/1?card_filter_query=assignee%3A1855387");
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("Commits", "https://github.com/kylem314/youremom/commits/master");
        Map<String, String> map5 = new HashMap<String, String>();
        map5.put("Journal", "https://docs.google.com/document/d/1Cveew1hqk56At565Kp9DZfIZK5_nHjVgp2LFCoSyNSw/edit");

        mapsList.add(map1);
        mapsList.add(map2);
        mapsList.add(map3);
        mapsList.add(map4);
        mapsList.add(map5);

        model.addAttribute("song_art_url", song_art_url);
        model.addAttribute("song_name", song_name);
        model.addAttribute("mapsList", mapsList);

        return "charlieabout";
    }
}
