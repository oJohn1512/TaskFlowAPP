package aplicativo.build.service_impl

import aplicativo.build.dto.AtualizarCadastroTecnicoDto
import aplicativo.build.dto.CadastrarTecnicoDto
import aplicativo.build.mapper.TecnicoMapperImpl
import aplicativo.build.model.Tecnico
import aplicativo.build.repository.TecnicoRepository
import aplicativo.build.service.TecnicoService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional


@ApplicationScoped
class TecnicoServiceImpl: TecnicoService {

    @Inject
    lateinit var repository: TecnicoRepository

    @Inject
    lateinit var mapper: TecnicoMapperImpl

    override fun listTecnicos(): MutableList<Tecnico> {
        return repository.listAll()
    }

    @Transactional
    override fun criaTecnico(novoTecnico: CadastrarTecnicoDto): CadastrarTecnicoDto {
        val tecnicoEntity = mapper.toEntityCadastrarTecnico(novoTecnico)
        repository.persist(tecnicoEntity)
        return mapper.toDtoCadastrarTecnico(tecnicoEntity)
    }

    @Transactional
    override fun deletarTecnico(id: Long) {
        if (repository.findById(id) != null) {
            repository.deleteById(id)
        }
    }

    @Transactional
    override fun atualizarTecnico(id: Long, atualizarTecnico: AtualizarCadastroTecnicoDto): AtualizarCadastroTecnicoDto {
        val tecnicoPeloId = repository.findById(id)
        tecnicoPeloId.nomeTecnico = atualizarTecnico.nomeTecnico
        tecnicoPeloId.setor = atualizarTecnico.setor
        repository.persist(tecnicoPeloId)
        return mapper.toDtoAtualizarTecnico(tecnicoPeloId)
    }
}