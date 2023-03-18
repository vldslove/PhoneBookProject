package com.example.phonebookproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebookproject.model.PhoneNumber
import com.example.phonebookproject.databinding.ItemPhoneBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileViewHolder>() {

    private var list = arrayListOf<PhoneNumber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            ItemPhoneBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setList(list: ArrayList<PhoneNumber>) {
        this.list = list
        notifyDataSetChanged()
    }
}