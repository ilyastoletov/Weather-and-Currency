package com.ilyusha.useful2.recyclers.weather

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ilyusha.useful2.R

class WeatherAdapter(): RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    var weathers: ArrayList<WeatherData> = arrayListOf()

    class WeatherHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val timeText: TextView = itemView.findViewById(R.id.tv_time)
        val conditionImage: ImageView = itemView.findViewById(R.id.condition_image)
        val tempText: TextView = itemView.findViewById(R.id.tv_temperature)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.weather_mini_item, parent, false)
        return WeatherHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.timeText.text = weathers[position].time
        holder.conditionImage.setImageResource(weathers[position].conditionImageId)
        holder.tempText.text = weathers[position].temp
    }

    override fun getItemCount() = weathers.size

    @SuppressLint("NotifyDataSetChanged")
    fun changeListWeather(list: ArrayList<WeatherData>) {
        weathers = list
    }
}