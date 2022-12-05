import java.io.File
import java.io.InputStream

fun readFile(file: File): List<String> {
    val inputStream: InputStream = file.inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    return lineList
}

fun main(args: Array<String>) {
    val file = File("data.txt")
    val lineList: List<String> = readFile(file)
    var sum: Int = 0

    lineList.forEach {
        val pares = it.split(",")
        val numbers1 = pares[0].split("-")
        val numbers2 = pares[1].split("-")
        numbers1[0].toInt()

        var list1: ArrayList<Int> = arrayListOf()
        for (i in numbers1[0].toInt()..numbers1[1].toInt()) {
            list1.add(i)
        }

        var list2: ArrayList<Int> = arrayListOf()
        for (i in numbers2[0].toInt()..numbers2[1].toInt()) {
            list2.add(i)
        }

        /*
        if(list1.containsAll(list2)) sum++
        else if(list2.containsAll(list1)) sum++
         */
        
        run breaking@{
            list1.forEach {
                if (list2.contains(it)) {
                    sum++
                    return@breaking
                }
            }
        }
        println("> " + sum)
    }
}
