package com.example.phonebookproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonebookproject.repository.AuthRepository
import com.example.phonebookproject.ui.adapter.ProfileAdapter
import com.example.phonebookproject.R
import com.example.phonebookproject.repository.RealtimeFirebaseRepository
import com.example.phonebookproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val authRepository = AuthRepository()

    private val dbRepository = RealtimeFirebaseRepository()

    private lateinit var adapter: ProfileAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ProfileAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        dbRepository.getPhone { adapter.setList(it) }
        binding.logoutButton.setOnClickListener{
            authRepository.logout()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
        binding.userEmail.text = authRepository.getEmail()

        binding.addPhone.setOnClickListener{
            dbRepository.addPhone(
                binding.nameField.text.toString(),
                binding.numberField.text.toString()
            )
        }
    }
}