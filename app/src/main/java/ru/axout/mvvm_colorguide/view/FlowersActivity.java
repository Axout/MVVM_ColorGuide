package ru.axout.mvvm_colorguide.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import ru.axout.mvvm_colorguide.R;
import ru.axout.mvvm_colorguide.databinding.ActivityFlowersBinding;

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

    }
}