package aplicativo.build.services

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto

interface AtividadesService {

    fun criarAtividade(descAtividade: CriarAtividadeDto, dataInicio: CriarAtividadeDto): CriarAtividadeDto

    fun deletarAtividade(id: DeletarAtividadeDto): DeletarAtividadeDto

    fun atualizarAtividade(descAtividade: AtualizarAtividadeDto, dataInicio: AtualizarAtividadeDto):Void

}