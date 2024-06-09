import java.util.Random

fun main(args: Array<String>) {
    val random = Random()

    print("출력: ")
    for (i in 0..4) {
        var rd = random.nextInt(19) + 2;
        if (rd % 2 != 0) {
            rd += if (random.nextInt(2) == 0) -1 else 1;
        }
        print(rd)
        print(" ")
    }
}