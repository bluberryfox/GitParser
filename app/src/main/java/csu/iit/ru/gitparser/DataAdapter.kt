package csu.iit.ru.gitparser

/**
 * Created by user on 10.02.2018.
 */

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DataAdapter(val userList: ArrayList<GitHubRepositoryInfo>): RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.repo?.text = userList[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val repo = itemView.findViewById<TextView>(R.id.repo)

    }

}