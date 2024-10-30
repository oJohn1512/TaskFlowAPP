package aplicativo.build.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class DeletarAtividadeDto @JsonCreator constructor(
    @JsonProperty ("id")val id: Long,
    @JsonProperty ("descAtividade")val descAtividadeDto: String,
    @JsonProperty ("dataInicio")val dataInicio: LocalDate
)

