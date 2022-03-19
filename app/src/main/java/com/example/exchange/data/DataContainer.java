package com.example.exchange.data;

import com.example.exchange.R;
import com.example.exchange.model.Currency;

import java.util.ArrayList;
import java.util.Locale;

public class DataContainer {

    public static ArrayList<Currency> currencyList = new ArrayList<>();

    public static void loadCurrencyList() {

        currencyList.add(new Currency(
                R.mipmap.ic_eur_round,
                "EUR",
                "Euro",
                0.90365
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_usd_round,
                "USD",
                "US Dollar",
                1.00
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_rsd_round,
                "RSD",
                "Serbian Dinar",
                106.196
        ));


        currencyList.add(new Currency(
                R.mipmap.ic_gbp_round,
                "GBP",
                "Great British Pound",
                0.76017
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_chf_round,
                "CHF",
                "Swiss Franc",
                0.93858
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_aud_round,
                "AUD",
                "Australian Dollar",
                1.36168
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_hrk_round,
                "HRK",
                "Croatian Kuna",
                6.8358
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_dkk_round,
                "DKK",
                "Danish Krone",
                6.72587
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_huf_round,
                "HUF",
                "Hungarian Forint",
                335.018
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_nok_round,
                "NOK",
                "Norwegian Kroner",
                8.84277
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_sek_round,
                "SEK",
                "Swedish Krona",
                9.41821
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_bam_round,
                "BAM",
                "Bosnian Mark",
                1.76738
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_rub_round,
                "RUB",
                "Russian Rouble",
                101.869
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_cny_round,
                "CNY",
                "Chinese Yuan Renminbi",
                6.34518
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_jpy_round,
                "JPY",
                "Japanese Yen",
                118.664
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_pln_round,
                "PLN",
                "Polish Zloty",
                4.22413
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_czk_round,
                "CZK",
                "Czech Koruna",
                22.3218
        ));

        currencyList.add(new Currency(
                R.mipmap.ic_try_round,
                "TRY",
                "Turkish Lira",
                14.6733
        ));
    }

    public static ArrayList<Currency> filterList(String term) {
        ArrayList<Currency> list = new ArrayList<>();

        for (Currency currency : currencyList) {
            if (currency.shortName.toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT)) ||
                    currency.fullName.toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT))
            ) {
                list.add(currency);
            }
        }

        if (list.isEmpty()) {
            return currencyList;
        }

        return list;
    }
}
