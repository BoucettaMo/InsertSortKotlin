package com.example.sortingappkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sortingappkotlin.databinding.FragmentSortBinding

class FragmentSort(private val list:Array<String>,private val key:Int,private val color:Int) : Fragment() {
    private var _binding: FragmentSortBinding?=null
    private val binding get() = _binding!!
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentSortBinding.inflate(layoutInflater,container,false)
        adapter= MyAdapter(requireContext(),list,key,color)
        binding.recylerview.adapter=adapter
        binding.recylerview.layoutManager=GridLayoutManager(requireContext(),5)
        return binding.root
    }


}