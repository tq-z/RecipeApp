package com.example.recipeapp.models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;

@ParseClassName("CookBook")
public class CookBook extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "author";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_CREATE_PLACE_KEY = "CreateAtPlace";

    public static final String KEY_TITLE = "name";
    public static final String KEY_STEP = "steps";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public String getTitle() {
        return getString(KEY_TITLE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

    public String getCreateAtTime() {
        return getString(KEY_CREATED_KEY);
    }

    public String getCreatedAtPlace() {
        return getString(KEY_CREATE_PLACE_KEY);
    }

}