fun twofer(name: String)="One for ${if(name.isEmpty()) "you" else name}, one for me."
fun twofer()="One for you, one for me."

fun main(args: Array<String>) {
    println(twofer("hoge"))
    println(twofer(""))
    println(twofer())
}
