package ataberkkilavuzcu;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class UserJDatePicker {
    JFrame frame;
    JDatePickerImpl datePicker; // Declare the datePicker as an instance variable
    Date selectedDate; // Variable to store the picked date
    private int day,month,year;
    private boolean dateSelected = false;

    public UserJDatePicker() {
        frame = new JFrame("Date Picker");
        frame.setLayout(new FlowLayout());

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanelImpl = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanelImpl);

        // Add ActionListener to the datePicker object
        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected date
                selectedDate = (Date) datePicker.getModel().getValue();
                // Extract day, month, and year from the selectedDate
                Calendar cal = Calendar.getInstance();
                cal.setTime(selectedDate);
                day = cal.get(Calendar.DAY_OF_MONTH);
                month = cal.get(Calendar.MONTH) + 1; // January is 0, so we add 1
                year = cal.get(Calendar.YEAR);

                // You can perform further actions with the extracted components here
                System.out.println("Selected date: " + selectedDate);
                System.out.println("Day: " + day);
                System.out.println("Month: " + month);
                System.out.println("Year: " + year);

                dateSelected = true;
            }
        });
        frame.add(datePicker);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        waitForDateSelection();
        frame.setVisible(false);
    }

    
    public void waitForDateSelection(){
        while(!dateSelected){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
}
