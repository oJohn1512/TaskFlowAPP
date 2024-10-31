package aplicativo.build.services

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.model.Atividade

interface AtividadesService {

   fun listaAtividades(): List<Atividade>

    fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto

    fun deletarAtividade(id: Long)

    fun atualizarAtividade(idPraAtualizar: Long, attAtividade: AtualizarAtividadeDto):AtualizarAtividadeDto

}