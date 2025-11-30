package br.com.fatec.modulo1.repository.client;

import br.com.fatec.modulo1.repository.orm.PessoaOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaMongoRepository extends MongoRepository<PessoaOrm, String> {

}
