fun main() {
    val week = 7
    val n = readln().toInt()
    val string = readln().split(" ").map {
        it.toInt()
    }
    if (n < week) {
        println(-1)
        return
    }
    var maxCount = -1

    flag@ for (i in 0..string.size - week) {
        var count = 0
        for (j in i until i + week) {
            if (string[j] == 2 || string[j] == 3) {
                continue@flag
            }
            if (string[j] == 5) {
                count++
            }
        }
        if (count > maxCount) {
            maxCount = count
        }
    }
    println(maxCount)
}