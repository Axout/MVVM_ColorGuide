package ru.axout.mvvm_colorguide.network;

import com.google.gson.annotations.SerializedName;
import ru.axout.mvvm_colorguide.model.Flowers;

import java.util.List;

public class FlowerResponse {

    @SerializedName("result")
    public List<Flowers> listFlowers;
}
