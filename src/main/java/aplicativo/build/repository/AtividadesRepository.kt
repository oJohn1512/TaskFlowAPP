package aplicativo.build.repository

import aplicativo.build.model.Atividade
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped


@ApplicationScoped
class AtividadesRepository: PanacheRepository<Atividade> {

}

