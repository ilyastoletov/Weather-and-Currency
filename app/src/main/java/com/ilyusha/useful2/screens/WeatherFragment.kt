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
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ilyusha.useful2.R
import com.ilyusha.useful2.data.vm.WeatherViewModel
import com.ilyusha.useful2.databinding.FragmentWeatherBinding
import com.ilyusha.useful2.recyclers.weather.WeatherAdapter
import com.ilyusha.useful2.recyclers.weather.WeatherData

class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding
    lateinit var wViewModel: WeatherViewModel
    lateinit var rvWeather: RecyclerView
    lateinit var rvAdapter: WeatherAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_weather, container, false)
        binding = DataBindingUtil.bind<FragmentWeatherBinding>(v.root)!!
        wViewModel = WeatherViewModel()
        val layManager: LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvWeather = binding.rvWeather
        rvAdapter = WeatherAdapter()
        rvWeather.apply {
            adapter = rvAdapter
            layoutManager = layManager
        }
        binding.apply {
            vm = wViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wViewModel.getWeatherTogliatti()
        wViewModel.getCurrenciesCourse()
        wViewModel.weatherHoursPrediction.observe(viewLifecycleOwner) {
            rvAdapter.changeListWeather(it)
            rvAdapter.notifyDataSetChanged()
        }
    }
}