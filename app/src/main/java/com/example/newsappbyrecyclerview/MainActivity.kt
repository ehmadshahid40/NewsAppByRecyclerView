package com.example.newsappbyrecyclerview

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappbyrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),NewsItemClicked {

    lateinit var binding: ActivityMainBinding

    lateinit var newsListAdapter: NewsListAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

       newsListAdapter = NewsListAdapter(fetchData(),this)


            binding.recyclerView.adapter = newsListAdapter
    }
    private fun fetchData(): ArrayList<String>{
        val list = ArrayList<String>()
            for(i in 0 until 30){

                list.add("Item $i")
            }


        return list
    }
    override fun onItemClicked(item: String)
    {
        Toast.makeText(this,"clicked item is $item", Toast.LENGTH_LONG).show()
    }
}
