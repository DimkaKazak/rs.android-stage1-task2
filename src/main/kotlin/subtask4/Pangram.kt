package subtask4

class Pangram {

    private var englishAphabetMap: MutableMap<Char, Boolean> = mutableMapOf('A' to false,'B' to false,'C' to false,
        'D' to false, 'E' to false, 'F' to false, 'G' to false, 'H' to false, 'I' to false,
        'J' to false, 'K' to false, 'L' to false, 'M' to false, 'N' to false, 'O' to false,
        'P' to false, 'Q' to false, 'R' to false, 'S' to false, 'T' to false, 'U' to false,
        'V' to false, 'W' to false, 'X' to false, 'Y' to false, 'Z' to false)

    private val englishVowels: List<Char> = listOf('A', 'E', 'I', 'O', 'U', 'Y')
    private val englishConsonants: List<Char> = listOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
        'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z')

      fun getResult(inputString: String): String {

          var splittedInputString: List<String> = inputString.split(" ").filter{
              it != "" && it != "\n"
          }
          var resultString: String = ""
          var resultList: List<Pair<String, Int>>
          var isVowels: Boolean = isPangram(inputString)
          if(isVowels){

               resultList = (splittedInputString zip getCount(splittedInputString, isVowels))
                  .sortedBy { it.second }

            } else{

               resultList = (splittedInputString zip getCount(splittedInputString, isVowels))
                  .sortedBy { it.second }

          }

          for (pair in resultList){
              resultString = resultString.plus("${pair.second.toString()}${transformToUpper(pair.first, isVowels)} ")
          }

          return if (resultString.isNotEmpty()){
              resultString.substring(0, resultString.length - 1)
          } else ""
    }

    private fun isPangram(inputString: String): Boolean{

        for (element in inputString){
            var currElem = element.toUpperCase()
            if(englishAphabetMap.containsKey(currElem)){
                if(!englishAphabetMap[currElem]!!) englishAphabetMap[currElem] = true
            }
        }

        for (entry in englishAphabetMap){
            if (!entry.value) return false
        }

        return true
    }

    private fun getCount(splittedInputString: List<String>, isVowels: Boolean): List<Int> {
        var resultList: MutableList<Int> = mutableListOf()

        for (word in splittedInputString){
            var count: Int = 0
            for (letter in word){
                if(isVowels){
                    if (letter.toUpperCase() in englishVowels){
                        count++
                    }
                } else {
                    if (letter.toUpperCase() in englishConsonants){
                        count++
                    }
                }
            }
            resultList.add(count)
        }

        return resultList
    }

    private fun transformToUpper(inputString: String, isVowels: Boolean): String {
        var resultString: String = ""
        if(isVowels){
            for (letter in inputString){
                if (letter.toUpperCase() in englishVowels) resultString = resultString.plus(letter.toString().toUpperCase())
                else resultString = resultString.toString().plus(letter)
            }
        } else {
            for (letter in inputString){
                if (letter.toUpperCase() in englishConsonants) resultString = resultString.plus(letter.toString().toUpperCase())
                else  resultString = resultString.plus(letter.toString())
            }
        }
        return resultString
    }
}
