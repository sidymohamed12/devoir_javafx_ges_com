module com.dette {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.yaml.snakeyaml;
    requires lombok;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires javafx.base;

    opens com.dette to javafx.fxml, lombok, java.sql, java.persistence, jbcrypt, org.yaml.snakeyaml;
    opens com.dette.entities to org.hibernate.orm.core;
    opens com.dette.controllerFx.boutiquier to javafx.fxml;

    exports com.dette.entities;
    exports com.dette;
}
