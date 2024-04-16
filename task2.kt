fun main() {
    val params = readln().split(" ").map {
        it.toInt()
    }
    //stroki
    val n = params[0]
    //stolbci
    val m = params[1]

    val matrix = mutableListOf<MutableList<Int>>()
    for (i in 0 until n){
        val list = readln().split(" ").map {
            it.toInt()
        }.toMutableList()
        matrix.add(list)
    }

    val newMatrix = mutableListOf<MutableList<Int>>()
    for (i in 0 until m){
        val list = mutableListOf<Int>()
        for (j in n-1 downTo 0){
            list.add(matrix[j][i])
        }
        newMatrix.add(list)
    }
    printMatrix(newMatrix)
}

fun printMatrix(matrix: MutableList<MutableList<Int>>){
    for (i in 0 until matrix.size){
        for(j in 0 until matrix[i].size){
            if (j!=matrix[i].size-1){
                print("${matrix[i][j]} ")
            }else{
                println("${matrix[i][j]}")
            }
        }
    }
}