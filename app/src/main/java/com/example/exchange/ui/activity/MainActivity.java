package com.example.exchange.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exchange.data.DataContainer;
import com.example.exchange.databinding.ActivityMainBinding;
import com.example.exchange.model.Currency;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Currency currency1;
    private Currency currency2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        setListeners();
    }

    private void initData() {
        binding.editTextValue.requestFocus();
        DataContainer.loadCurrencyList();
        currency1 = DataContainer.currencyList.get(0);
        currency2 = DataContainer.currencyList.get(1);
        setCurrency1();
        setCurrency2();
    }

    private void setListeners() {
        binding.imageViewList.setOnClickListener(view -> goToCurrencyListActivity());
        binding.buttonConvert.setOnClickListener(view -> convert());
        binding.imageViewPrevious1.setOnClickListener(view -> getPreviousCurrency1());
        binding.imageViewNext1.setOnClickListener(view -> getNextCurrency1());
        binding.imageViewPrevious2.setOnClickListener(view -> getPreviousCurrency2());
        binding.imageViewNext2.setOnClickListener(view -> getNextCurrency2());
    }

    private void clearTextFields() {
        binding.editTextValue.setText("");
        binding.textViewResult.setText("");
    }

    private void getPreviousCurrency1() {
        clearTextFields();
        int index = DataContainer.currencyList.indexOf(currency1);

        if (index > 0) {
            if (currency2 != DataContainer.currencyList.get(index - 1)) {
                currency1 = DataContainer.currencyList.get(index - 1);
                setCurrency1();
            } else {
                if (index > 1) {
                    currency1 = DataContainer.currencyList.get(index - 2);
                    setCurrency1();
                }
            }
        }
    }

    private void getNextCurrency1() {
        clearTextFields();
        int index = DataContainer.currencyList.indexOf(currency1);

        if (index < DataContainer.currencyList.size() - 1) {
            if (currency2 != DataContainer.currencyList.get(index + 1)) {
                currency1 = DataContainer.currencyList.get(index + 1);
                setCurrency1();
            } else {
                if (index < DataContainer.currencyList.size() - 2) {
                    currency1 = DataContainer.currencyList.get(index + 2);
                    setCurrency1();
                }
            }
        }

    }

    private void setCurrency1() {
        binding.circleImageView1.setImageResource(currency1.imageUrl);
        binding.textViewName1.setText(currency1.fullName);
        binding.textViewShortName1.setText(currency1.shortName);
        binding.textViewValues1.setText(getValuesString(currency1));
    }

    private void getPreviousCurrency2() {
        clearTextFields();
        int index = DataContainer.currencyList.indexOf(currency2);

        if (index > 0) {
            if (currency1 != DataContainer.currencyList.get(index - 1)) {
                currency2 = DataContainer.currencyList.get(index - 1);
                setCurrency2();
            } else {
                if (index > 1) {
                    currency2 = DataContainer.currencyList.get(index - 2);
                    setCurrency2();
                }
            }
        }
    }

    private void getNextCurrency2() {
        clearTextFields();
        int index = DataContainer.currencyList.indexOf(currency2);

        if (index < DataContainer.currencyList.size() - 1) {
            if (currency1 != DataContainer.currencyList.get(index + 1)) {
                currency2 = DataContainer.currencyList.get(index + 1);
                setCurrency2();
            } else {
                if (index < DataContainer.currencyList.size() - 2) {
                    currency2 = DataContainer.currencyList.get(index + 2);
                    setCurrency2();
                }
            }
        }
    }

    private void setCurrency2() {
        binding.circleImageView2.setImageResource(currency2.imageUrl);
        binding.textViewName2.setText(currency2.fullName);
        binding.textViewShortName2.setText(currency2.shortName);
        binding.textViewValues2.setText(getValuesString(currency2));
    }

    private String getValuesString(Currency currency) {

        double value = currency.valuePerDollar;
        String valueS = String.format("%1.2f", value);
        return "1.00 USD - " + valueS + " " + currency.shortName;
    }

    private void convert() {
        String s = binding.editTextValue.getText().toString();

        try {
            double result;
            double enteredNumber = Double.parseDouble(s);
            if (enteredNumber < 0) {
                Toast.makeText(this, "Entered number must be greater than 0", Toast.LENGTH_SHORT).show();
                binding.editTextValue.getText().clear();
                return;
            }
            result = (enteredNumber * currency2.valuePerDollar) / currency1.valuePerDollar;
            binding.textViewResult.setText(String.format("%1.2f", result));
        } catch (Exception e) {
            binding.editTextValue.getText().clear();
            binding.textViewResult.setText("");
            Toast.makeText(this, "Please, enter a number", Toast.LENGTH_SHORT).show();
        }

    }


    private void goToCurrencyListActivity() {
        Intent intent = new Intent(getApplicationContext(), CurrencyListActivity.class);
        startActivity(intent);
    }
}