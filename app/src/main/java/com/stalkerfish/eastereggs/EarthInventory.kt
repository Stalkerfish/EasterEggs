package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment

class EarthInventory: DialogFragment() {

    inner class EarthInventoryHelper: AppCompatActivity(){

        fun getList(){
            TODO()
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.earth_inventory_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemsList: ListView = view.findViewById(R.id.inventory_items)
        val emptySign: TextView? = view.findViewById(R.id.no_items_sign)

        emptySign?.isVisible = true

        val inventoryItems = EarthInventoryHelper().getList()
    }
}