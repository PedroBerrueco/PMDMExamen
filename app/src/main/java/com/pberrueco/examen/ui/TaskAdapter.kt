package com.pberrueco.examen.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pberrueco.examen.data.network.model.TaskResponse
import com.pberrueco.examen.databinding.ItemBaseBinding

class TaskAdapter() : ListAdapter<TaskResponse, TaskAdapter.BaseViewHolder>(BaseItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBaseBinding.inflate(layoutInflater, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val Item = getItem(position)
        //TODO Pintar datos
        holder.binding.tvTittle.text = Item.taskTitle // Si no fuera String, seria necesario .toString() detrás
        holder.binding.tvProject.text = Item.project.title
        holder.binding.tvEmployee.text = Item.employee
        holder.binding.tvDeadline.text = Item.deadLine
    }

    inner class BaseViewHolder (val binding: ItemBaseBinding): RecyclerView.ViewHolder(binding.root)
}

object BaseItemCallback: DiffUtil.ItemCallback<TaskResponse>(){
    override fun areItemsTheSame(oldItem: TaskResponse, newItem: TaskResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskResponse, newItem: TaskResponse): Boolean {
        return oldItem == newItem
    }
}