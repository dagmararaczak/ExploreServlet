package pl.hit.servlets.events;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import static pl.hit.servlets.events.EventType.*;

public class EventManager {

    public static void main(String[] args)  {

        EventManager.getInstance().notify(APPLICATION_STARTED);
        EventManager.getInstance().notify(REQUEST_STARTED);
        EventManager.getInstance().notify(REQUEST_STARTED);
        Map<EventType,Integer> occurences = EventManager.getInstance().getOccurences();

        for(Map.Entry<EventType,Integer> element : occurences.entrySet()){
            System.out.println(element.getKey() +" " + element.getValue());

        }

        EventManager.getInstance().store();
        EventManager.getInstance().notify(REQUEST_STARTED);
        EventManager.getInstance().notify(REQUEST_STARTED);
        EventManager.getInstance().load();

        for(Map.Entry<EventType,Integer> element : occurences.entrySet()){
            System.out.println(element.getKey() +" " + element.getValue());

        }




    }
    public static EventManager getInstance() {
        return InstanceWrapper.INSTANCE;
    }

    private ConcurrentHashMap<EventType, Integer> eventsOccurence = new ConcurrentHashMap<>();

    /**
     * Metoda służy do załadowania wcześniejszych wystąpień zdarzeń
     * z pliku.
     */
    public void load() {
        if (getStoreFile().exists()) {
            Properties properties = new Properties();
            try {
                properties.load(new BufferedReader(new FileReader(getStoreFile())));
                for (String prop : properties.stringPropertyNames()) {
                    EventType eventType = EventType.valueOf(prop);
                    eventsOccurence.put(eventType,
                            Integer.parseInt(properties.getProperty(prop, "0")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            init();
        }
    }

    /**
     * Metoda służy do zapisu bieżących wystąpień do pliku konfiguracyjnego.
     */
    public void store() {
        Properties properties = new Properties();
        for (Map.Entry<EventType, Integer> entry : eventsOccurence.entrySet()) {
            properties.setProperty(entry.getKey().name(), entry.getValue().toString());
        }
        try {
            properties.store(new FileWriter(getStoreFile()), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda służy do powiadomienia o wystąpieniu danego zdarzenia.
     * @param eventType typ zdarzenia, które wystąpiło
     */
    public void notify(EventType eventType) {
        eventsOccurence.compute(eventType, (type, integer) -> integer + 1);
        System.out.println("EventManager.notify Zdarzenie typu " + eventType
                + " w wątku [" + Thread.currentThread().getName() + "]");
    }

    /**
     * Metoda zwraca kopie mapy wystąpień zdarzeń.
     *
     * @return kopia mapy wystąpień zdarzeń.
     */
    public Map<EventType, Integer> getOccurences() {
        return new TreeMap<>(eventsOccurence);
    }

    private EventManager() {
        init();
    }

    private void init() {
        for (EventType eventType : EventType.values()) {
            eventsOccurence.put(eventType, 0);
        }
    }

    private File getStoreFile() {
        String userDir = System.getProperty("user.home");
        return Paths.get(userDir, "occurences.dat").toFile();
    }

    /*
        Wykorzystywana jest wewnętrzna klasa statyczna do poprawnego
        utworzenia pojedynczej instancji klasy EventManager (wzorzec Singleton).
     */
    private static class InstanceWrapper {

        private static final EventManager INSTANCE = new EventManager();
    }
}
