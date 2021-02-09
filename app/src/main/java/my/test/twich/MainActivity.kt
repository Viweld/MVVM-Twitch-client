package my.test.twich

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import my.test.twich.Adapter.TopGameAdapter
import my.test.twich.Interface.RetrofitTwichServices
import my.test.twich.Model.Game
import my.test.twich.Model.Top
import my.test.twich.Retrofit.Apifactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitTwichServices
    lateinit var linLayManager: LinearLayoutManager
    lateinit var tgAdapter: TopGameAdapter
    lateinit var alert: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Apifactory.retrofitTwichServices
        recyclerTopGame.setHasFixedSize(true)
        linLayManager = LinearLayoutManager(this)
        recyclerTopGame.layoutManager = linLayManager
        alert = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        getAllTopGamesList()
    }

    fun getAllTopGamesList() {
        alert.show()
        mService.getGame().enqueue(object : Callback<Game> {
            override fun onFailure(call: Call<Game>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<Game>,
                response: Response<Game>
            ) {
                tgAdapter = TopGameAdapter(baseContext, response.body() as Game)
                tgAdapter.notifyDataSetChanged()
                recyclerTopGame.adapter = tgAdapter
                alert.dismiss()
            }
        })
    }
}