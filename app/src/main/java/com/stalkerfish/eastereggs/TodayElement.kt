/* This is the in-game game(?), where you need to answer what is the element*/

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class TodayElement: Fragment() {

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
        val answer: EditText? = view.findViewById(R.id.answer)
        val acceptButton: Button? = view.findViewById(R.id.accept_button)

        var timesClicked = 0

        title?.isVisible = true

        hintButton?.setOnClickListener {
            timesClicked++

            when (timesClicked) {
                1 -> atomicWeight?.isVisible = true
                2 -> atomicNumber?.isVisible = true
                3 -> elementSymbol?.isVisible = true
            }
        }

        acceptButton?.setOnClickListener {

            if (answer?.text?.isEmpty() == true) {
                MotionToast.darkColorToast(
                    requireActivity(), "Missing Answer", "Input the element name in the TextBox!",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(
                        requireContext(),
                        www.sanju.motiontoast.R.font.helvetica_regular
                    )
                )
            } else {
                TODO()
            }
        }
    }
}

