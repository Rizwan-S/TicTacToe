package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tictactoe.databinding.FragmentGameBinding
import com.example.tictactoe.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )
        val bs = listOf(
            binding.b1,
            binding.b2,
            binding.b3,
            binding.b4,
            binding.b5,
            binding.b6,
            binding.b7,
            binding.b8,
            binding.b9
        )
        val xs = listOf(
            binding.x1,
            binding.x2,
            binding.x3,
            binding.x4,
            binding.x5,
            binding.x6,
            binding.x7,
            binding.x8,
            binding.x9
        )
        val os = listOf(
            binding.o1,
            binding.o2,
            binding.o3,
            binding.o4,
            binding.o5,
            binding.o6,
            binding.o7,
            binding.o8,
            binding.o9
        )
        val xwon = Results("X wins !!!", "#f6f7eb", "#a31621")
        val owon = Results("O wins !!!", "#dcdcdd", "#731963")
        val tied = Results("Draw !!!", "#d8dbe2", "#002642")
        var resulttext: String
        var bgcolor: String
        var textcolor: String
        val playerx = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        val playery = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        var moves = 1

        fun check(a: List<Int>): Boolean {
            if (a[0] == 1 && a[1] == 1 && a[2] == 1) return true
            else if (a[3] == 1 && a[4] == 1 && a[5] == 1) return true
            else if (a[6] == 1 && a[7] == 1 && a[8] == 1) return true
            else if (a[0] == 1 && a[3] == 1 && a[6] == 1) return true
            else if (a[1] == 1 && a[4] == 1 && a[7] == 1) return true
            else if (a[2] == 1 && a[5] == 1 && a[8] == 1) return true
            else if (a[0] == 1 && a[4] == 1 && a[8] == 1) return true
            else return a[2] == 1 && a[4] == 1 && a[6] == 1
        }

        for (i in 0..8) {
            bs[i].setOnClickListener {
                bs[i].visibility = View.GONE
                if (moves != 9) {
                    if (moves % 2 == 1) {
                        playerx[i] = 1
                        if (check(playerx)) {
                            resulttext = xwon.text
                            bgcolor = xwon.bgcolor
                            textcolor = xwon.txtcolor
                            view?.findNavController()?.navigate(
                                GameFragmentDirections.actionGameFragmentToGameTied(
                                    resulttext,
                                    bgcolor,
                                    textcolor
                                )
                            )
                        }
                        xs[i].visibility = View.VISIBLE
                    } else {
                        playery[i] = 1
                        if (check(playery)) {
                            resulttext = owon.text
                            bgcolor = owon.bgcolor
                            textcolor = owon.txtcolor
                            view?.findNavController()?.navigate(
                                GameFragmentDirections.actionGameFragmentToGameTied(
                                    resulttext,
                                    bgcolor,
                                    textcolor
                                )
                            )
                        }
                        os[i].visibility = View.VISIBLE
                    }
                } else {
                    playerx[i] = 1
                    if (check(playerx)) {
                        resulttext = xwon.text
                        bgcolor = xwon.bgcolor
                        textcolor = xwon.txtcolor
                        view?.findNavController()?.navigate(
                            GameFragmentDirections.actionGameFragmentToGameTied(
                                resulttext,
                                bgcolor,
                                textcolor
                            )
                        )
                    } else {
                        resulttext = tied.text
                        bgcolor = tied.bgcolor
                        textcolor = tied.txtcolor
                        view?.findNavController()?.navigate(
                            GameFragmentDirections.actionGameFragmentToGameTied(
                                resulttext,
                                bgcolor,
                                textcolor
                            )
                        )
                    }
                }
                moves++
            }
        }
        return binding.root
    }
}

data class Results(val text: String, val bgcolor: String, val txtcolor: String) {
}

