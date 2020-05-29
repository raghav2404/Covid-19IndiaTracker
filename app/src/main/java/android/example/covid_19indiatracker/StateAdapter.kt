package android.example.covid_19indiatracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_list.view.*

class StateAdapter (val list:List<StatewiseItem>):BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View {
      val view=p1 ?: LayoutInflater.from(p2.context).inflate(R.layout.item_list,p2,false)
        val item=list[p0]
        view.ConfirmedTv.text=SpannableDelta("${item.confirmed}\n ↑ ${item.deltaconfirmed ?: "0"}","#D32F2F" ,item.confirmed?.length ?: 0)
        view.RecoveredTv.text= SpannableDelta("${item.recovered}\n ↑ ${item.deltarecovered ?: "0"}","#388E3C" ,item.recovered?.length ?: 0)
        view.DeceasedTv.text= SpannableDelta("${item.deaths}\n ↑ ${item.deltadeaths ?: "0"}","#FBC02D" ,item.deaths?.length ?: 0)
        view.ActiveTv.text= SpannableDelta("${item.active}\n ↑ ${item.deltaactive ?: "0"}","#1976D2" ,item.active?.length ?: 0)
        view.stateTv.text=item.state
        return  view
    }

    override fun getItem(p0: Int)=list[p0]

    override fun getItemId(p0: Int)= p0.toLong()

    override fun getCount()=list.size

}