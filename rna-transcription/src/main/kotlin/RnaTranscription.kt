fun transcribeToRna(dna: String): String = {
    val map = hashMapOf("G" to "C", "C" to "G", "T" to "A", "A" to "U")

    println(dna.split("").)

}

fun main(args: Array<String>) {
    println(transcribeToRna("ACGTGGTCTTAA"))
}
