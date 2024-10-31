package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.model.Atividade
import io.quarkus.runtime.annotations.RegisterForReflection


@RegisterForReflection
interface AtividadesMapper {


    fun toDtoCreate(entity: Atividade):CriarAtividadeDto
    fun toEntityCreate(dto: CriarAtividadeDto):Atividade

    fun toDtoUpdate(entity: Atividade):AtualizarAtividadeDto
    fun toEntityUpdate(dto: AtualizarAtividadeDto):Atividade

    fun toDtoDelete(entity: Atividade):DeletarAtividadeDto
    fun toEntityDelete(dto: DeletarAtividadeDto): Atividade


}