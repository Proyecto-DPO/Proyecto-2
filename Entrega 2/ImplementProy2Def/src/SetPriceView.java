import java.io.*;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javax.swing.*;


class SetPricesView {
    public void showWindow() {
        JFrame frame = new JFrame("Set Prices");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}