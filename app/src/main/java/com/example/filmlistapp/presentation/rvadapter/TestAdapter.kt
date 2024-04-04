package com.example.filmlistapp.presentation.rvadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmlistapp.R
import com.example.filmlistapp.databinding.FragmentListItemBinding
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.presentation.fragments.films.filmlist.FilmListFragment

class TestAdapter(filmListFragment: FilmListFragment) :
    ListAdapter<Product, TestAdapter.Holder>(Comparator()) {

    var onFavouriteIconClickListener: ((Product) -> Unit)? = null


    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = FragmentListItemBinding.bind(view)

        fun bind(product: Product) =
            with(binding) {


                description.text = product.description
                ratingText.text = product.rating.toString()

                val status = if (product.clickEnable) {
                    "-Добавлено в избранное"
                } else {
                    ""
                }
                titleTest.text = "${product.title} $status"

                val iconFavourite = itemView.findViewById<ImageView>(R.id.iconFavourite)
                val statusFavoriteIcon = if (product.clickEnable) {

                    iconFavourite.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.heartenabled
                        )
                    )
                } else {
                    iconFavourite.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.heartdisabled
                        )
                    )

                }


            }


    }

    class Comparator : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_item, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))

        val filItem = getItem(position)

        Glide.with(holder.itemView)
            .load(filItem.thumbnail)
            .into(holder.itemView.findViewById(R.id.imageViewPoster))


        holder.itemView.findViewById<ImageView>(R.id.iconFavourite).setOnClickListener {
            onFavouriteIconClickListener?.invoke(filItem)
            filItem.clickEnable = !filItem.clickEnable

            notifyDataSetChanged()
        }
    }


}