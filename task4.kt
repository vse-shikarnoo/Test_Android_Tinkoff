fun main() {
    var (param, rotate) = readLine()!!.split(" ")
    val n = param.toInt()
    val mat = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }

    val result = mutableListOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()

    if (rotate == "L") {
        for (i in 0 until n / 2) {
            for (j in i until n - i - 1) {
                result.add(Pair(Pair(i, j), Pair(j, n - i - 1)))
                result.add(Pair(Pair(j, n - i - 1), Pair(n - i - 1, n - j - 1)))
                result.add(Pair(Pair(n - i - 1, n - j - 1), Pair(n - j - 1, i)))
            }
        }
    } else {
        for (i in 0 until n / 2) {
            for (j in i until n - i - 1) {
                result.add(Pair(Pair(i, j), Pair(n - j - 1, i)))
                result.add(Pair(Pair(j, n - i - 1), Pair(n - i - 1, n - j - 1)))
                result.add(Pair(Pair(n - i - 1, n - j - 1), Pair(n - j - 1, i)))
            }
        }
    }

    println(result.size)
    for ((ind1, ind2) in result) {
        println("${ind1.first} ${ind1.second} ${ind2.first} ${ind2.second}")
    }
}