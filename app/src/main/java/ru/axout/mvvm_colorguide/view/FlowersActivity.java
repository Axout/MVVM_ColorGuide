package ru.axout.mvvm_colorguide.view;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import ru.axout.mvvm_colorguide.R;
import ru.axout.mvvm_colorguide.databinding.ActivityFlowersBinding;
import ru.axout.mvvm_colorguide.network.Call;
import ru.axout.mvvm_colorguide.network.FlowerResponse;

public class FlowersActivity extends AppCompatActivity {

    private ActivityFlowersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        // связываем объект класса Binding с макетом
        binding = DataBindingUtil.setContentView(this, R.layout.activity_flowers);
        // теперь можно обращаться к макету через объект binding
        binding.flowersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call call = new Call(new Call.Delegate() {
            @Override
            public void onSuccess(FlowerResponse flowerResponse) {
                binding.flowersRecyclerView.setAdapter(new FlowersAdapter(flowerResponse.listFlowers));
            }

            @Override
            public void onFailure(Object t) {
                Toast.makeText(getApplicationContext(), "Error = " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        call.execute();
    }
}