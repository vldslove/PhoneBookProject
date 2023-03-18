package com.example.phonebookproject.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.phonebookproject.model.PhoneNumber
import com.example.phonebookproject.databinding.ItemPhoneBinding

class ProfileViewHolder(private val binding: ItemPhoneBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(phoneNumber: PhoneNumber) {
        binding.run {
            userName.text = phoneNumber.name
            userNumber.text = phoneNumber.number
        }
    }
}