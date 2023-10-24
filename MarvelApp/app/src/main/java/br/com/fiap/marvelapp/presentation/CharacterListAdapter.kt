package br.com.fiap.marvelapp.presentation

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.marvelapp.R
//import br.com.fiap.marvelapp.presentation.CharacterDetailFragment.Companion.buildBundle
import br.com.fiap.marvelapp.domain.MarvelCharacterDataResultModel
import br.com.fiap.marvelapp.databinding.ViewCharacterItemBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.CharacterItemViewHolder>() {

    private val characterList: MutableList<MarvelCharacterDataResultModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ViewCharacterItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_character_item,
                parent, false
            )
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setData(list: List<MarvelCharacterDataResultModel>) {
        characterList.clear()
        characterList.addAll(list)
        notifyDataSetChanged()
    }

    inner class CharacterItemViewHolder(
        private val view: ViewCharacterItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bindView(character: MarvelCharacterDataResultModel) {
            with(view.root) {
                setOnClickListener {
//                    findNavController().navigate(
//                        R.id.action_character_list_to_character_detail,
//                        buildBundle(character)
//                    )
                }
            }
            view.characterNameValue.text = character.name

            character.getThumbnailFullUrl().let {
                Picasso.get()
                    .load(it)
                    .into(object: Target {
                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                            view.characterIcon.setImageBitmap(bitmap)
                        }

                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

                        }

                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                        }

                    })
            }
        }
    }
}