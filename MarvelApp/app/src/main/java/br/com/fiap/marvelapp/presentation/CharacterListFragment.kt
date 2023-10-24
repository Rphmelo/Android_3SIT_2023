package br.com.fiap.marvelapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import br.com.fiap.marvelapp.databinding.FragmentCharacterListBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val viewModel by viewModels<CharacterListViewModel>()

    private val characterListAdapter by lazy {
        CharacterListAdapter()
    }

    private fun setObservers() {
        viewModel.errorState.observe(
            viewLifecycleOwner,
            Observer {
                Snackbar.make(
                    binding.recyclerViewCharacters,
                    it,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        )

        viewModel.successState.observe(
            viewLifecycleOwner,
            Observer {
                characterListAdapter.setData(it)
            }
        )
    }

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
        setObservers()
        lifecycleScope.launch {
            viewModel.listCharacters()
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCharacters.setHasFixedSize(true)
        binding.recyclerViewCharacters.adapter = characterListAdapter
    }

}