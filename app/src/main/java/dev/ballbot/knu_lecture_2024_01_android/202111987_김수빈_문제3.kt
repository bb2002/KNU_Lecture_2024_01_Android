fun main(args: Array<String>) {
    print("입력(분): ")
    val min = readlnOrNull()
    if (min == null) {
        print("출력: 0시간 0분")
    } else {
        val minToInt = min.toInt()
        print(String.format("출력: %d시간 %d분", minToInt / 60, minToInt % 60));
    }
}