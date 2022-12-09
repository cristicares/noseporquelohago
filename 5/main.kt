import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("data.txt").inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    var list1 = listOf('F', 'D', 'B', 'Z', 'T', 'J', 'R', 'N').toMutableList()
    var list2 = listOf('R', 'S', 'N', 'J', 'H').toMutableList()
    var list3 = listOf('C', 'R', 'N', 'J', 'G', 'Z', 'F', 'Q').toMutableList()
    var list4 = listOf('F', 'V', 'N', 'G', 'R', 'T', 'Q').toMutableList()
    var list5 = listOf('L', 'T', 'Q', 'F').toMutableList()
    var list6 = listOf('Q', 'C', 'W', 'Z', 'B', 'R', 'G', 'N').toMutableList()
    var list7 = listOf('F', 'C', 'L', 'S', 'N', 'H', 'M').toMutableList()
    var list8 = listOf('D', 'N', 'Q', 'M', 'T', 'J').toMutableList()
    var list9 = listOf('P', 'G', 'S').toMutableList()
    var listas = listOf(list1, list2, list3, list4, list5, list6, list7, list8, list9)

    lineList.forEach {
        var result = it.replace(Regex("[^0-9]"), "")
        var instrucciones = result.toCharArray()
        var numCajas: Int
        var from: Int
        var to: Int
        if (instrucciones.size == 4) {
            numCajas = ("${instrucciones[0]}${instrucciones[1]}").toInt()
            println("> ** " + numCajas)
            from = Character.getNumericValue(instrucciones[2])
            to = Character.getNumericValue(instrucciones[3])
        } else {
            numCajas = Character.getNumericValue(instrucciones[0])
            println("> ** " + numCajas)
            from = Character.getNumericValue(instrucciones[1])
            to = Character.getNumericValue(instrucciones[2])
        }

        var listaFrom = listas[from - 1]
        var listaTo = listas[to - 1]
        println(">${numCajas} .. ${listaFrom} to ${listaTo}")
        // var arrVoltear = ArrayList<Char>()
        var cajas = listaFrom.subList(listaFrom.size - numCajas, listaFrom.size)

        cajas.forEach { 
            listaTo.add(it) 
        }

        var desde : Int = listaFrom.size - 1
        var hasta : Int = listaFrom.size - numCajas
        for(i in desde downTo hasta){
            println("> ${i}")
            listaFrom.removeAt(i)
            println("> listaFrom: " + listaFrom.toString())
        }

        listas.forEach { println("> " + it.toString()) }
    }
}
