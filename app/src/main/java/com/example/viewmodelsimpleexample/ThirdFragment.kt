package com.example.viewmodelsimpleexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.viewmodelsimpleexample.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PersonViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.name.observe(viewLifecycleOwner) { name ->
            binding.textviewName.text = name
        }

        viewModel.age.observe(viewLifecycleOwner) { age ->
            binding.textviewAge.text = age.toString()
        }

        viewModel.email.observe(viewLifecycleOwner) { email ->
            binding.textviewEmail.text = email.toString()
        }

        binding.buttonSecond.setOnClickListener {
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}