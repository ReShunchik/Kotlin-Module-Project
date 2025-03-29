class Note(name: String, var noteText: String): Menu<String>(name) {

    init{
        actionList.add("Добавить текст к заметке")
        actionList.add("Очистить заметку")
        actionList.add("Изменить имя заметки")
        actionList.add("Удалить заметку")
        actionList.add("Закрыть заметку")
    }

    override fun onOpen(): Boolean{
        while(true){
            println("Заметка \"$name\"")
            println(noteText)
            val action = actionInput()
            when(action){
                "0" -> addText()
                "1" -> clean()
                "2" -> rename()
                "3" -> return true
                "4" -> return false
            }
        }
    }

    override fun createNewAction(){}

    private fun addText(){
        println("Введите текст, который хотите добавить")
        noteText += (" " + userInput())
    }
    private fun clean(){
        noteText = ""
        println("Заметка очищена")
        addText()
    }
}