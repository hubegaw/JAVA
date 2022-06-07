package addressbook.pl.addresbook.DatabaseConnector;

import addressbook.pl.addresbook.entity.PersonalinfoEntity;
import addressbook.pl.addresbook.entity.AddressEntity;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();
    static Session session = entityManager.unwrap(org.hibernate.Session.class);

    private static List<Query> queries = new ArrayList<>();

    public static List<Object[]> getPersonsInfo(int qNumber, String filter) {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        session = entityManager.unwrap(org.hibernate.Session.class);
        List<Object[]> persons = new ArrayList<>();
        try {
          transaction = session.getTransaction();
          transaction.begin();

          setQueries();
          Query q = queries.get(qNumber);
          if(!filter.equals(""))
            q.setParameter(1, filter);
          persons = q.getResultList();

          transaction.commit();
        } finally {
            if(transaction.isActive())
                transaction.rollback();
            entityManager.close();
            session.close();
            entityManagerFactory.close();
        }
        return persons;
    }

    public static void create(List<String> info) {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        session = entityManager.unwrap(org.hibernate.Session.class);
        try {
            transaction = session.getTransaction();
            transaction.begin();

            PersonalinfoEntity person = new PersonalinfoEntity();
            AddressEntity address = new AddressEntity();

            person.setName(info.get(0));
            person.setSurname(info.get(1));
            person.setPhoneNumber(info.get(2));
            address.setStreet(info.get(3));
            address.setHouseNumber(info.get(4));
            address.setApartmentNumber(info.get(5));
            address.setTown(info.get(6));
            address.setState(info.get(7));
            address.setCountry(info.get(8));

            person.setAddressesByIdPerson(new ArrayList<AddressEntity>());
            person.getAddressesByIdPerson().add(address);
            address.setPersonalinfoByIdPerson(person);

            entityManager.persist(person);
            transaction.commit();
        } finally {
            if(transaction.isActive())
                transaction.rollback();
            entityManager.close();
            session.close();
            entityManagerFactory.close();
        }
    }

  /*  public static void update(String id) {
        List<PersonalinfoEntity> person = new ArrayList<>();


        try {
            transaction = session.getTransaction();
            transaction.begin();

            setQueries();
            Query q = queries.get(7);
            q.setParameter(1, id);
            person = q.getResultList();
            PersonalinfoEntity p = person.get(0);

            transaction.commit();
        } finally {
            if(transaction.isActive())
                transaction.rollback();
        }
    }
*/
    public static void delete(String id) {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        session = entityManager.unwrap(org.hibernate.Session.class);
        transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();

            Query person = session.createQuery("select p from PersonalinfoEntity p where p.idPerson = ?1");
            person.setParameter(1,Integer.parseInt(id));
            List<PersonalinfoEntity> lista = person.getResultList();
            PersonalinfoEntity p = lista.get(0);

            entityManager.remove(p);
            entityManager.flush();
            entityManager.clear();
            transaction.commit();
        } finally {
            if(transaction.isActive())
                transaction.rollback();
            entityManager.close();
            session.close();
            entityManagerFactory.close();
        }
    }

    private static void setQueries() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        session = entityManager.unwrap(org.hibernate.Session.class);
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where p.name = ?1"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where p.surname = ?1"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where p.phoneNumber = ?1"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where a.town = ?1"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where a.state = ?1"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where a.country = ?1"));
        queries.add(entityManager.createQuery("select p.idPerson, p.name, p.surname, p.phoneNumber, a.street, a.houseNumber, a.apartmentNumber, a.state, a.town, a.country" +
                " from PersonalinfoEntity p left join AddressEntity a on a.personalinfoByIdPerson = p where p.idPerson = ?1"));
    }

}
