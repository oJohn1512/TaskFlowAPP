package aplicativo.build.service.impl

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.mapper.AtividadesMapper
import aplicativo.build.repository.AtividadesRepository
import aplicativo.build.services.AtividadesService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject



@ApplicationScoped
class AtividadesServiceImpl: AtividadesService {

    @Inject
    lateinit var mapper: AtividadesMapper

    @Inject
    lateinit var repository: AtividadesRepository


    override fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto{
        val atividadeEntity = mapper.toEntityCreate(descAtividadeDto)
        repository.persist(atividadeEntity)
        return mapper.toDtoCreate(atividadeEntity)
    }

    override fun atualizarAtividade(descAtividade: AtualizarAtividadeDto): AtualizarAtividadeDto{

    }

    override fun deletarAtividade(descAtividade: DeletarAtividadeDto): DeletarAtividadeDto{

        return repository.delete()
    }


}