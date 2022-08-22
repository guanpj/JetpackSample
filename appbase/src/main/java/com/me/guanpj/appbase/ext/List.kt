package com.me.guanpj.appbase.ext

fun List<String>?.splitData(): String {
    val stringBuffer = StringBuffer()
    if (!isNullOrEmpty()) {
        for (i in this.indices) {
            stringBuffer.append(this[i] + "\n")
        }
    }
    return stringBuffer.toString()
}