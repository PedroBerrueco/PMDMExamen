package com.pberrueco.examen.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pberrueco.examen.databinding.ItemBaseBinding

class BaseRVAdapter() : ListAdapter<BaseModel, BaseRVAdapter.BaseViewHolder>(BaseItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBaseBinding.inflate(layoutInflater, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val Item = getItem(position)
        //TODO Pintar datos
        holder.binding.tvTittle.text = Item.title // Si no fuera String, seria necesario .toString() detrás
        holder.binding.tvSubjetc.text = "${Item.subject.title} - ${Item.subject.classX} "
        holder.binding.tvTeacher.text = Item.teacherName
        holder.binding.tvDeadline.text = Item.date
    }

    inner class BaseViewHolder (val binding: ItemBaseBinding): RecyclerView.ViewHolder(binding.root)
}

object BaseItemCallback: DiffUtil.ItemCallback<BaseModel>(){
    override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
        return oldItem == newItem
    }
}