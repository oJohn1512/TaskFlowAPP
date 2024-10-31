package aplicativo.build.service.impl

import aplicativo.build.dto.AtualizarAtividadeDto
import aplicativo.build.dto.CriarAtividadeDto
import aplicativo.build.dto.DeletarAtividadeDto
import aplicativo.build.mapper.AtividadesMapper
import aplicativo.build.model.Atividade
import aplicativo.build.repository.AtividadesRepository
import aplicativo.build.services.AtividadesService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional


@ApplicationScoped
class AtividadesServiceImpl: AtividadesService {

    @Inject
    lateinit var mapper: AtividadesMapper

    @Inject
    lateinit var repository: AtividadesRepository


//    override fun listaAtividades(): MutableList<Atividade> {
//        return repository.listAll()
//    }

    @Transactional
    override fun criarAtividade(descAtividadeDto: CriarAtividadeDto): CriarAtividadeDto{
        val atividadeEntity = mapper.toEntityCreate(descAtividadeDto)
        repository.persist(atividadeEntity)
        return mapper.toDtoCreate(atividadeEntity)
    }

    override fun atualizarAtividade(attDesc: AtualizarAtividadeDto, attData:AtualizarAtividadeDto): AtualizarAtividadeDto{
        if ()
        val atividadeEntity = mapper.toEntityUpdate(attDesc,attData)
        atividadeEntity.descAtividade = attDesc.descAtividade
        atividadeEntity.dataInicio = attData.dataInicio
        repository.persist(atividadeEntity)
        return mapper.toDtoUpdate(atividadeEntity)
    }

    //@Transactional
    //override fun deletarAtividade(descAtividadeDto: DeletarAtividadeDto): DeletarAtividadeDto{
        //  val atividadeEntity = mapper.toEntityDelete(descAtividadeDto)
        // repository.delete(atividadeEntity)
        //   return mapper.toDtoDelete(atividadeEntity)
        //}

    override fun deletarAtividade(idPraDeletar: Long) {
        if(repository.findById(idPraDeletar) != null)
            repository.deleteById(idPraDeletar)
        else {
            println("Atividade não encontrada na base")
        }

    }



    //VERIFICANDO A RESPEITO DO DELETE SE É FEITO DESSA FORMA
    // OU UTILIZAR O DELETEBYID

}