package aplicativo.build.dto

import java.time.LocalDate
import java.util.*

data class DeletarAtividadeDto(
    val id: Long,
    val descAtividadeDto: String,
    val dataInicio: LocalDate
)

