package com.ilyusha.useful2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilyusha.useful2.R
import com.ilyusha.useful2.recyclers.ApiServices
import com.ilyusha.useful2.recyclers.Currency
import com.ilyusha.useful2.recyclers.CurrencyAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CryptoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_crypto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val recyclerView: RecyclerView = view.findViewById(R.id.rvCurrency)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val currencies: ArrayList<Currency> = arrayListOf(
            Currency(R.drawable.bitcoin, "Bitcoin", "23 401 $"),
            Currency(R.drawable.ethereum, "Ethereum", "1 340 $"),
            Currency(R.drawable.bnb, "BNB Coin", "360 $"),
            Currency(R.drawable.solana, "Solana", "36 $"),
            Currency(R.drawable.xrp, "Ripple", "0.445 $"),
            Currency(R.drawable.litecoin, "Litecoin", "56 $"),
            )
        recyclerView.adapter = CurrencyAdapter(currencies)
    }

    fun createRequest() {

    }
}