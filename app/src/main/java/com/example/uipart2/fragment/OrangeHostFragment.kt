package com.example.uipart2.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.uipart2.R

class OrangeHostFragment : Fragment(R.layout.orange_host_fragment){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainerViewOrangeHost, OrangeFragment())
            commit()
        }
    }
}