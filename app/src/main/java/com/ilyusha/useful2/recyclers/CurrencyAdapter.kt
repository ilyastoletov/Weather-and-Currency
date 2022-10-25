package com.ilyusha.useful2.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ilyusha.useful2.R

class CurrencyAdapter(val currencies: ArrayList<Currency>) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder>() {

    class CurrencyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currencyImage: ImageView = itemView.findViewById(R.id.iv_main_currency)
        val currencyName: TextView = itemView.findViewById(R.id.tv_currency_name)
        val course: TextView = itemView.findViewById(R.id.tv_course)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_currency_irtem, parent, false)
        return CurrencyHolder(itemView)
    }


    override fun getItemCount(): Int {
        return currencies.size
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        holder.currencyImage.setImageResource(currencies[position].imageId)
        holder.currencyName.text = currencies[position].title
        holder.course.text = currencies[position].price
    }

}