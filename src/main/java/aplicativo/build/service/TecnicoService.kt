package aplicativo.build.service

import aplicativo.build.dto.AtualizarCadastroTecnicoDto
import aplicativo.build.dto.CadastrarTecnicoDto
import aplicativo.build.model.Tecnico

interface TecnicoService {

    fun listTecnicos():MutableList<Tecnico>

    fun criaTecnico(novoTecnico: CadastrarTecnicoDto):CadastrarTecnicoDto

    fun deletarTecnico(id: Long)

    fun atualizarTecnico(id: Long, atualizarTecnico: AtualizarCadastroTecnicoDto): AtualizarCadastroTecnicoDto
}