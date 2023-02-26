package com.stalkerfish.eastereggs

/**
* This class deal with the Wardrobe button click,
* it shows a Dialog containing a ListView of Orbs stored
* in the {@link OrbShelf} */

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

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
        val emptyListSign: TextView? = view.findViewById(R.id.emptyOrbs)

        val mOrbList = WardrobeHelper(requireContext()).getOrbsList()

        if (mOrbList.isEmpty())
            emptyListSign?.isVisible = true
        else {
            val adapter = ArrayAdapter(requireContext(), R.layout.row, mOrbList)
            lvOrbs?.adapter = adapter

            wardrobeCallback(lvOrbs, adapter)
        }
    }

    private fun wardrobeCallback(list: ListView?, adapter: ArrayAdapter<*>) {
        list?.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, position, _ ->
                val selectedOrb = parent.getItemAtPosition(position) as String

                val jOrbsList = OrbShelf.getOrbs()

                val mOrb = Pair(selectedOrb, jOrbsList[position])

                try {
                    WardrobeHelper(requireContext()).onTravel(mOrb.second)
                    adapter.notifyDataSetChanged()

                    this.dismiss()
                }
                catch (_: java.lang.IndexOutOfBoundsException) {
                    MotionToast.createToast(
                        requireActivity(), "Wardrobe Failed",
                        "YOU DON'T HAVE ANY ORBS!", MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.SHORT_DURATION,
                        Typeface.DEFAULT_BOLD
                    )
                }
            }
    }
}