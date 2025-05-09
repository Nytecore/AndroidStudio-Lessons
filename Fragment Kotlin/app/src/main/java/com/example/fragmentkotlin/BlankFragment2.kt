package com.example.fragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.fragmentkotlin.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    private var _binding : FragmentBlank2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank2Binding.inflate(inflater , container , false)
        val view = binding.root
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            val kullaniciAdi = BlankFragment2Args.fromBundle(it).username
            binding.textView2.text = kullaniciAdi
        }


        binding.button2.setOnClickListener {
            val action = BlankFragment2Directions.actionBlankFragment22ToBlankFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}