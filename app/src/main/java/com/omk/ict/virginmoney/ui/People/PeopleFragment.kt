package com.omk.ict.virginmoney.ui.People

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.omk.ict.virginmoney.R
import com.omk.ict.virginmoney.databinding.FragmentPeopleBinding
import com.omk.ict.virginmoney.model.data.people.People
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint  // make sure it is also set in Activity
class PeopleFragment : Fragment(R.layout.fragment_people) {

    lateinit var binding: FragmentPeopleBinding

    //view model for current fragment
    // val viewModel by viewModels<PeopleViewmodel>()
    //activity view model
    val viewModel by activityViewModels<PeopleViewModel>()

//    @Inject  // make sure the AndroidEntryPoint is set
//    lateinit var api: EmployeeApi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPeopleBinding.inflate(inflater)

        // observe the changes in viewmodel liveData
        viewModel.people.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getPeople()

        return binding.root
    }

    private fun setupUI(peopleList: People) {
        binding.peopleList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PeopleAdapter(
                peopleList
            ) {item->


                viewModel.currentData=item
                //if the second parameter it mpve ot the function
//                findNavController().navigate(R.id.action_peopleFragment_to_detailFragment, bundleOf(Pair("FName", item.f)))
                findNavController().navigate(R.id.action_peopleFragment_to_detailsFragment)
            }

        }


    }
}