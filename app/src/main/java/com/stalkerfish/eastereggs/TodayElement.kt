/* This is the in-game game(?), where you need to answer what is the element*/

package com.stalkerfish.eastereggs

import android.app.Activity
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

        val listOfElements = TableOfElements.getElement()
        val randomElementIndex = kotlin.random.Random.nextInt(0,listOfElements.size)

        val atomicNumber: TextView? = view.findViewById(R.id.atomic_number)
        val atomicWeight: TextView? = view.findViewById(R.id.atomic_weight)
        val elementSymbol: TextView? = view.findViewById(R.id.element_symbol)
        val hintButton: LinearLayout? = view.findViewById(R.id.hint_button)
        val answer: EditText? = view.findViewById(R.id.answer)
        val acceptButton: Button? = view.findViewById(R.id.accept_button)

        val todayElement = listOfElements[randomElementIndex]

        atomicNumber?.text = todayElement.atomicNumber.toString()
        atomicWeight?.text = todayElement.atomicWeight.toString()
        elementSymbol?.text = todayElement.symbol

        var timesClicked = 0

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
                    requireActivity() as Activity, "Missing Answer",
                    "Input the element name in the TextBox!",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(
                        requireContext(),
                        www.sanju.motiontoast.R.font.helvetica_regular
                    )
                )
            }
            else if (answer?.text contentEquals(todayElement.name)) {
                MotionToast.darkColorToast(
                    requireContext() as Activity, "Wow, you found out the element",
                    "You earned a Hell Orb, it is used to travel to The Hell.",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(
                        requireContext(),
                        www.sanju.motiontoast.R.font.helvetica_regular
                    )
                )

                val hellOrb = HellActivity::class.java

                val orbAdded = Orb(hellOrb, "Hell Orb")
                OrbShelf.addOrb(orbAdded)
                Inventory.addItem(orbAdded)
                close()
            }
        }
    }

    private fun close() {
        val manager = requireActivity().supportFragmentManager
        manager.beginTransaction().remove(this).commit()
    }
}