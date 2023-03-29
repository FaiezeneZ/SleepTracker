package com.example.sleeptracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SleepAdapter(private val context: Context, private val sleeps: List<Sleep>) :
    RecyclerView.Adapter<SleepAdapter.SleepViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sleep_item, parent, false)
        return SleepViewHolder(view)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val article = sleeps[position]
        holder.bind(article)
    }


    override fun getItemCount(): Int {
        return sleeps.size
    }

    class SleepViewHolder(val itemView: View) : ViewHolder(itemView) {
        private val enterDate : TextView
        private val displayDate : TextView
        private val enterHour : TextView
        private val displayHour : TextView

        //initialize members through init
        init {

            enterDate = itemView.findViewById(R.id.entDate_tv)
            displayDate= itemView.findViewById(R.id.fillDate_tv)
            enterHour = itemView.findViewById(R.id.entHours_tv)
            displayHour = itemView.findViewById(R.id.fillHours_tv)
        }

        fun bind(sleeps: Sleep)
        {
            enterDate.text = "Date:"
            displayDate.text = sleeps.date.toString()
            enterHour.text = "Hour:"
            displayHour.text = sleeps.hour.toString()
        }



    }


}



