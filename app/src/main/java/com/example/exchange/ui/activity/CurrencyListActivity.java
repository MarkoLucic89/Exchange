package com.example.exchange.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.exchange.data.DataContainer;
import com.example.exchange.databinding.ActivityCurrencyListBinding;
import com.example.exchange.ui.adapter.CurrencyAdapter;

public class CurrencyListActivity extends AppCompatActivity {

    private ActivityCurrencyListBinding binding;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCurrencyListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerView();
        setListeners();
    }

    private void initRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new CurrencyAdapter(DataContainer.currencyList);
        binding.recyclerView.setAdapter(adapter);
    }

    private void setListeners() {
        binding.imageViewBack.setOnClickListener(view -> finish());

        adapter.setListener(currency ->
                Toast.makeText(this, currency.fullName, Toast.LENGTH_SHORT).show());

        binding.imageViewSearch.setOnClickListener(view ->
                adapter.refreshList(DataContainer.filterList(binding.editTextSearch.getText().toString())));
    }


}