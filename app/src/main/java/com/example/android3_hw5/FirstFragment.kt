package com.example.android3_hw5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.android3_hw5.databinding.ActivityMainBinding
import com.example.android3_hw5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDecrease.setOnClickListener{
            val result = (binding.tvResult.text.toString().toInt() - 1)
            if(result.equals(-1)
                ){
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SecondFragment())
                    .addToBackStack(null)
                    .commit()
            } else {
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnIncrease.setOnClickListener{
            val result = (binding.tvResult.text.toString().toInt() + 1)
            binding.tvResult.text = result.toString()
        }
    }

}