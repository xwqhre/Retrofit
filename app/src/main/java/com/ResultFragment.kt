package com

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentResultBinding
import com.remote.LoveModel


class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            val result = arguments?.getSerializable("result") as LoveModel
            tvFirst.text= result.firstName
            tvSecond.text= result.secondName
            tvPercentage.text= result.percentage + "%"
            tvResult.text = result.result

            btnAgain.setOnClickListener {
                val bundle = Bundle().apply {
                    putBoolean("clearEditText", true)
                }

                findNavController().navigate(R.id.firstFragment, bundle)
                }
            }
        }
    }