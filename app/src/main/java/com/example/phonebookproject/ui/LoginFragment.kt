package com.example.phonebookproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phonebookproject.repository.AuthRepository
import com.example.phonebookproject.R
import com.example.phonebookproject.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    private val authRepository = AuthRepository()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            authRepository.register(
                binding.loginText.text.toString(),
                binding.passwordText.text.toString(),
                {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .commit()
                },
                {
                    binding.errorText.text = it.toString()
                })
        }
        binding.loginButton.setOnClickListener {
            authRepository.login(
                binding.loginText.text.toString(),
                binding.passwordText.text.toString(),
                {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .commit()
                },
                {
                    binding.errorText.text = it.toString()

                })
        }

    }

}