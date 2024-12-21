package com.dette.repository.JPA;

import javax.persistence.NoResultException;

import com.dette.core.database.implement.RepositoryJpaImpl;
import com.dette.entities.Article;
import com.dette.entities.Client;
import com.dette.repository.implement.ClientRepository;

public class ClientJPA extends RepositoryJpaImpl<Client> implements ClientRepository {

    public ClientJPA() {
        type = Client.class;
        coloneSelectBy = "telephone";
    }
    // -------------------------------------

}
