package ru.axout.mvvm_colorguide.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Flowers implements Serializable {

    @SerializedName("flower_id")
    public long flower_id;

    @SerializedName("flower_img")
    public String flower_img;

    @SerializedName("flower_rus")
    public String flower_rus;

    @SerializedName("flower_lat")
    public String flower_lat;

    @SerializedName("flower_desc")
    public String flower_desc;
}
