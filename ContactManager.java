import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

class Contact implements Serializable {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString(){
        return name + " | " + phone + " | " + email;
    }
}

public class ContactManager extends JFrame implements ActionListener {

    JTextField nameField, phoneField, emailField;
    JButton addBtn, editBtn, deleteBtn;
    DefaultListModel<Contact> model;
    JList<Contact> contactList;

    ArrayList<Contact> contacts = new ArrayList<>();

    File file = new File("contacts.dat");

    ContactManager(){

        setTitle("Contact Management System");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3,2,5,5));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        add(inputPanel, BorderLayout.NORTH);

       
        model = new DefaultListModel<>();
        contactList = new JList<>(model);
        add(new JScrollPane(contactList), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();

        addBtn = new JButton("Add");
        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");

        addBtn.addActionListener(this);
        editBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        loadContacts();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == addBtn){

            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            Contact c = new Contact(name,phone,email);

            contacts.add(c);
            model.addElement(c);

            saveContacts();

            clearFields();
        }

        if(e.getSource() == editBtn){

            int index = contactList.getSelectedIndex();

            if(index != -1){

                Contact c = contacts.get(index);

                c.name = nameField.getText();
                c.phone = phoneField.getText();
                c.email = emailField.getText();

                model.set(index,c);

                saveContacts();
            }
        }

        if(e.getSource() == deleteBtn){

            int index = contactList.getSelectedIndex();

            if(index != -1){

                contacts.remove(index);
                model.remove(index);

                saveContacts();
            }
        }
    }

    void clearFields(){
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    void saveContacts(){

        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(contacts);
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    void loadContacts(){

        if(!file.exists()) return;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            contacts = (ArrayList<Contact>) in.readObject();

            in.close();

            for(Contact c : contacts){
                model.addElement(c);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ContactManager();
    }
}