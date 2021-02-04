package my.test.twich.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import my.test.twich.Model.Movie

import my.test.twich.R

class TopGameAdapter(
    private val context: Context,
    private val gameList: MutableList<Movie>
) : RecyclerView.Adapter<TopGameAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val image: ImageView = itemView.image_game
        val txt_name: TextView = itemView.txt_name
        //val txt_channals: TextView = itemView.txt_channals
        //val txt_viewers: TextView = itemView.txt_viewers

        fun bind(listItem: Movie) {
            /*image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.image_game}", Toast.LENGTH_SHORT)
                    .show()
            }*/
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

    override fun getItemCount() = gameList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = gameList[position]
        holder.bind(listItem)

        //Picasso.get().load(gameList[position].cover).into(holder.image)
        //holder.txt_name.text = gameList[position].name
        //holder.txt_channals.text = gameList[position].
        holder.txt_name.text = gameList[position].name


    }

}