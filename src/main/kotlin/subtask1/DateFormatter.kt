package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    private val dayMap: Map<String, String> = mapOf("Mon" to "понедельник", "Tue" to "вторник",
        "Wed" to "среда", "Thu" to "четверг", "Fri" to "пятница", "Sut" to "суббота",
        "Sun" to "воскресенье")

    private val monthMap: Map<String, String> = mapOf("Jan" to "января", "Feb" to "февраля",
        "Mar" to "марта", "Apr" to "апреля", "May" to "мая", "Jun" to "июня", "Jul" to "июля",
        "Aug" to "августа", "Sep" to "сентября", "Oct" to "октября", "Nov" to "ноября",
        "Dec" to "декабря")

    private val numDaysInMonth: Map<Int, Int> = mapOf(1 to 31, 2 to 28, 3 to 31,
        4 to 30, 5 to 31, 6 to 30, 7 to 31, 8 to 31, 9 to 30,
        10 to 31, 11 to 30, 12 to 31)

    fun toTextDay(day: String, month: String, year: String): String {

        val dateFormat: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val mDate: Date = dateFormat.parse("$day-$month-$year")
        val mStringDate: List<String> = mDate.toString().split(" ")
        val resultDay:    String = mStringDate[0]
        val resultMonth:  String = mStringDate[1]
        val resultIntDay: String = mStringDate[2]

        if(!dateValidation(day, month, year)){
            return "Такого дня не существует"
        }

        return "$resultIntDay ${monthMap.get(resultMonth)}, ${dayMap.get(resultDay)}"
    }

    private fun dateValidation(day: String, month: String, year: String): Boolean{
        if(day.toInt() !in 1..31){
            return false
        }

        if(month.toInt() !in 1..12){
            return false
        }

        if(year.toInt() % 4 != 0 && month.toInt() == 2 && day.toInt() !in 1..28){
            return false
        }

        if(day.toInt() !in 1..numDaysInMonth[month.toInt()]!!){
            return false
        }

        return true
    }
}
