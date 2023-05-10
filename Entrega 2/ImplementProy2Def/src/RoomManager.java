import java.io.*;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;



public class RoomManager {
    private List<Room> rooms;

    public RoomManager() {
        this.rooms = new ArrayList<>();
    }

    public void createRoom(Room room) {
        this.rooms.add(room);
    }

    public void loadRoomsFromFile(String filename) {
        try {
            CSVReader reader = new CSVReader(new FileReader(filename));
            String[] line;
            // Skip the header
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Room room = new Room();
                room.setId(line[0]);
                room.setLocation(line[1]);
                room.setCapacity(Integer.parseInt(line[2]));
                room.setType(line[3]);
                room.setHasBalcony(Boolean.parseBoolean(line[4]));
                room.setView(line[5]);
                room.setHasKitchen(Boolean.parseBoolean(line[6]));
                room.setSize(Integer.parseInt(line[7]));
                room.setNumberOfBeds(Integer.parseInt(line[8]));
                room.setNumberOfChildBeds(Integer.parseInt(line[9]));
                rooms.add(room);
            }
            reader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
    

    public void saveRoomsToFile(String filename) throws IOException {
        FileWriter csvWriter = new FileWriter(filename);
        csvWriter.append("id,location,capacity,type,hasBalcony,view,hasKitchen,size,numberOfBeds,numberOfChildBeds\n");
        for (Room room : rooms) {
            String[] data = {
                room.getId(), 
                room.getLocation(), 
                String.valueOf(room.getCapacity()), 
                room.getType(), 
                String.valueOf(room.isHasBalcony()), 
                room.getView(), 
                String.valueOf(room.isHasKitchen()), 
                String.valueOf(room.getSize()), 
                String.valueOf(room.getNumberOfBeds()), 
                String.valueOf(room.getNumberOfChildBeds())
            };
            csvWriter.append(String.join(",", data));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public int getRoomCount(){
        return 1;
    }
    

    // other methods to manage rooms
}
