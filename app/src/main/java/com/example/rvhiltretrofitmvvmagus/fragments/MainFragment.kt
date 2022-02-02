package com.example.rvhiltretrofitmvvmagus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rvhiltretrofitmvvmagus.R
import com.example.rvhiltretrofitmvvmagus.adapter.TvShowAdapter
import com.example.rvhiltretrofitmvvmagus.databinding.ActivityMainBinding
import com.example.rvhiltretrofitmvvmagus.databinding.ActivityMainBinding.inflate
import com.example.rvhiltretrofitmvvmagus.databinding.FragmentMainBinding
import com.example.rvhiltretrofitmvvmagus.databinding.FragmentMainBinding.inflate
import com.example.rvhiltretrofitmvvmagus.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var tvShowAdapter: TvShowAdapter
    private val tvShowViewModel: TvShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        setUpRecyclerView()


        return binding.root
    }

    private fun setUpRecyclerView() {
        tvShowAdapter = TvShowAdapter()
        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context.applicationContext, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }


        tvShowViewModel.responseTvShow.observe(viewLifecycleOwner, { listTvShows ->
            tvShowAdapter.tvShows = listTvShows

        })
    }


}