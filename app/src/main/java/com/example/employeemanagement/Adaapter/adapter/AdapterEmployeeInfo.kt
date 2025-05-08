package com.example.employeemanagement.Adaapter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.employeemanagement.Adaapter.model.EmplyeeInfo
import com.example.employeemanagement.R
import com.example.employeemanagement.databinding.ItemEmployeeInfoBinding

class AdapterEmployeeInfo:ListAdapter<EmplyeeInfo,AdapterEmployeeInfo.EmployeeViewHolder>(EmployeeDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeViewHolder {
        val binding = ItemEmployeeInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class EmployeeViewHolder(private val binding: ItemEmployeeInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(employee: EmplyeeInfo) {
            binding.id.text = "ID: ${employee.id}"
            binding.name.text = employee.name
            binding.salary.text = "Salary${employee.salary}"
            binding.age.text = "Age: ${employee.age}"
            binding.avatar.setImageResource(R.drawable.dummy_img) // You may want to use Glide/Picasso here
        }
    }

    class EmployeeDiffCallback : DiffUtil.ItemCallback<EmplyeeInfo>() {
        override fun areItemsTheSame(oldItem: EmplyeeInfo, newItem: EmplyeeInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EmplyeeInfo, newItem: EmplyeeInfo): Boolean {
            return oldItem == newItem
        }
    }
}

