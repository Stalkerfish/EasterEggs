package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.DialogFragment

class WardrobeShelf: DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wardrobe_shelf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lvOrbs: ListView? = view.findViewById(R.id.lvOrbs)

        val mOrbList = WardrobeHelper(requireContext()).getOrbsList()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, mOrbList)

        lvOrbs?.adapter = adapter
    }
}