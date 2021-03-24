package ru.abrus.androidanimations.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*
import ru.abrus.androidanimations.R
import ru.abrus.androidanimations.data.MainData

class MainAdapter(private val listener: (Class<*>) -> Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var data = arrayListOf<MainData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
    )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = data[position]

        holder.itemView.apply {
            mainText.text = item.text

            mainImage.setImageDrawable(getDrawable(context, item.image))

            mainBack.setOnClickListener {
                listener.invoke(item.cls)
            }
        }

    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}