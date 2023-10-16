package br.com.fiap.marvelapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fiap.marvelapp.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding
//    private val character: MarvelCharacterDataResultModel? by lazy {
//        arguments?.getParcelable(DETAIL_CHARACTER_KEY) as? MarvelCharacterDataResultModel
//    }
//    private val comicsAdapter by lazy {
//        ComicListAdapter()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
//        binding.characterName.text = character?.name
    }

    private fun setupRecyclerView() {
        binding.recyclerViewComics.setHasFixedSize(true)
//        binding.recyclerViewComics.adapter = comicsAdapter
    }

    companion object {
        private const val DETAIL_CHARACTER_KEY = "DETAIL_CHARACTER_KEY"

//        fun buildBundle(characterDataResultModel: MarvelCharacterDataResultModel): Bundle {
//            return bundleOf(DETAIL_CHARACTER_KEY to characterDataResultModel)
//        }
    }
}