package com.ilyusha.useful2.screens


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ilyusha.useful2.R
import com.ilyusha.useful2.data.vm.WeatherViewModel
import com.ilyusha.useful2.databinding.FragmentWeatherBinding
import com.ilyusha.useful2.recyclers.weather.WeatherAdapter


class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding
    lateinit var wViewModel: WeatherViewModel
    lateinit var rvWeather: RecyclerView
    lateinit var rvAdapter: WeatherAdapter
    lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_weather, container, false)
        binding = DataBindingUtil.bind<FragmentWeatherBinding>(v.root)!!
        wViewModel = WeatherViewModel()
        prefs = requireContext().getSharedPreferences("WEATHER", Context.MODE_PRIVATE)

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

    fun putCityToPrefs(data: String) {
        val prefs = prefs.edit()
        prefs.putString("city_name", data)
        prefs.commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityName = prefs.getString("city_name", "Тольятти")
        reloadFragment()

        wViewModel.weatherHoursPrediction.observe(viewLifecycleOwner) {
            rvAdapter.changeListWeather(it)
            rvAdapter.notifyDataSetChanged()
        }

        val buttonChangeCity = binding.changeCityButton
        buttonChangeCity.setOnClickListener {
            it.visibility = View.GONE
            binding.cityName.visibility = View.GONE
            binding.cardCityNames.visibility = View.VISIBLE
            binding.commitCityChange.visibility = View.VISIBLE
        }

        val spinnerCityList = binding.spinnerCityNames
        val cityListArrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.city_names, android.R.layout.simple_spinner_dropdown_item)
        spinnerCityList.adapter = cityListArrayAdapter
        spinnerCityList.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                putCityToPrefs(parent!!.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val commitCityChangesButton: Button = binding.commitCityChange
        commitCityChangesButton.setOnClickListener {
            it.visibility = View.GONE
            binding.cityName.visibility = View.VISIBLE
            binding.changeCityButton.visibility = View.VISIBLE
            binding.cardCityNames.visibility = View.GONE
            Toast.makeText(requireContext(), "Изменения приняты!", Toast.LENGTH_SHORT).show()
            reloadFragment()
        }

    }

    fun reloadFragment() {
        val cityName = prefs.getString("city_name", "Тольятти")
        binding.cityName.text = cityName
        wViewModel.getCityWeather(cityName!!)
        wViewModel.getCurrenciesCourse()
    }
}
