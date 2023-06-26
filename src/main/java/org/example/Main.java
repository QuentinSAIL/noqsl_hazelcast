package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Connexion à Hazelcast
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        System.out.println("Connecté à Hazelcast.");

        // Mise en place du mapper CSV
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

        // Lecture des données du fichier CSV et mise dans Hazelcast
        IMap<String, Contact> mapContacts = hz.getMap("contacts");
        try (InputStream in = Main.class.getResourceAsStream("/contacts.csv");
             Reader reader = new InputStreamReader(in)) {
            MappingIterator<Map<String, String>> contactIterator = csvMapper.readerFor(Map.class).with(csvSchema).readValues(reader);
            while (contactIterator.hasNext()) {
                Map<String, String> contactMap = contactIterator.next();
                String title = contactMap.get("title");
                String name = contactMap.get("name");
                String adress = contactMap.get("adress");
                String realAdress = contactMap.get("realAdress");
                String departement = contactMap.get("departement");
                String country = contactMap.get("country");
                String tel = contactMap.get("tel");
                String email = contactMap.get("email");
                Contact contact = new Contact(title, name, adress, realAdress, departement, country, tel, email);
                mapContacts.put(name, contact);
                System.out.println("Contact ajouté: " + contact.toString());
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }

        System.out.println("Fini, toutes les données sont dans Hazelcast.");

        // Affiche des informations sur le cluster en cours
        System.out.println("Informations sur le cluster : " + hz.getCluster());
        System.out.println("Informations sur le membre local : " + hz.getCluster().getLocalMember());
    }
}

