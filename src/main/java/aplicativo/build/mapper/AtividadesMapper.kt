package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.repository.AtividadesRepository
import io.quarkus.runtime.annotations.RegisterForReflection


@RegisterForReflection
interface AtividadesMapper {

    fun createMapper(descAtividadeDto: CriarAtividadeDto, dataInicio: CriarAtividadeDto):CriarAtividadeDto

    fun updateMapper(descAtividadeDto: AtualizarAtividadeDto, dataInicio: AtualizarAtividadeDto):Void

    fun deleteMapper(id: DeletarAtividadeDto): DeletarAtividadeDto


}