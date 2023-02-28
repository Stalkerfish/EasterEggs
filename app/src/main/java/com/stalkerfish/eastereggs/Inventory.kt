package com.stalkerfish.eastereggs

object Inventory {
    private val itemList = ArrayList<Item>()

    fun getList(): ArrayList<Item>{
        return itemList
    }

    fun getItemSize(): Int {
        return itemList.size
    }

    fun addItem(item: Item) {
        itemList.add(item)
    }

    fun removeOrb(item: Item) {
        itemList.remove(item)
    }

    fun eraseShelf(){
        itemList.clear()
    }
}