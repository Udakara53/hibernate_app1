import org.hibernate.Session;

public class AppInitializer {

    private static void printMySQLVersion(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object result = session.createNativeQuery("SELECT VERSION()").getSingleResult();
            System.out.println(result);
        }
    }
    private static void printDateAndTime(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object result = session.createNativeQuery("SELECT NOW()").getSingleResult();
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        printDateAndTime();
        printMySQLVersion();
    }
}

