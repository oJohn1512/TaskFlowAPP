package aplicativo.build.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class AtualizarCadastroTecnicoDto  @JsonCreator constructor (
    @JsonProperty("id") val id: Long,
    @JsonProperty("nomeTecnico") val nomeTecnico: String,
    @JsonProperty("setor") val setor: String)