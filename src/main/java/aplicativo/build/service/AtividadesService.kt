package aplicativo.build.service

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.model.Atividade

interface AtividadesService {

   fun listaAtividades(): List<Atividade>

    fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto

    fun deletarAtividade(id: Long)

    fun atualizarAtividade(idPraAtualizar: Long, attAtividade: AtualizarAtividadeDto):AtualizarAtividadeDto

    fun atribuirAtividadeAoTecnico(idAtividade:Long, idTecnico: Long)
}