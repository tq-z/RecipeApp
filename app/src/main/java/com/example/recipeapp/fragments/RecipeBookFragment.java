package com.example.recipeapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.recipeapp.R;
import com.example.recipeapp.adapters.MyBookAdapter;
import com.example.recipeapp.models.CookBook;
import com.example.recipeapp.models.Recipe;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class RecipeBookFragment extends Fragment {

    public static final String TAG = "RecipeBookFragment";

    private RecyclerView rvPosts;
    private SwipeRefreshLayout swipeContainer;
    protected MyBookAdapter adapter;
    private List<CookBook> allRecipes;

    public RecipeBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPosts = view.findViewById(R.id.rvPosts);

        allRecipes = new ArrayList<>();
        adapter = new MyBookAdapter(getContext(),allRecipes);
        rvPosts.setAdapter(adapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();

        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                queryPosts();
            }
        });

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
    protected void queryPosts() {
        ParseQuery<CookBook> query = ParseQuery.getQuery(CookBook.class);
        query.include(CookBook.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(CookBook.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<CookBook>() {
            @Override
            public void done(List<CookBook> recipes, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for (CookBook recipe : recipes){
//                    Log.i(TAG, "Post:" + recipe.getDescription()+ ", username:" + recipe.getUser().getUsername());
                    Log.i(TAG, "Post:" + recipe.getDescription()+ ", Desc:" + recipe.getDescription());
                }
                adapter.clear();
                allRecipes.addAll(recipes);
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        });
    }
}