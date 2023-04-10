package com.drovo.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.drovo.recyclerviewtest.adapter.PersonAdapter
import com.drovo.recyclerviewtest.databinding.ActivityMainBinding
import com.drovo.recyclerviewtest.interfaces.OnItemClickedListener
import com.drovo.recyclerviewtest.model.Person

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var personList: ArrayList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.setHasFixedSize(true)

        var person1: Person = Person(R.drawable.a, "i am a")
        var person2: Person = Person(R.drawable.b, "i am b")
        var person3: Person = Person(R.drawable.c, "i am c")

        personList = arrayListOf<Person>()
        personList.add(person1)
        personList.add(person2)
        personList.add(person3)

        val adapter: PersonAdapter = PersonAdapter(personList)

        binding.recycleView.adapter = adapter
        adapter.setOnItemclickedListener(object : OnItemClickedListener{
            override fun onItemClicked(position: Int) {
                Toast.makeText(this@MainActivity, "you have clicked "+position, Toast.LENGTH_SHORT).show()
            }
        })
    }
}