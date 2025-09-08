fun main() {
    val plaintext = "/api/v1/account/close/card"
    val encrypted = xorEncrypt(plaintext)
    val hexEscaped = toHexEscaped(encrypted)

    println(hexEscaped)
}

fun toHexEscaped(input: String): String {
    return input.map { "\\x%02x".format(it.code) }.joinToString("")
}

fun xorEncrypt(text: String, key: Char = 'K'): String {
    return text.map { it.code.xor(key.code).toChar() }.joinToString("")
}