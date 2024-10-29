package aplicativo.build.services

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.model.Atividade

interface AtividadesService {

//    fun listaAtividades(): MutableList<Atividade>

    fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto

    fun deletarAtividade(descAtividadeDto: DeletarAtividadeDto): DeletarAtividadeDto

    fun atualizarAtividade(attDesc: AtualizarAtividadeDto, attData: AtualizarAtividadeDto):AtualizarAtividadeDto

}