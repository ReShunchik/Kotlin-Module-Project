class MainMenu(name: String) : Menu<Archive>(name) {

    init{
        actionList.add(Archive("Создать новый архив"))
        actionList.add(Archive("Выход из приложения"))
    }

    override fun onOpen(): Boolean{
        while(true){
            println("Список архивов")
            val action = actionInput()
            when(action){
                "0" -> createNewAction()
                "${actionList.lastIndex}" -> return true
                else -> {
                    if(actionList.get(action.toInt()).onOpen()){
                        deleteAction(action.toInt(), ARCHIVE)
                    }
                }
            }
        }
    }

   override fun createNewAction(){
        println("Введите имя архива")
        actionList.add(1, Archive(userInput()))
        if(actionList.get(1).onOpen())
            deleteAction(1, ARCHIVE)
    }
}