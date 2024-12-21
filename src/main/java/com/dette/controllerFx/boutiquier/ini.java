package com.dette.controllerFx.boutiquier;

import com.dette.core.factory.Impl.FactoryRepo;
import com.dette.core.factory.Impl.FactoryService;
import com.dette.entities.Article;
import com.dette.entities.Client;
import com.dette.entities.Detail;
import com.dette.entities.Dette;
import com.dette.repository.implement.ArticleRepository;
import com.dette.repository.implement.ClientRepository;
import com.dette.repository.implement.DetailRepository;
import com.dette.repository.implement.DetteRepository;
import com.dette.services.ArticleService;
import com.dette.services.ClientService;
import com.dette.services.DetailService;
import com.dette.services.DetteService;
import com.dette.services.servicespe.IArticleService;
import com.dette.services.servicespe.IClientService;
import com.dette.services.servicespe.IDetailService;
import com.dette.services.servicespe.IDetteService;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ini {
    // ----------------------------- FACTORIES -----------------------------

    // factory repository
    private FactoryRepo<Client> clientRepoFactory = new FactoryRepo<>(Client.class);
    private FactoryRepo<Article> articleRepoFactory = new FactoryRepo<>(Article.class);
    private FactoryRepo<Dette> detteRepoFactory = new FactoryRepo<>(Dette.class);
    private FactoryRepo<Detail> detailRepoFactory = new FactoryRepo<>(Detail.class);

    // initialisation des SERVICE pour chaque entité
    private ClientRepository clientRepository = (ClientRepository) clientRepoFactory.createRepository();
    private ArticleRepository articleRepository = (ArticleRepository) articleRepoFactory.createRepository();
    private DetteRepository detteRepository = (DetteRepository) detteRepoFactory.createRepository();
    private DetailRepository detailRepository = (DetailRepository) detailRepoFactory.createRepository();

    // factory service
    private FactoryService<Client> clientServiceFactory = new FactoryService<>(Client.class, clientRepository);
    private FactoryService<Article> articleServiceFactory = new FactoryService<>(Article.class, articleRepository);
    private FactoryService<Dette> detteServiceFactory = new FactoryService<>(Dette.class, detteRepository);
    private FactoryService<Detail> detailServiceFactory = new FactoryService<>(Detail.class, detailRepository);

    // initialisation des SERVICE pour chaque entité
    protected IClientService clientService = (ClientService) clientServiceFactory.createService();
    protected IArticleService articleService = (ArticleService) articleServiceFactory.createService();
    protected IDetteService detteService = (DetteService) detteServiceFactory.createService();
    protected IDetailService detailService = (DetailService) detailServiceFactory.createService();

    // -------------------------- FONCTION COMMUN
    // ---------------------------------------

    public void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void isNull(Object object, String title, String message) {
        if (object == null) {
            showAlert(AlertType.ERROR, title, message);
            return;
        }
    }

    public void isEmpty(String object, String title, String message) {
        if (object.isEmpty()) {
            showAlert(AlertType.ERROR, title, message);
            return;
        }
    }

    public void isPositif(Object object, String title, String message) {
        if (object instanceof Number) {
            double value = ((Number) object).doubleValue();
            if (value <= 0) {
                showAlert(AlertType.ERROR, title, message);
            }
        }
    }

}
