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
import jakarta.ws.rs.NotFoundException


@ApplicationScoped
class TecnicoServiceImpl: TecnicoService {

    @Inject
    lateinit var repository: TecnicoRepository

    @Inject
    lateinit var mapper: TecnicoMapperImpl

    override fun listTecnicos(): List<Tecnico> {
        return try {
            repository.listAll()
        } catch (e: Exception) {
            e.printStackTrace()
            println("Erro ao listar Tecnicos")
            emptyList()
        }
    }

    @Transactional
    override fun criaTecnico(novoTecnico: CadastrarTecnicoDto): CadastrarTecnicoDto {
        val tecnicoEntity = mapper.toEntityCadastrarTecnico(novoTecnico)
        repository.persist(tecnicoEntity)
        return mapper.toDtoCadastrarTecnico(tecnicoEntity)
    }

    @Transactional
    override fun deletarTecnico(id: Long) {
        try {
            if (repository.findById(id) != null) {
            repository.deleteById(id)
            } else {
            throw NotFoundException("Tenico não encontrada")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("Erro ao deletar tecnico")
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