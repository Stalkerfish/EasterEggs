/* This is the in-game game(?), where you need to answer what is the element*/

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class TodayElement: Fragment(){

    companion object {
        fun newInstance() = TodayElement()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todays_element_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title: TextView? = view.findViewById(R.id.title)
        val atomicNumber: TextView? = view.findViewById(R.id.atomic_number)
        val atomicWeight: TextView? = view.findViewById(R.id.atomic_weight)
        val elementSymbol: TextView? = view.findViewById(R.id.element_symbol)
        val hintButton: LinearLayout? = view.findViewById(R.id.hint_button)

        var timesClicked: Int = 0

        title?.isVisible = true

        hintButton?.setOnClickListener {
            timesClicked++

            when(timesClicked){
                1 -> atomicWeight?.isVisible = true
                2 -> atomicNumber?.isVisible = true
                3 -> elementSymbol?.isVisible = true
            }
        }
    }
}