package com.example.flash.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.flash.R
import com.example.flash.databinding.FragmentSignupBinding
import com.example.flash.ui.main.MainViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class SignUpFrag : Fragment() {

    private lateinit var binding : FragmentSignupBinding
    private lateinit var viewModel : AuthViewModel
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(layoutInflater,R.layout.fragment_signup,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.submitBt.setOnClickListener {
            if (binding.editTextEmailID.text.isNotEmpty() && binding.editTextPassword.text.isNotEmpty()){
                val email = binding.editTextEmailID.text.toString()
                val pass = binding.editTextPassword.text.toString()
                mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(requireActivity(),
                        OnCompleteListener<AuthResult?> { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("tag", "createUserWithEmail:success")
                                val user = mAuth.currentUser

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.d("tag", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()

                            }
                        })
            }
        }
    }




}