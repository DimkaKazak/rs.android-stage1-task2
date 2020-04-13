package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var counter: Int = 0
        var prevFibonacci: Int = 0
        var currFibonacci: Int = 1
        while (prevFibonacci * currFibonacci < n){
            counter++
            prevFibonacci = currFibonacci
            currFibonacci = fibonacci(counter)
        }

        var resultArray: IntArray = IntArray(3)
        resultArray[0] = prevFibonacci
        resultArray[1] = currFibonacci

        if (prevFibonacci * currFibonacci == n) resultArray[2] = 1
        else resultArray[2] = 0

        return resultArray
    }


    private fun fibonacci(n: Int): Int{
        if (n <= 0) return 0
        if (n == 1) return 1
        return fibonacci(n-1) + fibonacci(n-2)
    }
}
