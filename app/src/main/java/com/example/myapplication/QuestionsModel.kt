package com.example.myapplication

class QuestionsModel(id:String,questionText:String,choices:List<ChoiceModel>){
    var id = ""
    var questionsText = ""
    var choices = listOf<ChoiceModel>()
    init {
        this.id = id
        this.questionsText = questionText
        this.choices = choices
    }
}

class ChoiceModel(choice:String,selected: Boolean = false){
    var choice = ""
    var selected = false
    init {
        this.choice = choice
        this.selected = selected
    }
}