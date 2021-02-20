package com.hwave.foodapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var listOfFood = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFood()

        adapter = FoodAdapter(listOfFood, this)
        lvFoods.adapter = adapter
    }

    fun loadFood() {
        listOfFood.add(
            Food(
                "Coffee1",
                "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried.",
                R.drawable.food
            )
        )
        listOfFood.add(
            Food(
                "Coffee2",
                "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried.",
                R.drawable.food
            )
        )
        listOfFood.add(
            Food(
                "Coffee3",
                "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried.",
                R.drawable.food
            )
        )
    }

    inner class FoodAdapter : BaseAdapter {
        var context: Context? = null
        var listOfFoodsLocal = ArrayList<Food>()

        constructor(listOfFoods: ArrayList<Food>, context: Context) {
            listOfFoodsLocal = listOfFoods
            this.context = context
        }

        override fun getCount(): Int {
            return listOfFoodsLocal.size
        }

        override fun getItem(position: Int): Any {
            return listOfFoodsLocal[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = listOfFoodsLocal[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodView = inflator.inflate(R.layout.food_ticket, null)
            foodView.tvName.text = food.name
            foodView.tvDes.text = food.des
            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.ivFoodImage.setOnClickListener {

            }
            return foodView
        }

    }

    fun delete(index: Int) {
        listOfFood.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun add(index: Int) {
        listOfFood.add(index, listOfFood[index])
        adapter!!.notifyDataSetChanged()
    }
}