package com.omk.ict.virginmoney.ui.People

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omk.ict.virginmoney.R
import com.omk.ict.virginmoney.databinding.ItemPeopleBinding
import com.omk.ict.virginmoney.model.data.people.People
import com.omk.ict.virginmoney.model.data.people.PeopleItem

class PeopleAdapter(
    private val persons: People,
    val clickListner: (PeopleItem) -> Unit

) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //private val binding = ItemPersonBinding.bind(itemView)
        private val binding = ItemPeopleBinding.bind(itemView)

        val rootItem=binding.cItemView
        fun setupUI(fact: PeopleItem) {
            //binding.tvPersonFact.text = fact?.get(position)?.firstNameModel
            binding.tvName.text = "${fact?.firstNameModel} ${fact.lastNameModel}"
            binding.tvJob.text = "${fact?.jobtitleModel}"

            Glide.with(itemView.context)
                .load(fact.avatarModel)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivUserImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapter.PeopleViewHolder {
        return PeopleAdapter.PeopleViewHolder(
            //LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_people, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PeopleAdapter.PeopleViewHolder, position: Int) {
        holder.setupUI(persons[position])
        holder.rootItem.setOnClickListener {
            clickListner.invoke(persons[position])
        }
    }

    override fun getItemCount() = persons.size
}