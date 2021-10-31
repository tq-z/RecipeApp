package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.recipeapp.adapters.RecipeAdapter;
import com.example.recipeapp.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String  NOW_PLAYING_URL = "https://api.spoonacular.com/recipes/random?veryPopular=true&number=10&apiKey=0dd3015721b54bf2aabec3630be6b00d";
    public static final String TAG = "MainActivity";

    List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMovies = findViewById(R.id.rvMovies);
        recipes = new ArrayList<>();

        // Create an adapter
        RecipeAdapter recipeAdapter = new RecipeAdapter(this, recipes);

        // Set the adapter on the recycler view
        rvMovies.setAdapter(recipeAdapter);

        // Set a layout manager on the recycler view
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results =  jsonObject.getJSONArray("recipes");
                    Log.i(TAG, "Results" + results.toString());
                    recipes.addAll(Recipe.fromJsonArray(results));
                    recipeAdapter.notifyDataSetChanged();
                    Log.i(TAG, "Movies" + recipes.size());
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}