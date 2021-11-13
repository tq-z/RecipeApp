package com.example.recipeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.R;
import com.example.recipeapp.TimeFormatter;
import com.example.recipeapp.models.CookBook;
import com.example.recipeapp.models.Recipe;
import com.parse.ParseFile;

import java.util.List;

public class MyBookAdapter extends RecyclerView.Adapter<MyBookAdapter.ViewHolder>{

    Context context;
    List<CookBook> recipes;

    // Psss the contex & list


    public MyBookAdapter(Context context, List<CookBook> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    // for each row, inflate
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe_book, parent, false);
        return new ViewHolder(view);
    }

    //bind values
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CookBook recipe = recipes.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        recipes.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<CookBook> recipeList) {
        recipes.addAll(recipeList);
        notifyDataSetChanged();
    }

    //define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivRecipeImage;
        TextView tvRecipeBody;
        TextView tvRecipeName;
        TextView tvCreateLocation;
        TextView tvTimeStamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecipeImage = itemView.findViewById(R.id.ivRecipeImage);
            tvRecipeBody = itemView.findViewById(R.id.tvRecipeBody);
            tvCreateLocation = itemView.findViewById(R.id.tvCreateLocation);
            tvRecipeName = itemView.findViewById(R.id.tvRecipeName);
            tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp);
        }

        public void bind(CookBook recipe) {
            tvRecipeBody.setText(recipe.getDescription());
            tvRecipeName.setText(recipe.getTitle());
            tvCreateLocation.setText("@"+recipe.getCreatedAtPlace());
            ParseFile image = recipe.getImage();
            if (image != null) {
                Glide.with(context).load(recipe.getImage().getUrl()).into(ivRecipeImage);
            }
            tvTimeStamp.setText((recipe.getCreateAtTime()));
        }
    }
}
