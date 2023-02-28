package com.stalkerfish.eastereggs

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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class EarthInventory: DialogFragment() {

    inner class EarthInventoryHelper: AppCompatActivity(){

        fun getList(): ArrayList<Item> {
            return Inventory.getList()
        }

        fun getItemsName(): List<String?> {
            return Inventory.getItemName()
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

        val inventoryItems = EarthInventoryHelper().getList()
        val itemsName = EarthInventoryHelper().getItemsName()

        if (inventoryItems.isEmpty())
            emptySign?.isVisible = true
        else {
            val adapter = ArrayAdapter(requireContext(), R.layout.row_earth, itemsName)
            itemsList.adapter = adapter

            itemsList.onItemClickListener =
                AdapterView.OnItemClickListener { parent, _, position, _ ->
                    val selectedItem = parent.getItemAtPosition(position)

                    val mItem = Pair(selectedItem, inventoryItems[position])

                    try {
                        mItem.second.use(requireContext())
                        adapter.notifyDataSetChanged()

                        this.dismiss()
                    }
                    catch (_: java.lang.IndexOutOfBoundsException) {
                        MotionToast.createToast(
                            requireActivity(), "Item Failed",
                            "MAYBE IT SHOULD NOT BE USED HERE", MotionToastStyle.ERROR,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.SHORT_DURATION,
                            Typeface.DEFAULT_BOLD
                        )
                    }
                }
        }
    }
}