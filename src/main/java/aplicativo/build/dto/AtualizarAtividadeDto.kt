package aplicativo.build.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Id
import java.time.LocalDate

data class AtualizarAtividadeDto @JsonCreator constructor(
    @JsonProperty ("id") val id: Long,
    @JsonProperty ("descAtividade") val descAtividade: String,
    @JsonProperty ("dataInicio") val dataInicio: LocalDate)
{

}