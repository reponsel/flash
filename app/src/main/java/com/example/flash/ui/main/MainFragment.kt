package com.example.flash.ui.main

import android.R.attr.password
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.flash.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        private val mAuth: FirebaseAuth = FirebaseAuth.getInstance();
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        val email = "321akhilbabu@gmail.com"
        val pass = "hellotesting"
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
                        Toast.makeText(
                            context, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                    // ...
                })

    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
    }
}