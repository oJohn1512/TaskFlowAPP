package aplicativo.build.repository

import aplicativo.build.model.Tecnico
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TecnicoRepository: PanacheRepository<Tecnico> {
}