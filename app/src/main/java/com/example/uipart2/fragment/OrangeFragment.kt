package com.example.uipart2.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uipart2.R
import com.example.uipart2.databinding.FragmentOrangeBinding
import com.example.uipart2.utils.ArgumentManager

class OrangeFragment : Fragment(R.layout.fragment_orange){

    private val binding: FragmentOrangeBinding by lazy {
        val tmpBiding = FragmentOrangeBinding.inflate(layoutInflater)
        tmpBiding
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d("OrangeFragment", "onViewCreated")
        Log.d("OrangeFragment", this.id.toString())

        val argManager = ArgumentManager()

        val counterValue = argManager.getCounter(arguments)
        binding.counter.text = "$counterValue"

        binding.textView.setOnClickListener {

            Log.d("OrangeFragment", "OnClickListener")

            parentFragmentManager.beginTransaction().apply {
                //val fragment = FirstFragment()

                setReorderingAllowed(true)
                add(R.id.fragmentContainerViewOrangeHost, OrangeFragment::class.java, argManager.createArgs(counterValue + 1))
                addToBackStack(null)

                commit()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}