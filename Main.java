package com.pkg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

class Compliments{
    public int coke200ml,sprite500ml;
}
class Pizza extends Compliments{
   public int purchasedArray[];
}
class Customer{
    public int id,amount;
    public String Name,address;



}

class GUI extends JFrame
{

    private JRadioButton res, par;
    private ButtonGroup group;
    private JLabel logo_name, id, date_time, table_no, name, address, contact, toppings_label, quantity_label,Compliment;
    private JTextField table_no_tf, name_tf, address_tf, contact_tf,id_tf;
    private JPanel input_panel, id_panel, pizza_panel, pizza2_panel, quantity_panel, initial_panel, buttons_panel,compliment_panel;
    private JPanel top1_panel, top2_panel;
    private JCheckBox top_onion, top_mushroom, top_broccoli, top_corn, top_capsicum, top_cheese;
    private JComboBox quantity_box;
    String date;
    String Comp;
    String[] complimentstr={"coke200-1","sprite500-1"};
    public float rate = 00;
    int sprite500,coke200;

    private JLabel quantity_op_label, quantity_op, rate_label, rate_op_label,Compliment_op;
    private JButton print, clear, calculate;
    private ImageIcon print_icon, clear_icon;
    private JLabel table_no_op, name_op, address_op, contact_op;
    String table_no_str, name_str, address_str, contact_str;
    private JLabel table_no2, name2, address2, contact2;
    private JLabel date_time2;
    private JLabel logo_name2;


    public GUI()
    {
        super("Pizza GUI");
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        logo_name = new JLabel("Pizza GUI", 0);
        initial_panel = new JPanel();
        initial_panel.setLayout(new GridLayout(2, 1));





        logo_name = new JLabel("Pizza GUI",0);
        initial_panel.add(logo_name);


        date = new SimpleDateFormat("EEEE yyyy-MM-dd   hh:mm:ss a zzz").format(new Date());
        date_time = new JLabel(date);
        initial_panel.add(date_time);

        add(initial_panel);
    }


    public void Input()
    {
        input_panel = new JPanel();
        input_panel.setLayout(new GridLayout(5, 2, 5, 5));

        id_panel = new JPanel();
        id_panel.setLayout(new GridLayout(1, 3));


        id = new JLabel("ID");

        res = new JRadioButton("Biller 1");
        res.setActionCommand("res");
        par = new JRadioButton("Biller 2");
        par.setActionCommand("par");


        group = new ButtonGroup();
        group.add(res);
        group.add(par);
        id_panel.add(res);
        id_panel.add(par);



        input_panel.add(id);
        input_panel.add(id_panel);


        table_no = new JLabel("Table Number");
        table_no_tf = new JTextField("", 5);
        input_panel.add(table_no);
        input_panel.add(table_no_tf);


        name = new JLabel("Name");
        address = new JLabel("Address");
        contact = new JLabel("Contact Number");
        name_tf = new JTextField("", 10);
        address_tf = new JTextField("", 20);
        contact_tf = new JTextField("", 10);
        input_panel.add(name);
        input_panel.add(name_tf);
        input_panel.add(address);
        input_panel.add(address_tf);
        input_panel.add(contact);
        input_panel.add(contact_tf);

        add(input_panel);




    }

    public void Pizza()
    {
        top1_panel = new JPanel();
        top1_panel.setLayout(new GridLayout(1, 3));

        top2_panel = new JPanel();
        top2_panel.setLayout(new GridLayout(1, 3));

        pizza_panel = new JPanel();
        pizza_panel.setLayout(new GridLayout(2, 1));

        pizza2_panel = new JPanel();
        pizza2_panel.setLayout(new GridLayout(2, 1));

        toppings_label = new JLabel("Toppings:");

        top_onion = new JCheckBox("Onion-50", false);
        top_mushroom = new JCheckBox("Mushroom-50", false);
        top_broccoli = new JCheckBox("Broccoli-50", false);
        top_corn = new JCheckBox("Corn-50", false);
        top_capsicum = new JCheckBox("Capsicum-50", false);
        top_cheese = new JCheckBox("Cheese-50", false);




        ItemListener itemListener = new ItemListener()
        {
            public void itemStateChanged(ItemEvent itemEvent)
            {
                AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
                int state = itemEvent.getStateChange();
                if(state == ItemEvent.SELECTED)
                {
                    rate = rate + 50;
                }
            }
        };

        top_onion.addItemListener(itemListener);
        top_mushroom.addItemListener(itemListener);
        top_broccoli.addItemListener(itemListener);
        top_corn.addItemListener(itemListener);
        top_capsicum.addItemListener(itemListener);
        top_cheese.addItemListener(itemListener);

        top1_panel.add(top_onion);
        top1_panel.add(top_mushroom);
        top1_panel.add(top_broccoli);
        top2_panel.add(top_corn);
        top2_panel.add(top_capsicum);
        top2_panel.add(top_cheese);

        pizza_panel.add(top1_panel);
        pizza_panel.add(top2_panel);

        pizza2_panel.add(toppings_label);
        pizza2_panel.add(pizza_panel);
        add(pizza2_panel);


    }

    public void Quantity()
    {
        quantity_label = new JLabel("Quantity: ");
        quantity_op_label = new JLabel("Quantity: ");
        quantity_op = new JLabel();
        quantity_panel = new JPanel();
        quantity_panel.setLayout(new GridLayout(2, 2));
        String[] quantity = {"1", "2", "3", "4", "5"};

        JComboBox<String>quantity_box = new JComboBox<String>();
        for(int i = 0; i < quantity.length; i++)
            quantity_box.addItem(quantity[i]);

        quantity_box.setSelectedIndex(0);

        quantity_panel.add(quantity_label);
        quantity_panel.add(quantity_box);


        quantity_box.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                quantity_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
            }
        });


        add(quantity_panel);
    }





    public void Output()
    {
        print_icon = new ImageIcon("print.png");
        clear_icon = new ImageIcon("clear.png");


        buttons_panel = new JPanel();
        buttons_panel.setLayout(new GridLayout(1, 2, 50, 10));

        table_no2 = new JLabel("Table No.: ");
        name2 = new JLabel("Name: ");
        address2 = new JLabel("Address: ");
        contact2= new JLabel("Contact Number: ");



        String rate_str;
        rate_str = Float.toString(rate);
        rate_label = new JLabel("Rate: ");
        rate_op_label = new JLabel(rate_str);


        print = new JButton("Place an Order");
        print.setRolloverIcon(print_icon);
        print.setRolloverEnabled(true);
        clear = new JButton("Clear");


        buttons_panel.add(print);
        buttons_panel.add(clear);

        add(buttons_panel);


        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                table_no_tf.setText("");
                name_tf.setText("");
                address_tf.setText("");
                contact_tf.setText("");
                group.clearSelection();
                name.setEnabled(true);
                address.setEnabled(true);
                contact.setEnabled(true);

                name_tf.setEditable(true);
                address_tf.setEditable(true);
                contact_tf.setEditable(true);
                name_tf.setEnabled(true);
                address_tf.setEnabled(true);
                contact_tf.setEnabled(true);
                table_no.setEnabled(true);
                table_no_tf.setEnabled(true);
                table_no_tf.setEditable(true);

                top_broccoli.setSelected(false);
                top_capsicum.setSelected(false);
                top_cheese.setSelected(false);
                top_corn.setSelected(false);
                top_mushroom.setSelected(false);
                top_onion.setSelected(false);


            }
        });

        print.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                String rate_str;
                String quant = quantity_op.getText();
                int q =Integer.parseInt(quant);



                int amount = (int) rate * q;



                if (amount>500){
                    if(amount<1000){
                        Comp=complimentstr[0];
                    }
                    else
                        Comp=complimentstr[1];
                }
                rate_str = Float.toString(rate);
                rate_label = new JLabel("Rate: ");
                rate_op_label = new JLabel(String.valueOf(amount));


                JFrame output = new JFrame();
                output.setLayout(new GridLayout(10, 2));

                logo_name2 = new JLabel("Pizza GUI",  0);
                output.add(logo_name2);
                date = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());
                date_time2 = new JLabel(date);
                output.add(date_time2);

                table_no_str = table_no_tf.getText();
                name_str = name_tf.getText();
                address_str = address_tf.getText();
                contact_str = contact_tf.getText();
                Compliment = new JLabel("Compliments");



                table_no_op = new JLabel(table_no_str);
                name_op = new JLabel(name_str);
                address_op = new JLabel(address_str);
                contact_op = new JLabel(contact_str);
                Compliment_op = new JLabel(Comp);

                output.add(table_no2);
                output.add(table_no_op);
                output.add(name2);
                output.add(name_op);
                output.add(address2);
                output.add(address_op);
                output.add(contact2);
                output.add(contact_op);

                output.add(rate_label);
                output.add(rate_op_label);
                output.add(quantity_op_label);
                output.add(quantity_op);
                output.add(Compliment);
                output.add(Compliment_op);
                output.pack();

                output.setLocationRelativeTo(null);

                output.setVisible(true);

                JOptionPane.showMessageDialog(null, "Your Order Has Been Placed!");
            }
        });

    }

}


class Main
{
    public static void main(String[] args)
    {
        GUI gui_obj = new GUI();
        gui_obj.Input();
        gui_obj.Pizza();
        gui_obj.Quantity();
        gui_obj.Output();

        gui_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui_obj.setLocationByPlatform(true);
        gui_obj.setSize(575,600);
        gui_obj.setVisible(true);

    }
}
