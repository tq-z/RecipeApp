package com.example.recipeapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Recipe {

    int movieId;
    //String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    // empty constructor needed by the Parceler library
    public Recipe() {}

    public Recipe(JSONObject jsonObject) throws JSONException {
        //backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("image");
        title = jsonObject.getString("title");
        String unformattedSummary = jsonObject.getString("instructions");
        overview= unformattedSummary.replaceAll("<.*?>", "");
        rating = jsonObject.getDouble("readyInMinutes");
        movieId = jsonObject.getInt("id");
    }

    public static List<Recipe> fromJsonArray(JSONArray recipeJsonArray) throws JSONException {
        List<Recipe> recipes = new ArrayList<>();
        for (int i = 0; i < recipeJsonArray.length(); i++){
            recipes.add(new Recipe(recipeJsonArray.getJSONObject(i)));
        }
        return recipes;
    }

    public String getPosterPath() {
        return posterPath;
    }

    //public String getBackdropPath() {
    //   return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    // }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
