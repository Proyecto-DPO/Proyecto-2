import java.io.IOException;
import java.util.*;

public class RoomGenerator {
    private static final List<String> LOCATIONS = Arrays.asList("North Wing", "South Wing", "East Wing", "West Wing");
    private static final List<String> TYPES = Arrays.asList("Standard", "Suite", "Double Suite");
    private static final List<String> VIEWS = Arrays.asList("Garden", "Pool", "Street", "Beach");

    public static Room generateRandomRoom(int id) {
        Random random = new Random();

        Room room = new Room();
        room.setId(String.valueOf(id));
        room.setLocation(LOCATIONS.get(random.nextInt(LOCATIONS.size())));
        room.setCapacity(1 + random.nextInt(4)); // capacity between 1 and 4
        room.setType(TYPES.get(random.nextInt(TYPES.size())));
        room.setHasBalcony(random.nextBoolean());
        room.setView(VIEWS.get(random.nextInt(VIEWS.size())));
        room.setHasKitchen(random.nextBoolean());
        room.setSize(20 + random.nextInt(30)); // size between 20 and 50
        room.setNumberOfBeds(1 + random.nextInt(3)); // number of beds between 1 and 3
        room.setNumberOfChildBeds(random.nextInt(2)); // number of child beds between 0 and 1

        return room;
    }

    public static void main(String[] args) throws IOException {
        RoomManager roomManager = new RoomManager();
        for (int i = 0; i < 50; i++) {
            roomManager.createRoom(generateRandomRoom(i+1));
        }
        roomManager.saveRoomsToFile("rooms.csv");
    }
}
