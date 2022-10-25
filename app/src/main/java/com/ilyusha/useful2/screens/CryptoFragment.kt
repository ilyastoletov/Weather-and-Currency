package com.ilyusha.useful2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilyusha.useful2.R
import com.ilyusha.useful2.data.api.RetrofitInstance
import com.ilyusha.useful2.data.repositories.CryptoRepository
import com.ilyusha.useful2.data.vm.CryptoViewModel
import com.ilyusha.useful2.databinding.FragmentCryptoBinding
import com.ilyusha.useful2.recyclers.Currency
import com.ilyusha.useful2.recyclers.CurrencyAdapter
import kotlin.math.roundToInt

class CryptoFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var currencyAdapter: CurrencyAdapter
    lateinit var binding: FragmentCryptoBinding
    lateinit var viewModel: CryptoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_crypto, container, false)
        binding = DataBindingUtil.bind(viewBinding.root)!!
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.rvCurrency
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CurrencyAdapter()
        recyclerView.adapter = adapter
        viewModel = CryptoViewModel()
        viewModel.getCrypto()
        viewModel.curList.observe(viewLifecycleOwner) { it ->
            it.body()?.let { adapter.setList(arrayListOf<Currency>(
                Currency(R.drawable.bitcoin, "Bitcoin", "${it.bitcoin.usd} $"),
                Currency(R.drawable.ethereum, "Ethereum", "${it.ethereum.usd} $"),
                Currency(R.drawable.bnb, "BNB Coin", "${it.binancecoin.usd} $"),
                Currency(R.drawable.xrp, "Ripple", "${it.ripple.usd} $"),
                Currency(R.drawable.solana, "Solana", "${it.solana.usd} $"),
                Currency(R.drawable.litecoin, "Litecoin", "${it.litecoin.usd} $"),
            ))
            adapter.notifyDataSetChanged()
            }
        }
    }
}