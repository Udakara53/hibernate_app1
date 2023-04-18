import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class AppInitializer {
    public static void main(String[] args) {
        StandardServiceRegistryBuilder standardServiceRegistryBuilder
            =new StandardServiceRegistryBuilder();
        Map<String,String> databaseConfiguration=new HashMap<>();
        databaseConfiguration.put(Environment.USER,
                "jdbc:mysql://localhost:3306/asd_1?createDatabaseIfNotExist=true");
        databaseConfiguration.put(Environment.USER,"root");
        databaseConfiguration.put(Environment.PASS,"1234");
        databaseConfiguration.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        databaseConfiguration.put(Environment.DIALECT,"org.hibernate.dialect.MySQL57Dialect");
        standardServiceRegistryBuilder.applySettings(databaseConfiguration);

        StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        Metadata metadata = metadataSources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
}