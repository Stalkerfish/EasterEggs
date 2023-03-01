package com.stalkerfish.eastereggs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment

class TodayElement: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.earth_todays_element_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sign: TextView? = view.findViewById(R.id.not_implemented_sign)
        val retrieveBtn: Button? = view.findViewById(R.id.retrieve_item)

        sign?.isVisible = true

        retrieveBtn?.setOnClickListener {
            val random = (0..10).random()
            if (random % 2 == 0)
                Inventory.addItem(Orb(HellActivity::class.java, "Hell Orb"))
            else
                Inventory.addItem(Orb(HomeActivity::class.java, "Home Orb"))
        }
    }
}