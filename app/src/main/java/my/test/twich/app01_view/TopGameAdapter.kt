package my.test.twich.app01_view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import my.test.twich.app03_data.model.Game
import my.test.twich.app03_data.model.GameX

import my.test.twich.R

class TopGameAdapter(
    private val context: Context,
    private val gameList: Game
) : RecyclerView.Adapter<TopGameAdapter.MyViewHolder>() {

    //init{
    //    Log.d("test_adapter", gameList.top[5].game.name.toString())
    //}

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.image_game
        val txt_name: TextView = itemView.txt_name
        val txt_channels: TextView = itemView.txt_channels
        val txt_viewers: TextView = itemView.txt_viewers

        //Пригодится еще
        fun bind(listItem: GameX) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.image_game}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = gameList.top.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = gameList.top[position].game
        holder.bind(listItem)

        //Log.d("test_adapter", gameList.top[5].game.name.toString())

        Glide.with(context).load(gameList.top[position].game.box.medium).into(holder.image)
        holder.txt_viewers.text = gameList.top[position].viewers.toString()
        holder.txt_channels.text = gameList.top[position].channels.toString()
        holder.txt_name.text = gameList.top[position].game.name

    }


}