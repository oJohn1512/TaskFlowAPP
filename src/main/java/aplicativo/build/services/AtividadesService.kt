package aplicativo.build.services

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto

interface AtividadesService {

    fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto

    fun deletarAtividade(descAtividadeDto: DeletarAtividadeDto): DeletarAtividadeDto

    fun atualizarAtividade(descAtividade: AtualizarAtividadeDto):AtualizarAtividadeDto

}