package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val positionList: MutableList<Int> =  mutableListOf()

        var j = 0
        for (element in b){

            while(j != a.length){
                if(element == a[j].toUpperCase()){
                    positionList.add(j)
                    break;
                }
                j++
            }

        }

        return if(validateTwoStrings(a, b, positionList)){
            "YES"
        } else{
            "NO"
        }
    }

    private fun validateTwoStrings(a: String, b: String, positionList: List<Int>): Boolean {
        if(positionList.size != b.length) return false

        for (i in 0 until positionList.size - 1){
            for (j in (positionList[i] + 1) until positionList[i+1]){
                if(a[j].isUpperCase()){
                    return false
                }
            }
        }
        return true
    }
}
