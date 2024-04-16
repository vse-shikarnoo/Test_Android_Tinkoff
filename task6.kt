fun main() {
    val n = readLine()!!.toInt()
    val board = mutableListOf<String>()
    var start = Pair(-1, -1)
    var end = Pair(-1, -1)

    repeat(n) {
        val row = readLine()!!
        if ('S' in row) {
            start = Pair(it, row.indexOf('S'))
        } else if ('F' in row) {
            end = Pair(it, row.indexOf('F'))
        }
        board.add(row)
    }

    val result = bfs(n, board, start, end)
    println(result)
}

fun bfs(n: Int, board: List<String>, start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
    val direction = mapOf(
        "K" to setOf(
            Pair(-2, -1), Pair(-1, -2), Pair(1, -2), Pair(2, -1),
            Pair(2, 1), Pair(1, 2), Pair(-1, 2), Pair(-2, 1)
        ),
        "G" to setOf(
            Pair(-1, -1), Pair(0, -1), Pair(1, -1), Pair(1, 0),
            Pair(1, 1), Pair(0, 1), Pair(-1, 1), Pair(-1, 0)
        )
    )

    val visited = mutableMapOf(
        "K" to mutableSetOf(start),
        "G" to mutableSetOf()
    )

    var dist = 0
    val queue = mutableListOf(Pair(start, "K"))

    while (queue.isNotEmpty()) {
        dist++
        val queueSize = queue.size
        repeat(queueSize) {
            val (pos, state) = queue.removeAt(0)
            val (curI, curJ) = pos
            for ((di, dj) in direction[state]!!) {
                val i = curI + di
                val j = curJ + dj
                if (i < 0 || i >= n || j < 0 || j >= n || Pair(i, j) in visited[state]!!) {
                    continue
                }
                if (Pair(i, j) == end) {
                    return dist
                } else if (board[i][j] !in setOf('.', 'S')) {
                    queue.add(Pair(Pair(i, j), board[i][j].toString()))
                    visited[board[i][j].toString()]!!.add(Pair(i, j))
                } else {
                    queue.add(Pair(Pair(i, j), state))
                    visited[state]!!.add(Pair(i, j))
                }
            }
        }
    }

    return -1
}