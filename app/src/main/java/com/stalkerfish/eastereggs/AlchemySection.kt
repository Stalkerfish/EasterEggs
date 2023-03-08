/* This is...*/

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class AlchemySection: Fragment() {

    companion object {
        fun newInstance() = AlchemySection()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alchemy_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sign: TextView? = view.findViewById(R.id.not_implemented_sign)

        sign?.isVisible = true
    }
}