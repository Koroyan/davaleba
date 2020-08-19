package com.example


import kotlin.random.Random


fun MutableList<Int>.mergeSortedArrays(
    l2: MutableList<Int>
): MutableList<Int> {
    val res: MutableList<Int> = mutableListOf()
    res.addAll(this)
    val iv: MutableList<Int> = mutableListOf()
    iv.addAll(l2)
    if (this.isEmpty()) {
        return l2
    }
    if (l2.isEmpty()) {
        return this
    }
    if (this[0] > l2[0]) {
        res.clear()
        iv.clear()
        res.addAll(l2)
        iv.addAll(this)
    }
    for (i in 0 until iv.size) {
        if (res[res.size - 1] <= iv[i]) {
            res.addAll(res.size, iv.subList(i, iv.size))
            break
        }
        for (j in 0 until res.size - 1) {
            if (iv[i] >= res[j] && iv[i] < res[j + 1]) {
                res.add(j + 1, iv[i])
                break
            }
        }
    }
    return res
}

fun MutableList<Int>.indexOfMax(): Int {
    var maxIndex = 0
    for (i in this.indices) {
        if (this[i] > this[maxIndex]) {
            maxIndex = i
        }
    }
    return maxIndex
}


fun main() {
    val arr = mutableListOf<Int>()
    val arr1 = mutableListOf<Int>()

    for (i in 0 until 50) {
        arr.add(Random.nextInt(0, 200))
    }
    for (i in 0 until 30) {
        arr1.add(Random.nextInt(0, 300))
    }
    println("\n$arr -> max index: ${arr.indexOfMax()}, number ${arr[arr.indexOfMax()]}\n")

    arr.sort()
    arr1.sort()
    val myFunctionResList = arr.mergeSortedArrays(arr1)
    val sortedArrayList = mutableListOf<Int>()
    sortedArrayList.addAll(arr)
    sortedArrayList.addAll(arr1)
    sortedArrayList.sort()
    println("arr $arr")
    println("arr1 $arr1")
    println("\nmy function result $myFunctionResList")
    println("sort method result $sortedArrayList")
    println("Test ${myFunctionResList == sortedArrayList}")

}
