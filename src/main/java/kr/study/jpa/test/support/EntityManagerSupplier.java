package kr.study.jpa.test.support;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityManagerSupplier {
    private static final String PERSISTENCE_UNIT_NAME = "hello";
    private static  EntityManagerSupplier instance;

    private EntityManagerFactory emf;

    public static EntityManagerFactory createEntityManagerFactory() {
        synchronized (EntityManagerFactory.class) {
            if (instance == null) {
                instance = new EntityManagerSupplier();
            }
        }
        return instance._createEntityManagerFactory();
    }

    public static void closeEntityManagerFactory() {
        EntityManagerSupplier instatnce;
        synchronized (EntityManagerSupplier.class) {
            if(EntityManagerSupplier.instance != null) {
                instance = EntityManagerSupplier.instance;
                EntityManagerSupplier.instance = null;
            } else {
                return ;
            }
        }
        instance._closeEntityManagerFactory();
    }


    private EntityManagerFactory _createEntityManagerFactory() {
        synchronized (this) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            }
        }
        return emf;
    }

    private void _closeEntityManagerFactory() {
        EntityManagerFactory emf;
        synchronized (this) {
            if (this.emf != null) {
                emf = this.emf;
                this.emf = null;
            } else {
                return;
            }
        }
        emf.close();
    }
}
