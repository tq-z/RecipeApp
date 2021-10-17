Original App Design Project - README Template
===

# UltimateFoodMaker

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Be the ultimate chef by finding popular recipes matched to your specifications. Find out what most people are cooking, or find something unique to fit your taste. Create your own cookbook by storing recipes or writing your own!

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Food
- **Mobile:** Upload photos and recipes of your foods in real time. Implements camera functionality and real time interaction by being able to like other people's recipes.
- **Story:** The app aims to not only improve people's cooking skills, but also allow them to share with others. Enjoyable foods can be shared with each other to produce new recipes or master existing ones.
- **Market:** The audience is very large. It provides functionality for not only the masses of people who like to cook, but also small niche groups by implementing the ability of specified searches.
- **Habit:** An average user would open and use this app whenever they want to cook or get inspired, probably a few times a week. Users have the ability to both consume the information on the app as well as create new recipes to share with others.
- **Scope:** The cscope for this project is fairly defined. Data needs to be parsed in and displayed, as well as created. It also needs to implement a camera functionality and allow the liking of other users posts.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Users can see a list of popular recipes
* Users can click on a recipe title to display the full recipe
* Users can upload their own recipe with photos
* Users can share their recipes on selected social media
* Users can store their own recipes on device and upload it when network available
* Users can search for a recipe by typing the meal name into a search box

**Optional Nice-to-have Stories**

* Users can see the location of posts
* Nearby restaurants which have the recipe you are looking for are displayed
* Users can watch the video version recipes
* Other basic information like rating, price and something else about such restaurants will be displayed

### 2. Screen Archetypes

* Stream
   * Users can see a list of popular recipes
* Detail
   * Users can click on a recipe title to display the full recipe
* Login
   * Users can login if they wish to post or like a recipe
* Share
    * User can capture the photo and post it
    * User can record the time they spend on this meal
    * User can rate the overall difficulty and record the most difficult part of this recipe
    * User can choose whether including the original image as a contrast
    * User can check their friends' feedback here if using the social media with *comments*.
* Search
    *  User can search for a recipe by typing the meal name into a search box
    *  User can search for a recipe by typing the meal main ingredient into a search box
    *  Log the recent search



### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home Feed
* Post a Recipe
* View Details of a recipe
* Search for recipe
* View and create personalized cookbooks

**Flow Navigation** (Screen to Screen)

* Stream Screen
   * Navigation to details of a recipe
   * Navigate to Search Screen when type in the search bar
* Login Screen
   * Navigate back to creation screen if trying to post a recipe
   * Navigate back to stream screen if trying to log in for general purposes
* Creation Screen
   * Navigation to personal cookbooks page
   * Views and allows the creation and editing of your own personalized cookbooks
   * Allow users share their own recipes by multi-choice quickly
* Share Screen
    * Here is a timeline of the User's past sharing.
    * Navigate to create a new one.
    * Navigate to Login Screen if they are not logged in
    * Navigate to detail page of their sharing. 
* Search Screen
    * Navigate to details of a recipe

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
