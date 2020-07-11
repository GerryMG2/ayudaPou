package com.pdm.atikapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.pdm.atikapp.databinding.FragmentMenuBinding
import kotlinx.android.synthetic.main.grid_element.view.*

class MenuAdapter(
    private val context: Context,
    private val image: Array<Int>,
    private val category: ArrayList<String>
): BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return category.size
    }

    //2
    override fun getItem(position: Int): Any {
        return category[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position:Int, convertView: View?, parent: ViewGroup?):View{
        val view = inflater.inflate(R.layout.grid_element,null)

        val img: ImageView = view.findViewById(R.id.category_img)
        img.setImageResource(image[position])
        val name: TextView = view.findViewById(R.id.category_name)
        println("armando dnetro del adapter categorias:")
        println(category[position])
        name.setText(category[position])

        view.card.setOnClickListener {
            it.findNavController().navigate(R.id.action_menuFragment_to_categoryFragment)
        }



        return view

        }
    }

