
class Robot {
    companion object{
        val usedNameList :MutableList<String> = mutableListOf()
    }

    private val charPool : List<Char> = ('A'..'Z') +('A'..'Z')
    private val numberPool:List<Char> = ('0'..'9') + ('0'..'9') + ('0'..'9')


    /**
     * change val to var
     * getter ignore
     */
    var name: String = calculateRobotName()

    fun reset() {
        name = calculateRobotName()
    }

    private fun calculateRandomString():String{
        val randomString = (1..2)
        .map { i -> java.util.Random().nextInt(charPool.size)}
        .map { i -> charPool[i] }
        .joinToString("")
        val randomNumber = (1..3)
            .map { i -> java.util.Random().nextInt(numberPool.size)}
            .map { i -> numberPool[i] }
            .joinToString("")

        val randomName = randomString + randomNumber

        return randomName

    }

    private fun calculateRobotName(): String {
        var string = calculateRandomString()
        if(usedNameList.isEmpty()){
            usedNameList.add(string)
        }
        else{
            do{
                string = calculateRandomString()
            }while(usedNameList.contains(string))
            usedNameList.add(string)
        }
        return string
    }
}

fun main() {

    for (i in 1..10){
        val robot = Robot()
        println(robot.name)
    }

}
