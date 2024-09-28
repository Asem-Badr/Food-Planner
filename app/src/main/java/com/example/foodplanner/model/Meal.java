package com.example.foodplanner.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "meals_table")
public class Meal implements Serializable {

    @PrimaryKey
    @SerializedName("idMeal")
    private int idMeal;

    @SerializedName("strMeal")
    private String mealName;

    @SerializedName("strCategory")
    private String category;

    @SerializedName("strArea")
    private String area;

    @SerializedName("strInstructions")
    private String instructions;

    @SerializedName("strMealThumb")
    private String mealThumbnail;



    //this section is for capturing ingredients and measures from ingredients list response :
    @SerializedName("idIngredient")
    private String idIngredient;

    @SerializedName("strIngredient")
    private String ingredient;

    @SerializedName("strDescription")
    private String Description;


    //this section captures the whole ingredients from the meal response:
    @SerializedName("strIngredient1")
    private String ingredient1;

    @SerializedName("strIngredient2")
    private String ingredient2;

    @SerializedName("strIngredient3")
    private String ingredient3;

    @SerializedName("strIngredient4")
    private String ingredient4;

    @SerializedName("strIngredient5")
    private String ingredient5;

    @SerializedName("strIngredient6")
    private String ingredient6;

    @SerializedName("strIngredient7")
    private String ingredient7;

    @SerializedName("strIngredient8")
    private String ingredient8;

    @SerializedName("strIngredient9")
    private String ingredient9;

    @SerializedName("strIngredient10")
    private String ingredient10;

    @SerializedName("strIngredient11")
    private String ingredient11;

    @SerializedName("strIngredient12")
    private String ingredient12;

    @SerializedName("strIngredient13")
    private String ingredient13;

    @SerializedName("strIngredient14")
    private String ingredient14;

    @SerializedName("strIngredient15")
    private String ingredient15;

    @SerializedName("strIngredient16")
    private String ingredient16;

    @SerializedName("strIngredient17")
    private String ingredient17;

    @SerializedName("strIngredient18")
    private String ingredient18;

    @SerializedName("strIngredient19")
    private String ingredient19;

    @SerializedName("strIngredient20")
    private String ingredient20;




    @SerializedName("strMeasure1")
    private String measure1;

    @SerializedName("strMeasure2")
    private String measure2;

    @SerializedName("strMeasure3")
    private String measure3;

    @SerializedName("strMeasure4")
    private String measure4;

    @SerializedName("strMeasure5")
    private String measure5;

    @SerializedName("strMeasure6")
    private String measure6;

    @SerializedName("strMeasure7")
    private String measure7;

    @SerializedName("strMeasure8")
    private String measure8;

    @SerializedName("strMeasure9")
    private String measure9;

    @SerializedName("strMeasure10")
    private String measure10;

    @SerializedName("strMeasure11")
    private String measure11;

    @SerializedName("strMeasure12")
    private String measure12;

    @SerializedName("strMeasure13")
    private String measure13;

    @SerializedName("strMeasure14")
    private String measure14;

    @SerializedName("strMeasure15")
    private String measure15;

    @SerializedName("strMeasure16")
    private String measure16;

    @SerializedName("strMeasure17")
    private String measure17;

    @SerializedName("strMeasure18")
    private String measure18;

    @SerializedName("strMeasure19")
    private String measure19;

    @SerializedName("strMeasure20")
    private String measure20;



    public Meal(int idMeal, String mealName, String category) {
        this.idMeal = idMeal;
        this.mealName = mealName;
        this.category = category;
    }
    @Ignore
    public Meal(int idMeal, String mealName, String category, String area, String instructions, String mealThumbnail) {
        this.idMeal = idMeal;
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.instructions = instructions;
        this.mealThumbnail = mealThumbnail;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getMealThumbnail() {
        return mealThumbnail;
    }

    public void setMealThumbnail(String mealThumbnail) {
        this.mealThumbnail = mealThumbnail;
    }



    public String getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(String idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public String getIngredient4() {
        return ingredient4;
    }

    public void setIngredient4(String ingredient4) {
        this.ingredient4 = ingredient4;
    }

    public String getIngredient5() {
        return ingredient5;
    }

    public void setIngredient5(String ingredient5) {
        this.ingredient5 = ingredient5;
    }

    public String getIngredient6() {
        return ingredient6;
    }

    public void setIngredient6(String ingredient6) {
        this.ingredient6 = ingredient6;
    }

    public String getIngredient7() {
        return ingredient7;
    }

    public void setIngredient7(String ingredient7) {
        this.ingredient7 = ingredient7;
    }

    public String getIngredient8() {
        return ingredient8;
    }

    public void setIngredient8(String ingredient8) {
        this.ingredient8 = ingredient8;
    }

    public String getIngredient9() {
        return ingredient9;
    }

    public void setIngredient9(String ingredient9) {
        this.ingredient9 = ingredient9;
    }

    public String getIngredient10() {
        return ingredient10;
    }

    public void setIngredient10(String ingredient10) {
        this.ingredient10 = ingredient10;
    }

    public String getIngredient11() {
        return ingredient11;
    }

    public void setIngredient11(String ingredient11) {
        this.ingredient11 = ingredient11;
    }

    public String getIngredient12() {
        return ingredient12;
    }

    public void setIngredient12(String ingredient12) {
        this.ingredient12 = ingredient12;
    }

    public String getIngredient13() {
        return ingredient13;
    }

    public void setIngredient13(String ingredient13) {
        this.ingredient13 = ingredient13;
    }

    public String getIngredient14() {
        return ingredient14;
    }

    public void setIngredient14(String ingredient14) {
        this.ingredient14 = ingredient14;
    }

    public String getIngredient15() {
        return ingredient15;
    }

    public void setIngredient15(String ingredient15) {
        this.ingredient15 = ingredient15;
    }

    public String getIngredient16() {
        return ingredient16;
    }

    public void setIngredient16(String ingredient16) {
        this.ingredient16 = ingredient16;
    }

    public String getIngredient17() {
        return ingredient17;
    }

    public void setIngredient17(String ingredient17) {
        this.ingredient17 = ingredient17;
    }

    public String getIngredient18() {
        return ingredient18;
    }

    public void setIngredient18(String ingredient18) {
        this.ingredient18 = ingredient18;
    }

    public String getIngredient19() {
        return ingredient19;
    }

    public void setIngredient19(String ingredient19) {
        this.ingredient19 = ingredient19;
    }

    public String getIngredient20() {
        return ingredient20;
    }

    public void setIngredient20(String ingredient20) {
        this.ingredient20 = ingredient20;
    }

    public String getMeasure1() {
        return measure1;
    }

    public void setMeasure1(String measure1) {
        this.measure1 = measure1;
    }

    public String getMeasure2() {
        return measure2;
    }

    public void setMeasure2(String measure2) {
        this.measure2 = measure2;
    }

    public String getMeasure3() {
        return measure3;
    }

    public void setMeasure3(String measure3) {
        this.measure3 = measure3;
    }

    public String getMeasure4() {
        return measure4;
    }

    public void setMeasure4(String measure4) {
        this.measure4 = measure4;
    }

    public String getMeasure5() {
        return measure5;
    }

    public void setMeasure5(String measure5) {
        this.measure5 = measure5;
    }

    public String getMeasure6() {
        return measure6;
    }

    public void setMeasure6(String measure6) {
        this.measure6 = measure6;
    }

    public String getMeasure7() {
        return measure7;
    }

    public void setMeasure7(String measure7) {
        this.measure7 = measure7;
    }

    public String getMeasure8() {
        return measure8;
    }

    public void setMeasure8(String measure8) {
        this.measure8 = measure8;
    }

    public String getMeasure9() {
        return measure9;
    }

    public void setMeasure9(String measure9) {
        this.measure9 = measure9;
    }

    public String getMeasure10() {
        return measure10;
    }

    public void setMeasure10(String measure10) {
        this.measure10 = measure10;
    }

    public String getMeasure11() {
        return measure11;
    }

    public void setMeasure11(String measure11) {
        this.measure11 = measure11;
    }

    public String getMeasure12() {
        return measure12;
    }

    public void setMeasure12(String measure12) {
        this.measure12 = measure12;
    }

    public String getMeasure13() {
        return measure13;
    }

    public void setMeasure13(String measure13) {
        this.measure13 = measure13;
    }

    public String getMeasure14() {
        return measure14;
    }

    public void setMeasure14(String measure14) {
        this.measure14 = measure14;
    }

    public String getMeasure15() {
        return measure15;
    }

    public void setMeasure15(String measure15) {
        this.measure15 = measure15;
    }

    public String getMeasure16() {
        return measure16;
    }

    public void setMeasure16(String measure16) {
        this.measure16 = measure16;
    }

    public String getMeasure17() {
        return measure17;
    }

    public void setMeasure17(String measure17) {
        this.measure17 = measure17;
    }

    public String getMeasure18() {
        return measure18;
    }

    public void setMeasure18(String measure18) {
        this.measure18 = measure18;
    }

    public String getMeasure19() {
        return measure19;
    }

    public void setMeasure19(String measure19) {
        this.measure19 = measure19;
    }

    public String getMeasure20() {
        return measure20;
    }

    public void setMeasure20(String measure20) {
        this.measure20 = measure20;
    }

    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();

        if (ingredient1 != null && !ingredient1.isEmpty()) ingredients.add(ingredient1);
        if (ingredient2 != null && !ingredient2.isEmpty()) ingredients.add(ingredient2);
        if (ingredient3 != null && !ingredient3.isEmpty()) ingredients.add(ingredient3);
        if (ingredient4 != null && !ingredient4.isEmpty()) ingredients.add(ingredient4);
        if (ingredient5 != null && !ingredient5.isEmpty()) ingredients.add(ingredient5);
        if (ingredient6 != null && !ingredient6.isEmpty()) ingredients.add(ingredient6);
        if (ingredient7 != null && !ingredient7.isEmpty()) ingredients.add(ingredient7);
        if (ingredient8 != null && !ingredient8.isEmpty()) ingredients.add(ingredient8);
        if (ingredient9 != null && !ingredient9.isEmpty()) ingredients.add(ingredient9);
        if (ingredient10 != null && !ingredient10.isEmpty()) ingredients.add(ingredient10);
        if (ingredient11 != null && !ingredient11.isEmpty()) ingredients.add(ingredient11);
        if (ingredient12 != null && !ingredient12.isEmpty()) ingredients.add(ingredient12);
        if (ingredient13 != null && !ingredient13.isEmpty()) ingredients.add(ingredient13);
        if (ingredient14 != null && !ingredient14.isEmpty()) ingredients.add(ingredient14);
        if (ingredient15 != null && !ingredient15.isEmpty()) ingredients.add(ingredient15);
        if (ingredient16 != null && !ingredient16.isEmpty()) ingredients.add(ingredient16);
        if (ingredient17 != null && !ingredient17.isEmpty()) ingredients.add(ingredient17);
        if (ingredient18 != null && !ingredient18.isEmpty()) ingredients.add(ingredient18);
        if (ingredient19 != null && !ingredient19.isEmpty()) ingredients.add(ingredient19);
        if (ingredient20 != null && !ingredient20.isEmpty()) ingredients.add(ingredient20);

        return ingredients;
    }

    // Function to get the list of measures
    public List<String> getMeasures() {
        List<String> measures = new ArrayList<>();

        if (measure1 != null && !measure1.isEmpty()) measures.add(measure1);
        if (measure2 != null && !measure2.isEmpty()) measures.add(measure2);
        if (measure3 != null && !measure3.isEmpty()) measures.add(measure3);
        if (measure4 != null && !measure4.isEmpty()) measures.add(measure4);
        if (measure5 != null && !measure5.isEmpty()) measures.add(measure5);
        if (measure6 != null && !measure6.isEmpty()) measures.add(measure6);
        if (measure7 != null && !measure7.isEmpty()) measures.add(measure7);
        if (measure8 != null && !measure8.isEmpty()) measures.add(measure8);
        if (measure9 != null && !measure9.isEmpty()) measures.add(measure9);
        if (measure10 != null && !measure10.isEmpty()) measures.add(measure10);
        if (measure11 != null && !measure11.isEmpty()) measures.add(measure11);
        if (measure12 != null && !measure12.isEmpty()) measures.add(measure12);
        if (measure13 != null && !measure13.isEmpty()) measures.add(measure13);
        if (measure14 != null && !measure14.isEmpty()) measures.add(measure14);
        if (measure15 != null && !measure15.isEmpty()) measures.add(measure15);
        if (measure16 != null && !measure16.isEmpty()) measures.add(measure16);
        if (measure17 != null && !measure17.isEmpty()) measures.add(measure17);
        if (measure18 != null && !measure18.isEmpty()) measures.add(measure18);
        if (measure19 != null && !measure19.isEmpty()) measures.add(measure19);
        if (measure20 != null && !measure20.isEmpty()) measures.add(measure20);

        return measures;
    }


}

