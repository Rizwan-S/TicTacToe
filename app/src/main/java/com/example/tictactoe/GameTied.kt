package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tictactoe.databinding.FragmentTiedBinding
import kotlinx.android.synthetic.main.fragment_tied.*
import kotlinx.android.synthetic.main.fragment_tied.view.*
import kotlinx.android.synthetic.main.fragment_tied.view.rtext

/**
 * A simple [Fragment] subclass.
 */
class GameTied : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val binding = DataBindingUtil.inflate<FragmentTiedBinding>(inflater, R.layout.fragment_tied,container,false)
        val args = GameTiedArgs.fromBundle(arguments!!)
        binding.rtext.text = "${args.resulttext}"
        binding.rtext.setTextColor(Color.parseColor("${args.textcolor}"))
        binding.gametied.setBackgroundColor(Color.parseColor("${args.bgcolor}"))
        binding.tieplay.setTextColor(Color.parseColor("${args.bgcolor}"))
        binding.tieplay.setOnClickListener{ view : View ->
            view.findNavController().navigate(GameTiedDirections.actionGameTiedToGameFragment())
        }
        return binding.root
        }
}


