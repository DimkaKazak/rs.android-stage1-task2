package subtask2

class TimeConverter {

    private val minutesToStringMap: Map<String, String> = mapOf("0" to "", "1" to "one", "2" to "two", "3" to "three",
        "4" to "four", "5" to "five", "6" to "six", "7" to "seven", "8" to "eight", "9" to "nine",
        "00" to "", "01" to "one", "02" to "two", "03" to "three",
        "04" to "four", "05" to "five", "06" to "six", "07" to "seven", "08" to "eight", "09" to "nine",
        "10" to "ten", "11" to "eleven", "12" to "twelve", "13" to "thirteen", "14" to "fourteen",
        "15" to "quarter", "16" to "sixteen", "17" to "seventeen", "18" to "eighteen",
        "19" to "nineteen", "20" to "twenty", "21" to "twenty one", "22" to "twenty two",
        "23" to "twenty three", "24" to "twenty four", "25" to "twenty five",
        "26" to "twenty six", "27" to "twenty seven", "28" to "twenty eight",
        "29" to "twenty nine", "30" to "half")

    private val hourToStringMap: Map<String, String> = mapOf("1" to "one", "2" to "two", "3" to "three",
        "4" to "four", "5" to "five", "6" to "six", "7" to "seven", "8" to "eight", "9" to "nine",
        "10" to "ten", "11" to "eleven")

    fun toTextFormat(hour: String, minute: String): String {

        if(!validateTime(hour, minute)){
            return ""
        }

        if(minute.toInt() == 0){
            return "${hourToStringMap[hour]!!} o' clock"
        }

        if(minute.toInt() in 1..30){
            if (minute.toInt() == 1){
                return "one minute past ${hourToStringMap[hour]!!}"
            }

            if (minute.toInt() == 15){
                return "quarter past ${hourToStringMap[hour]!!}"
            }

            if (minute.toInt() == 30){
                return "half past ${hourToStringMap[hour]!!}"
            }

            return "${minutesToStringMap[minute]!!} minutes past ${hourToStringMap[hour]!!}"

        } else {
            if (minute.toInt() == 31){
                return "one minute to ${hourToStringMap[(hour.toInt() + 1).toString()]!!}"
            }

            if (minute.toInt() == 45){
                return "quarter to ${hourToStringMap[(hour.toInt() + 1).toString()]!!}"
            }

            return "${minutesToStringMap[(60 - minute.toInt()).toString()]!!} minutes to ${hourToStringMap[(hour.toInt() + 1).toString()]!!}"
        }
    }

    private fun validateTime(hour: String, minute: String): Boolean {

        if (hour.toInt() !in 0..23){
            return false
        }

        if (minute.toInt() !in 0..60){
            return false
        }

        return true
    }


}
