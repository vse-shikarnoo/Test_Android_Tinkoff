fun main() {
    val n = readLine()!!.toInt()
    val grid = List(n) { readLine()!! }
    val dp = Array(n) { IntArray(3) }

    for (j in 0 until 3) {
        if (grid[n - 1][j] == 'C') {
            dp[n - 1][j] = 1
        }
    }

    for (i in n - 2 downTo 0) {
        for (j in 0 until 3) {
            if (grid[i][j] == 'W') {
                continue
            }

            for (k in j - 1..j + 1) {
                if (k in 0 until 3 && grid[i + 1][k] != 'W') {
                    var hasMushroom = 0
                    if (grid[i][j] == 'C') {
                        hasMushroom = 1
                    }

                    dp[i][j] = maxOf(dp[i][j], dp[i + 1][k] + hasMushroom)
                }
            }
        }
    }

    println(dp[0].maxOrNull())
}