//package br.com.fiap.marvelapp.presentation
//
//import android.graphics.Bitmap
//import android.graphics.drawable.Drawable
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import br.com.fiap.marvelapp.R
//import br.com.fiap.marvelapp.domain.MarvelComicDataResultModel
//import br.com.fiap.marvelapp.databinding.ViewCharacterDetailComicItemBinding
//import com.squareup.picasso.Picasso
//import com.squareup.picasso.Target
//import java.lang.Exception
//
//class ComicListAdapter : RecyclerView.Adapter<ComicListAdapter.ComicItemViewHolder>() {
//
//    private val comicList: MutableList<MarvelComicDataResultModel> = mutableListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicItemViewHolder {
//        val binding = ViewCharacterDetailComicItemBinding.bind(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.view_character_detail_comic_item,
//                parent, false
//            )
//        )
//        return ComicItemViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ComicItemViewHolder, position: Int) {
//        holder.bindView(comicList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return comicList.size
//    }
//
//    fun setData(list: List<MarvelComicDataResultModel>) {
//        comicList.clear()
//        comicList.addAll(list)
//        notifyDataSetChanged()
//    }
//
//    inner class ComicItemViewHolder(
//        private val view: ViewCharacterDetailComicItemBinding
//    ) : RecyclerView.ViewHolder(view.root) {
//
//        fun bindView(comic: MarvelComicDataResultModel) {
//            view.comicTitle.text = comic.title
//            comic.getThumbnailFullUrl()?.let {
//                Picasso.get()
//                    .load(it)
//                    .into(object: Target {
//                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                            view.comicIcon.setImageBitmap(bitmap)
//                        }
//
//                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
//
//                        }
//
//                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//
//                        }
//
//                    })
//            }
//        }
//    }
//}