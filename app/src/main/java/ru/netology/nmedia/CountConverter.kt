package ru.netology.nmedia

class CountConverter {
    lateinit var text: String
    fun convert(count: Long): String {
        if (count < 0) {
            text = "error likes<0"
        } else if (count in 0..999) {
            text = count.toString()
        } else if (count in 1000..9999) {
            text = count.toString()
            text = text[0].toString() + "." + text[1].toString() + "K."
        } else if (count in 10000..99999) {
            text = count.toString()
            text = text[0].toString() + text[1].toString() + "K."
        } else if (count in 100000..999999) {
            text = count.toString()
            text = text[0].toString() + text[1].toString() + text[2].toChar() + "K."
        } else if (count in 1000000..99999999) {
            text = count.toString()
            text = text[0].toString() + "." + text[1].toString() + "M."
        } else {
            text = ">10M."
        }
        return text
    }
}
