package com.stalkerfish.eastereggs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment

class WardrobeShelf: DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.fragment_wardrobe_shelf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lvOrbs: ListView? = view.findViewById(R.id.lvOrbs)
        val emptyList: TextView? = view.findViewById(R.id.emptyOrbs)

        val mOrbList = WardrobeHelper(requireContext()).getOrbsList()

        if (mOrbList.isEmpty())
            emptyList?.isVisible = true
        else {
            val adapter = ArrayAdapter(requireContext(), R.layout.row, mOrbList)
            lvOrbs?.adapter = adapter
        }
    }
}