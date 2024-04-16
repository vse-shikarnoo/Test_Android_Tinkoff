fun main() {
    val n = readLine()!!.toInt()
    val directories = mutableMapOf<String, Any>()
    lateinit var path: List<String>

    repeat(n) {
        path = readLine()!!.split('/')
        var carry = directories
        for (subdir in path.drop(1)) {
            if (subdir !in carry) {
                carry[subdir] = mutableMapOf<String, Any>()
            }
            carry = carry[subdir] as MutableMap<String, Any>
        }
    }

    val topLevelDirectory = path[0]
    val updatedDirectories = mapOf(topLevelDirectory to directories)
    showDir(updatedDirectories)
}

fun showDir(directories: Map<String, Map<String, Any>>, indent: Int = 0) {
    val sortedDirectories = directories.keys.sorted()
    for (directory in sortedDirectories) {
        println("  ".repeat(indent) + directory)
        showDir(directories[directory] as Map<String, Map<String, Any>>, indent + 1)
    }
}