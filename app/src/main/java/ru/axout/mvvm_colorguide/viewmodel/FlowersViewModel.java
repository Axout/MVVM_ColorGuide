package ru.axout.mvvm_colorguide.viewmodel;

import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import com.squareup.picasso.Picasso;
import ru.axout.mvvm_colorguide.R;
import ru.axout.mvvm_colorguide.model.Flowers;

public class FlowersViewModel extends BaseObservable {

    private Flowers flowers;
    private String flowerImg;
    private String flower_rus;
    private String flower_lat;
    private String flower_desc;

    public FlowersViewModel(Flowers flowers) {
        this.flowers = flowers;
    }

    public String getFlowerImg() {
        flowerImg = flowers.flower_img;
        return flowerImg;
    }

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String flowerImg) {
        Picasso.get()
                .load(flowerImg)
                .error(R.drawable.ic_flower)
                .placeholder(R.drawable.ic_flower)
                .fit()
                .into(imageView);
    }

    public String getFlower_rus() {
        flower_rus = flowers.flower_rus;
        return flower_rus;
    }

    public String getFlower_lat() {
        flower_lat = flowers.flower_lat;
        return flower_lat;
    }

    public String getFlower_desc() {
        flower_desc = flowers.flower_desc;
        return flower_desc;
    }
}
