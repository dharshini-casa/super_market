import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object Date {

  val date: LocalDate = LocalDate.now() 
  def getDate(): String = DateFormatter.dateFormatDMY(date)
  
}

object Time {
    val time: LocalTime = LocalTime.now()
    def getTime(): String = TImeFormatter.timeFormatHMS(time)

}

trait Formatter{

}


object TImeFormatter extends Formatter {
    def timeFormatHMS(time: LocalTime) = {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        time.format(formatter)
    }
}

object DateFormatter extends Formatter {
    def dateFormatDMY(date: LocalDate) = {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        date.format(formatter)
    }
}