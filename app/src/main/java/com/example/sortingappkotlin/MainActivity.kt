package com.example.sortingappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sortingappkotlin.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
 //   private var list=Array<String>(25){ ""}
    private var list1=Array<String>(25){ ""}
    private var list2=Array<String>(25){ ""}
    private var counterSort=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout1,FragmentSort(list1,-1,R.color.green_dark)).commit()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout2,FragmentSort(list1,-1,R.color.green_dark)).commit()
        }

        binding.choose.setOnClickListener {
            val list0=buildArray()

            list1=list0.copyOf()
            list2=list0.copyOf()
            counterSort=0


            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout1,FragmentSort(list1,0,R.color.green_dark)).commit()
            }
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout2,FragmentSort(list1,0,R.color.green_dark)).commit()
            }
        }

        binding.Sort.setOnClickListener {

            if (list1[0]=="") {
                return@setOnClickListener
            }
            if (counterSort>24) {
                return@setOnClickListener
            }


            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout2,FragmentSort(bubbleSort(list2,counterSort),counterSort,R.color.green)).commit()

            }

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout1,FragmentSort(insertSort(list1,counterSort),counterSort,R.color.yellow)).commit()

            }
            counterSort++

        }
    }

    private fun buildArray():Array<String> {
        val list = Array<String>(25) {""}
        for (i in 0 until 25) {
            list[i]=Random.nextInt(100).toString()
        }
        return list
    }

    private fun insertSort(array: Array<String>, rank:Int):Array<String> {
        val key = array[rank].toInt()
        var j=rank-1
        while (j>=0 && array[j].toInt()>key) {
            array[j+1]=array[j]
            array[j]=key.toString()
            j--
        }
        return array
    }

    private fun bubbleSort(array: Array<String>,rank:Int):Array<String> {
        for (j in 24 downTo rank + 1) {
            var temp = ""
            if (array[j].toInt()<array[j-1].toInt()) {
                temp = array[j]
                array[j]=array[j-1]
                array[j-1]=temp
            }

        }

        return array


    }


}