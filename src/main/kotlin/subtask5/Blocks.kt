package subtask5

import java.time.LocalDate
import kotlin.reflect.KClass


class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        
        var resultList: MutableList<Any> = mutableListOf()
        for (element in blockA){
            if(blockB == element!!::class){
                resultList.add(element)
            }
        }

        var result = Any()
        when (blockB){
            String::class -> {
                result = ""
                resultList.forEach {
                    result = (result as String).plus(it)
                }
            }

            Int::class -> {
                result = 0
                resultList.forEach {
                    result = (result as Int).plus(it as Int)
                }
            }

            LocalDate::class -> {
                result = LocalDate.MIN
                resultList.forEach {
                    if( (result as LocalDate?)!! < (it as LocalDate) ) result = it
                }
                result = "${(result as LocalDate).dayOfMonth}.${(result as LocalDate).monthValue}.${(result as LocalDate).year}"
            }
        }
        return result
    }

}
