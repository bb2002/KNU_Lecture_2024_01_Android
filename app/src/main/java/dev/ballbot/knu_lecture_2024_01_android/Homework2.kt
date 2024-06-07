fun rect1(size: Int) {
    for (i in 1 .. size) {
        for (j in 0 until i) {
            print("*")
        }
        println()
    }
}

fun rect2(size: Int) {
    for (i in size downTo 1) {
        for (j in 0 until i) {
            print("*")
        }
        println()
    }
}

fun rect3(size: Int) {
    for (i in 1 .. size) {
        for (j in 0 until size - i) {
            print(" ")
        }
        for (j in 0 until i) {
            print("*")
        }
        println()
    }
}

fun rect4(size: Int) {
    for (i in 1 .. size) {
        for (j in 0 until size - i) {
            print(" ")
        }
        for (j in 0 until i * 2 - 1) {
            print("*")
        }
        println()
    }
}

fun rect5(size: Int) {
    for (i in 1 until size) {
        for (j in 1 .. i) {
            print(" ")
        }
        for (j in 1 until (size - i) * 2) {
            print("*")
        }
        println()
    }
}

fun main() {
    while (true) {
        print("줄 수를 입력하세요. >>")
        val data = readlnOrNull()
        if (data == null || data == "") {
            break
        }

        if (data != null && data.all { c -> c.isDigit() } && data.toInt() > 0) {
            val size = data.toInt()
            println(" --------- No. 1")
            rect1(size)

            println("\n --------- No. 2")
            rect2(size)

            println("\n --------- No. 3")
            rect3(size)

            println("\n --------- No. 4")
            rect4(size)

            println("\n --------- No. 5")
            rect4(size)
            rect5(size)


        } else {
            println("잘못된 값을 입력하셨습니다.")
        }
    }
}
