package com.example.flash.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.flash.R
import com.example.flash.databinding.FragmentSignInBinding



class SignInFrag : Fragment() {

    private lateinit var binding : FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(layoutInflater,R.layout.fragment_sign_in,container,false)
        return binding.root
    }

}