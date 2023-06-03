package com

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentFirstBinding
import com.remote.LoveModel
import com.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        clearTextView()

    }
    private fun initClicker(){
        with(binding){
            btnCalc.setOnClickListener {
                //Repository().getLoveMutableLiveData(edFirst.text.toString(),edSecond.text.toString())
                if (edFirst.text.isNotEmpty()&& edSecond.text.isNotEmpty()){
                    RetrofitService().api.getPercentage(
                        firstName = edFirst.text.toString(),
                        secondName = edSecond.text.toString()
                    ).enqueue(object : Callback<LoveModel>{
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {

                            if (response.isSuccessful){
                                findNavController().navigate(R.id.resultFragment,
                                    bundleOf("result" to response.body())
                                )
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            if (t is IOException){
                                Toast.makeText(
                                    context, "Check internet Connection",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }else{
                                Toast.makeText(context, "An error occurred",Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                }else{
                    Toast.makeText(context, "Please Write Names", Toast.LENGTH_SHORT).show()
            }
            }
        }
    }

    private fun clearTextView(){
        val clearEditText = arguments?.getBoolean("clearEditText")?: false
        if (clearEditText){
            binding.edFirst.text.clear()
            binding.edSecond.text.clear()
        }
    }
}
