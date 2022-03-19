package com.example.exchange.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exchange.R;
import com.example.exchange.databinding.RvItemCurrencyBinding;
import com.example.exchange.model.Currency;
import com.example.exchange.tools.CurrencyListener;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    private ArrayList<Currency> currencyList;
    private CurrencyListener listener;

    public CurrencyAdapter(ArrayList<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvItemCurrencyBinding binding = RvItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new CurrencyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
        holder.bindCurrency(currencyList.get(position));
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    public void setListener(CurrencyListener listener) {
        this.listener = listener;
    }

    public void refreshList(ArrayList<Currency> list) {
        this.currencyList = list;
        notifyDataSetChanged();
    }

    public class CurrencyViewHolder extends RecyclerView.ViewHolder {

        private final RvItemCurrencyBinding binding;

        public CurrencyViewHolder(@NonNull RvItemCurrencyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view ->
                    listener.OnCurrencyClicked(currencyList.get(getAdapterPosition())));
        }

        private void bindCurrency(Currency currency) {
            binding.imageViewItemPicture.setImageResource(currency.imageUrl);
            binding.textViewItemShortName.setText(currency.shortName);
            binding.textViewItemFullName.setText(currency.fullName);
        }
    }
}
