package br.com.fiap.marvelapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fiap.marvelapp.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding

//    private val characterListAdapter by lazy {
//        CharacterListAdapter()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCharacters.setHasFixedSize(true)
//        binding.recyclerViewCharacters.adapter = characterListAdapter
    }

}