package com.example.uipart2.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uipart2.R
import com.example.uipart2.databinding.FragmentBlueBinding
import com.example.uipart2.utils.ArgumentManager

class BlueFragment : Fragment(R.layout.fragment_blue){

    private val binding: FragmentBlueBinding by lazy {
        val tmpBiding = FragmentBlueBinding.inflate(layoutInflater)
        tmpBiding
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d("BlueFragment", this.id.toString())

        val argManager = ArgumentManager()

        val counterValue = argManager.getCounter(arguments)
        binding.counter.text = "$counterValue"

        binding.textView.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.fragmentContainerViewBlueHost,
                    BlueFragment::class.java,
                    argManager.createArgs(counterValue + 1)
                )
                addToBackStack(null)

                commit()
            }
        }
    }
}