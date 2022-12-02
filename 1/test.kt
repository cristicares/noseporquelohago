import java.io.File
import java.io.InputStream
import java.util.Arrays

fun main(args: Array<String>) {
    val inputStream: InputStream = File("data.txt").inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    var majorTotalCal: Int = 0
    var sumCal: Int = 0
    var listTotalCal = ArrayList<Int>()

    lineList.forEach {
        if (it.isEmpty()) {
            println(">>  " + majorTotalCal + " ? " + sumCal)
            majorTotalCal = if (majorTotalCal < sumCal) sumCal else majorTotalCal
            
            listTotalCal.add(sumCal)
            sumCal = 0
        } else {
            var number = it.toInt()
            sumCal += number
            println(">  " + number)
        }
    }
    majorTotalCal = if (majorTotalCal < sumCal) sumCal else majorTotalCal
    println(">>  " + majorTotalCal + " ? " + sumCal)

    //listTotalCal.sort()
    //println("Sorted array asc: ${listTotalCal.toString()}")
    listTotalCal.sortDescending()
    println("> Sorted array desc: ${listTotalCal.toString()}")

    var totalTopThreeCal = listTotalCal.get(0) + listTotalCal.get(1) + listTotalCal.get(2)
    println("> Total top 3 elves: " + totalTopThreeCal)
}
