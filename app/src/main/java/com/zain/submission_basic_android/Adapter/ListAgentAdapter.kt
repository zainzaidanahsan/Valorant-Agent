package com.zain.submission_basic_android.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.zain.submission_basic_android.DataClass.ValorantAgent
import com.zain.submission_basic_android.R
import com.zain.submission_basic_android.UI.DetailActivity

class ListAgentAdapter(private val listAgent: ArrayList<ValorantAgent>) : RecyclerView.Adapter<ListAgentAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView = itemView.findViewById(R.id.tv_item_name)
        var jenisAgent : TextView = itemView.findViewById(R.id.tv_item_jenis_agent)
        var photo_agent : ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_agent_val, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var context = holder.itemView.context
        var valorantAgent = listAgent[position]
        holder.name.text = valorantAgent.name
        holder.jenisAgent.text = listAgent[position].jenisAgent
        holder.photo_agent.setImageResource(listAgent[position].photo_Agent)

        holder.itemView.setOnClickListener{
            var agentValorantt = ValorantAgent(valorantAgent.photo_Agent,valorantAgent.name, valorantAgent.jenisAgent, valorantAgent.desc, valorantAgent.skillOne,valorantAgent.skillTwo,valorantAgent.skillThree,valorantAgent.ult,valorantAgent.photoSkillOne,valorantAgent.photoSkillTwo,valorantAgent.photoSkillThree,valorantAgent.photoUlt)
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("data", agentValorantt)
            intent.putExtra("url",valorantAgent.urlAgentInfo)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listAgent.size
    }
}