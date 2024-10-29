package aplicativo.build.dto

import jakarta.persistence.Id
import java.time.LocalDate
import java.util.*

data class ListAtividadeDto (

    val id: Long ,
    val descAtividade: String,
    val dataInicio: LocalDate)
{

}