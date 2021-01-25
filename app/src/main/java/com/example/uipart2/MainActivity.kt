package com.example.uipart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.uipart2.databinding.ActivityMainBinding
import com.example.uipart2.fragment.BlueHostFragment
import com.example.uipart2.fragment.OrangeHostFragment

class MainActivity : AppCompatActivity() {

    private val firstFragment = OrangeHostFragment()
    private val secondFragment = BlueHostFragment()

    private val binding: ActivityMainBinding by lazy {
        val tmpBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tmpBiding.root)
        tmpBiding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //var firstFragment: Fragment? = null
        //var secondFragment: Fragment? = null

        //if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {

                setReorderingAllowed(true)
                add(R.id.fragmentContainerView1, firstFragment)
                add(R.id.fragmentContainerView1, secondFragment)
                setPrimaryNavigationFragment(firstFragment)
                //addToBackStack(null)

                commit()
            }
        //}



        binding.buttonOrange.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                hide(secondFragment)
                show(firstFragment)
                setPrimaryNavigationFragment(firstFragment)
                commit()
            }
        }

        binding.buttonBlue.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                hide(firstFragment)
                show(secondFragment)
                setPrimaryNavigationFragment(secondFragment)
                commit()
            }
        }
    }
}