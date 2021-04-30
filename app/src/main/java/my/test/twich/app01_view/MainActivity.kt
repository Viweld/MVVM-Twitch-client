package my.test.twich.app01_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import my.test.twich.R
import my.test.twich.app02_viewModel.GamesViewModel
import kotlin.reflect.KClass

//import my.test.twich.app03_data.db.GameDatabase

//lateinit var db: GameDatabase
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var linLayManager: LinearLayoutManager
    private lateinit var tgAdapter: TopGameAdapter
    //private lateinit var viewModel: GamesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //db = GameDatabase.getInstance(this)

        val recyclerTopGame: RecyclerView = findViewById(R.id.recyclerTopGame)
        recyclerTopGame.setHasFixedSize(true)
        linLayManager = LinearLayoutManager(this)
        recyclerTopGame.layoutManager = linLayManager
        //viewModel=ViewModelProvider(this).get(GamesViewModel::class.java)
        val viewModel:GamesViewModel by viewModels()

        viewModel.getGames().observe(this, Observer { games ->
            games?.let {
                tgAdapter = TopGameAdapter(baseContext, games)
                tgAdapter.notifyDataSetChanged()
                recyclerTopGame.adapter = tgAdapter
            }
        })


    }


}