package com.omk.ict.virginmoney.ui.People.Details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.omk.ict.virginmoney.R
import com.omk.ict.virginmoney.databinding.FragmentDetailsBinding
import com.omk.ict.virginmoney.databinding.FragmentPeopleBinding
import com.omk.ict.virginmoney.ui.People.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    lateinit var binding: FragmentDetailsBinding
    val viewModel by activityViewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment

        viewModel.currentData.let {
            binding.tvUserName.text = "Full Name: ${it.firstNameModel}  ${it.lastNameModel}"
            binding.tvJobTitle.text = "Job Title: ${it.jobtitleModel}"
            binding.tvEmail.text = "Email: ${it.emailModel}"
            binding.tvFavoriteColor.text = "Favorite Color: ${it.favouriteColorModel}"


            Glide.with(requireContext())
                .load(it.avatarModel)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.tvProfilePicture)
        }
        return binding.root
    }


}