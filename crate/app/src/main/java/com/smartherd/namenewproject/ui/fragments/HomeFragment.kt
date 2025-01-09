package com.smartherd.namenewproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.smartherd.namenewproject.R
import com.smartherd.namenewproject.ViewModels.AllMovesViewModel
import com.smartherd.namenewproject.adapters.MoviesViewPagerAdapter
import com.smartherd.namenewproject.data.models.MovesModel

//import com.smartherd.namenewproject.data.pojo.RandomMealResponse

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var randomMealId = ""

    private lateinit var root_home: LinearLayout
    private lateinit var grid_homeMoves: GridView
    private lateinit var viewPager: androidx.viewpager2.widget.ViewPager2
    private lateinit var wormDotsIndicator: com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

    private lateinit var myAdapter: MoviesViewPagerAdapter
    private lateinit var allMoveisViewModel: AllMovesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        myAdapter = MoviesViewPagerAdapter()
        allMoveisViewModel = ViewModelProviders.of(this)[AllMovesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_home, container, false)


        imelmnt(view)


        return view
    }




    fun setAdapters(){
        viewPager.adapter = myAdapter
        wormDotsIndicator.attachTo(viewPager)
    }

    private fun observeMoves() {
        allMoveisViewModel.observeCategories().observe(viewLifecycleOwner,object : Observer<List<MovesModel>> {
            override fun onChanged(t: List<MovesModel>?) {
                myAdapter.setMovesList(t!!,4)
            }

        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapters()
        observeMoves()
    }

    private fun imelmnt(view: View) {
        root_home = view.findViewById(R.id.root_home)
        viewPager = view.findViewById(R.id.viewPager)
        grid_homeMoves = view.findViewById(R.id.grid_homeMoves)
        wormDotsIndicator = view.findViewById(R.id.wormDotsIndicator)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}