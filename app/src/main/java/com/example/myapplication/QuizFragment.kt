package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment : Fragment() {
    private val choices1 = listOf(
        ChoiceModel("Raising Arizona"),
        ChoiceModel("Vampire's Kiss")
    )
    private val choices2 = listOf(
        ChoiceModel("Raising Arizona"),
        ChoiceModel("Vampire's Kiss"),
        ChoiceModel("Con Air"),
    )
    private val choices3 = listOf(
        ChoiceModel("Raising Arizona"),
        ChoiceModel("Vampire's Kiss"),
        ChoiceModel("Con Air"),
        ChoiceModel("Gone in 60 Seconds")
    )
    private val choices4 = listOf(
        ChoiceModel("Raising Arizona"),
        ChoiceModel("Vampire's Kiss"),
        ChoiceModel( "Con Air"),
        ChoiceModel( "Gone in 60 Seconds"),
    )

    private val questions = listOf(
        QuestionsModel("1","Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment",choices1),
        QuestionsModel("1","this is question two",choices2),
        QuestionsModel("1","this is question three",choices3),
        QuestionsModel("1","this is question four",choices4),
    )

    private var index = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
        previous.visibility = GONE
        initClickListener()
    }
    private fun initClickListener(){
        next.setOnClickListener {
            index++
            if (index == questions.size-1){
                done.visibility = VISIBLE
                next.visibility = GONE
            }
            if (previous.visibility == GONE){
                previous.visibility = VISIBLE
            }
            updateUI()
        }

        previous.setOnClickListener {
            index--
            if (index == 0){
                previous.visibility = GONE
            }
            if (next.visibility == GONE){
                next.visibility = VISIBLE
                done.visibility = GONE
            }
            updateUI()
        }

    }

    private fun updateUI(){
        question_no.text = "Question ${index+1}"
        question_text.text = questions[index].questionsText
        choices_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ChoicesAdapter(questions[index].choices)
        }
    }
    companion object {
        fun newInstance() = QuizFragment()
    }
}