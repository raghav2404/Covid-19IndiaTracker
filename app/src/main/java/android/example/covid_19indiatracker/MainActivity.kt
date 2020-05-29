package android.example.covid_19indiatracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.gson.Gson
import android.widget.AbsListView
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {
    //Lateinit is a promise to the compiler that the variable will be lately initialized i.e the value will be assigned to the variable in future.
    //  lateinit var listAdaptor: ListAdaptor
    lateinit var stateAdaptor: StateAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item_header, list, false))
        //  list.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item_header,list,false)
        button.setOnClickListener {
            startActivity(Intent(this,Info::class.java))

        }
        fetchResults()
        swipeToRefresh.setOnRefreshListener {
            fetchResults()
        }

        list.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {}
            override fun onScroll(
                view: AbsListView,
                firstVisibleItem: Int,
                visibleItemCount: Int,
                totalItemCount: Int
            ) {
                if (list.getChildAt(0) != null) {
                    swipeToRefresh.isEnabled = list.firstVisiblePosition === 0 && list.getChildAt(
                        0
                    ).getTop() === 0
                }
            }
        })
    }



    private fun fetchResults() {
        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) {
                Client.api.clone().execute()
            }
            if (response.isSuccessful) {
                val data = Gson().fromJson(response.body?.string(), Response::class.java)
                launch(Dispatchers.Main) {
                    bindCombinedData(data.statewise[0])
                     bindStatewiseData(data.statewise.subList(0,data.statewise.size))}
                }

            }
        }

   // private fun bindStatewiseData(subList: List<StatewiseItem>) {
     //   listAdaptor = ListAdaptor(subList)
    //    list.adapter = listAdaptor
  //  }
private fun bindStatewiseData(subList: List<StatewiseItem>)
   {
       stateAdaptor=StateAdapter(subList)
       list.adapter=stateAdaptor


   }


    private fun bindCombinedData(data: StatewiseItem) {
        val lastUpdatedTime= data.lastupdatedtime
        val simpleDateFormat=SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        lastUpdatedTv.text = " Last Updated\n  ${getTimeAgo(simpleDateFormat.parse(lastUpdatedTime))}"
            confirmedTv.text = data.confirmed
        activeTv.text = data.active
        recoveredTv.text=data.recovered
        deceasedTv.text=data.deaths

    }





fun getTimeAgo(past:Date):String
    {
    val now=Date()
        val seconds:Long= TimeUnit.MILLISECONDS.toSeconds(now.time-past.time)
        val minutes:Long=TimeUnit.MILLISECONDS.toMinutes(now.time-past.time)
        val hours:Long=TimeUnit.MILLISECONDS.toHours(now.time-past.time)
        return  when
        {
            seconds<60 ->{"Few Seconds ago"}
            minutes<60 ->{"$minutes minutes ago"}
           hours<24 ->{"$hours hours ${minutes%60} min ago"}
            else ->{ SimpleDateFormat("dd/MM/yy, hh:mm a").format(past).toString()}

        }

    }
}
