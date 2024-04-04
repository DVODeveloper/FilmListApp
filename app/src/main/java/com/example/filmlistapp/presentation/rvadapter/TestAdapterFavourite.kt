package com.example.filmlistapp.presentation.rvadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlistapp.R
import com.example.filmlistapp.databinding.FragmentListItemBinding
import com.example.filmlistapp.domain.entity.testEntity.Product
import com.example.filmlistapp.presentation.fragments.films.filmfavouritelist.FilmFavouriteListFragment

class TestAdapterFavourite(filmFavouriteListFragment: FilmFavouriteListFragment) :
    ListAdapter<Product, TestAdapter.Holder>(
        TestAdapter.Comparator()
    ) {

    var onFavouriteIconClickListener: ((Product) -> Unit)? = null

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = FragmentListItemBinding.bind(view)

        fun bind(product: Product) =
            with(binding) {

                description.text = product.description

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_item, parent, false)

        return TestAdapter.Holder(view)
    }

    override fun onBindViewHolder(holder: TestAdapter.Holder, position: Int) {
        holder.bind(getItem(position))

        val filItem = getItem(position)

        holder.itemView.findViewById<ImageView>(R.id.iconFavourite).setOnClickListener {
            onFavouriteIconClickListener?.invoke(filItem)
            filItem.clickEnable = !filItem.clickEnable

            notifyDataSetChanged()
        }
    }
}