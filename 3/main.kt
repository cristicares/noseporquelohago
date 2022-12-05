import java.io.File
import java.io.InputStream
import java.util.*

fun main(args: Array<String>) {
    val inputStream: InputStream = File("data.txt").inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    var abc: ArrayList<Char> = arrayListOf()
    var c: Char = 'a'
    while (c <= 'z') {
        abc.add(c)
        ++c
    }
    c = 'A'
    while (c <= 'Z') {
        abc.add(c)
        ++c
    }

    var sum: Int = 0
    var trio: Int = 0

    var cadena1 = ""
    var cadena2 = ""
    var cadena3 = ""

    for ((index, value) in lineList.withIndex()) {
        if (trio == 0) {
            cadena1 = value
        } else if (trio == 1) {
            cadena2 = value
        } else {
            cadena3 = value
        }
        trio++
        if ((index + 1) % 3 == 0) {
            var letra: Char = ' '
            run breaking@{
                cadena1.toCharArray().forEach { it1 ->
                    cadena2.toCharArray().forEach {
                        if (it.equals(it1)) {
                            if (cadena3.contains(it)) {
                                letra = it
                                return@breaking
                            }
                        }
                    }
                }
            }

            println(letra)
            println(abc.indexOf(letra) + 1)
            sum += (abc.indexOf(letra) + 1)
            println(sum)

            trio = 0
        }
    }
}

/*
val cadena1 = it.substring(0, it.length / 2)
        val cadena2 = it.substring(it.length / 2)
        var letra: Char = ' '

        println("> ${cadena1} ${cadena2}")

        run breaking@{
            cadena1.toCharArray().forEach { it1 ->
                cadena2.toCharArray().forEach {
                    if (it.equals(it1)) {
                        letra = it
                        return@breaking
                    }
                }
            }
        }
        println("> " + letra)
        println(abc.indexOf(letra) + 1)

        sum += (abc.indexOf(letra) + 1)
        println(sum)
*/
