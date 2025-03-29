class Archive(name: String): Menu<Note>(name) {

    init{
        actionList.add(Note("Изменить имя Архива", ""))
        actionList.add(Note("Удалить архив", ""))
        actionList.add(Note("Добавить новую заметку", ""))
        actionList.add(Note("Выход их архива", ""))
    }

    override fun onOpen(): Boolean {
        while(true){
            println("Список заметок архива \"$name\"")
            val action = actionInput()
            when(action){
                "0" -> rename()
                "1" -> return true
                "2" -> createNewAction()
                "${actionList.lastIndex}" -> return false
                else -> {
                    if(actionList.get(action.toInt()).onOpen()){
                        deleteAction(action.toInt(), NOTE)
                    }
                }
            }
        }
    }

    override fun createNewAction(){
        println("Введите имя заметки")
        val name = userInput()
        println("Введите текст заметки")
        val text = userInput()
        actionList.add(3, Note(name, text))
        if (actionList.get(3).onOpen()){
            deleteAction(3, NOTE)
        }
    }
}