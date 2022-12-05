import java.io.File
import java.io.InputStream

fun _readFile(file: File) : List<String>{
    val inputStream: InputStream = file.inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    
    return lineList
}