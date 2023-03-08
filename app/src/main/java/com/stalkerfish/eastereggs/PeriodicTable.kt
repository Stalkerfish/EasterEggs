package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class PeriodicTable: Fragment() {

    companion object {
        fun newInstance() = PeriodicTable()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.periodic_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sign: TextView? = view.findViewById(R.id.not_implemented_sign)

        sign?.isVisible = true
    }
}