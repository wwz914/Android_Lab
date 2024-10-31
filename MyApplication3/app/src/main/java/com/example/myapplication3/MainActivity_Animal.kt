package com.example.myapplication3

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.myapplication3.model.Animal

class MainActivity_Animal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animal_main)

        //初始化数据
        val animalData = listOf(
            Animal("cat",R.drawable.cat),
            Animal("Tiger",R.drawable.tiger),
            Animal("Monkey",R.drawable.monkey),
            Animal("Elephant",R.drawable.elephant),
            Animal("Dog",R.drawable.dog),
            Animal("Lion",R.drawable.lion)
        )

        //将数据转化成Map列表
        val animalList =animalData.map{animal->
            mapOf("name" to animal.name,"image" to animal.imageResource)
        }

        //创建适配器
        val adapter = SimpleAdapter(
            this,
            animalList,
            R.layout.animal_item,
            arrayOf("name","image"),
            intArrayOf(R.id.textViewName,R.id.imageViewImage)
        )

        //设置适配器到ListView
        val listView =findViewById<ListView>(R.id.listViewAnimal)
        listView.adapter =adapter

        //处理点击事件
        listView.setOnItemClickListener{parent,_,position,_ ->
            val animal =parent.getItemAtPosition(position) as Map<String,Any>
            val name =animal["name"].toString()
            Toast.makeText(this, "$name", Toast.LENGTH_SHORT).show()
        }
    }
}
