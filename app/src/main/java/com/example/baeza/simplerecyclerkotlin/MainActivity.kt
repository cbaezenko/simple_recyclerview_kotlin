package com.example.baeza.simplerecyclerkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

import java.util.ArrayList

class MainActivity : AppCompatActivity(), RecyclerAdapter.ListItemClickListener {

    internal lateinit var mToast: Toast
    internal lateinit var mRecyclerView: RecyclerView
    internal lateinit var mRecyclerAdapter: RecyclerAdapter
    private val mPetList = ArrayList<Pet>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerAdapter = RecyclerAdapter(mPetList, this)

        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.adapter = mRecyclerAdapter

        preparingData()
    }

    //Filling the List with Pets to show on the RecyclerView
    private fun preparingData() {
        var pet = Pet("Kot", 10)
        mPetList.add(pet)

        pet = Pet("Kilka", 1)
        mPetList.add(pet)

        pet = Pet("Mango", 5)
        mPetList.add(pet)

        pet = Pet("Winnie", 8)
        mPetList.add(pet)
    }

    /*
    This method is for responding to clicks from our list.
   */
    override fun onListItemClick(clickedItemIndex: Int) {

        when (clickedItemIndex) {
            0 -> {
                mToast = Toast.makeText(this, mPetList[0].name!! + " ne urod", Toast.LENGTH_LONG)
                mToast.show()
            }
            1 -> {
                mToast = Toast.makeText(this, mPetList[1].name!! + " хорошая", Toast.LENGTH_LONG)
                mToast.show()
            }
            else -> {
                mToast = Toast.makeText(this, "Es un perro", Toast.LENGTH_LONG)
                mToast.show()
            }
        }
    }
}
