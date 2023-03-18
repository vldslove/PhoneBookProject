package com.example.phonebookproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phonebookproject.repository.AuthRepository
import com.example.phonebookproject.R
import com.example.phonebookproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val authRepository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (authRepository.isUserLogin()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AppStartFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment())
                .commit()
        }

    }

}