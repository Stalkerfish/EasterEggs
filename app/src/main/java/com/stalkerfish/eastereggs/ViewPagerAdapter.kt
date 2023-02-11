package com.stalkerfish.eastereggs

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class ViewPagerAdapter(private var itemView: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemGithub: ImageView? = itemView.findViewById(R.id.github)
        val itemInsta: ImageView? = itemView.findViewById(R.id.instagram)
        val itemTwitter: ImageView? = itemView.findViewById(R.id.twitter)
        val itemStartButton: Button? = itemView.findViewById(R.id.start)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return when (viewType) {
            0 -> Pager2ViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item2_view_pager, parent, false)
            )

            else -> Pager2ViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_view_pager, parent, false)
            )
        }
    }


    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        when (position) {
            0 -> holder.itemStartButton?.setOnClickListener {
                Log.e("onG", "Go to Main Activity")

                val context = holder.itemView.context
                val intent = Intent(context, MainActivity::class.java)

                context.startActivity(intent)
            }
            else -> {
                holder.itemGithub?.setOnClickListener {
                    Log.e("onG", "Go to GitHub")

                    val context = holder.itemView.context
                    val openURL = Intent(Intent.ACTION_VIEW)

                    openURL.data = Uri.parse(LandingScreen().myGithub)
                    context.startActivity(openURL)

                }

                holder.itemTwitter?.setOnClickListener {
                    Log.e("onG", "Go to Twitter")

                    val context = holder.itemView.context
                    val openURL = Intent(Intent.ACTION_VIEW)

                    openURL.data = Uri.parse(LandingScreen().myTwitter)
                    context.startActivity(openURL)
                }

                holder.itemInsta?.setOnClickListener {
                    Log.e("onG", "Go to Instagram")

                    val context = holder.itemView.context
                    val openURL = Intent(Intent.ACTION_VIEW)

                    openURL.data = Uri.parse(LandingScreen().myInstagram)
                    context.startActivity(openURL)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return itemView.size
    }

    override fun getItemViewType(position: Int): Int {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }

}