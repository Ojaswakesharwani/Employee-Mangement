package com.example.employeemanagement.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeemanagement.Adaapter.adapter.AdapterEmployeeInfo
import com.example.employeemanagement.Adaapter.adapter.EmployeeViewModel
import com.example.employeemanagement.Adaapter.model.EmplyeeInfo
import com.example.employeemanagement.R
import com.example.employeemanagement.databinding.FragmentGetAllEmpBinding
import kotlinx.coroutines.launch


class GetAllEmpFragment : Fragment() {

    private var _binding: FragmentGetAllEmpBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AdapterEmployeeInfo
    private val viewModel = EmployeeViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentGetAllEmpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdapterEmployeeInfo()
        binding.rvEmployeeInfo.layoutManager= LinearLayoutManager(requireContext())
        binding.rvEmployeeInfo.adapter = adapter


        //Observe data
        viewModel.employeeList.observe(viewLifecycleOwner) { employeeList ->
            adapter.submitList(employeeList)
        }

        //fetch from api
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchEmployees()
        }

       /* // Dummy employee list
        val dummyList = listOf(
            EmplyeeInfo(1, "Amit Sharma", 50000, 28, R.drawable.dummy_img),
            EmplyeeInfo(2, "Neha Verma", 60000, 26, R.drawable.dummy_img),
            EmplyeeInfo(3, "Rajesh Kumar", 45000, 35, R.drawable.dummy_img),
            EmplyeeInfo(4, "Sonia Rani", 70000, 30, R.drawable.dummy_img)
        )

        adapter.submitList(dummyList)*/

    }


}