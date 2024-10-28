package aplicativo.build.mapper

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.model.Atividade
import aplicativo.build.repository.AtividadesRepository
import io.quarkus.runtime.annotations.RegisterForReflection
import jakarta.persistence.Entity


@RegisterForReflection
interface AtividadesMapper {


    fun toDtoCreate(entity: Atividade):CriarAtividadeDto
    fun toEntityCreate(dto: CriarAtividadeDto):Atividade

    fun toDtoUpdate(entity: Atividade):AtualizarAtividadeDto
    fun toEntityUpdate(dto: AtualizarAtividadeDto):Atividade

    fun toDtoDelete(entity: Atividade):DeletarAtividadeDto
    fun toEntityDelete(dto: DeletarAtividadeDto): Atividade


    // fun createMapper(descAtividadeDto: CriarAtividadeDto, dataInicio: CriarAtividadeDto):CriarAtividadeDto
    // fun updateMapper(descAtividadeDto: AtualizarAtividadeDto, dataInicio: AtualizarAtividadeDto):Void
    // fun deleteMapper(id: DeletarAtividadeDto): DeletarAtividadeDto


}