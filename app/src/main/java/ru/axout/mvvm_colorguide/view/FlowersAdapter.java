package ru.axout.mvvm_colorguide.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import ru.axout.mvvm_colorguide.R;
import ru.axout.mvvm_colorguide.databinding.ItemFlowersBinding;
import ru.axout.mvvm_colorguide.model.Flowers;
import ru.axout.mvvm_colorguide.viewmodel.FlowersViewModel;

import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.FlowersViewHolder> {

    private final List<Flowers> flowers;

    public FlowersAdapter(List<Flowers> flowers) {
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public FlowersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFlowersBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_flowers, parent, false);
        return new FlowersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowersViewHolder holder, int position) {
        ItemFlowersBinding binding = holder.binding;
        binding.setItem(new FlowersViewModel(flowers.get(position)));
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public static class FlowersViewHolder extends RecyclerView.ViewHolder {

        ItemFlowersBinding binding;

        public FlowersViewHolder(@NonNull ItemFlowersBinding binding) {
            super(binding.flowerItem);
            this.binding = binding;
        }
    }
}
