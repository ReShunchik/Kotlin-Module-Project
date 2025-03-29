import java.util.Scanner

abstract class Menu<T>(var name: String) {
    val actionList: ArrayList<T> = arrayListOf()

    companion object{
        const val ARCHIVE = "Архив"
        const val NOTE = "Заметка"
    }

    abstract fun onOpen(): Boolean

    abstract fun createNewAction()

    fun actionInput(): String{
        val indicesList = Array(actionList.size) { index ->
            index.toString()
        }
        actionList.forEachIndexed{index, element -> println("$index. ${element.toString()}")}
        while(true){
            val input = Scanner(System.`in`).nextLine()
            if(indicesList.contains(input)){
                return input
            } else {
                println("Неизвестная команда")
            }
        }
    }

    fun userInput(): String{
        while (true){
            val input = Scanner(System.`in`).nextLine()
            if (input.equals("")){
                println("Ввод не может быть пустым")
            } else {
                return input
            }
        }
    }

    fun rename(){
        println("Введите новое имя")
        this.name = userInput()
        println("Имя изменено")
    }

    fun deleteAction(action: Int, type: String){
        actionList.removeAt(action)
        println("$type удалена")
    }
    override fun toString(): String {
        return name
    }

}