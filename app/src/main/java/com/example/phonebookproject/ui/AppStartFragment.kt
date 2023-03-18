package com.example.phonebookproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phonebookproject.R
import com.example.phonebookproject.databinding.FragmentStartBinding


class AppStartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startApp.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }

    }

}