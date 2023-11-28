import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainn extends JFrame {

    String pathh;
    int lii = 0;

    int sumss;
    int summs1;
    int summs3;
    int summs4;
    int sumsso;
    int summso1;
    int summso3;
    int summso4;
    List<Integer> myListtS = new ArrayList<>();
    List<Integer> myListtS1 = new ArrayList<>();
    List<Integer> myListtS3 = new ArrayList<>();
    List<Integer> myListtS4 = new ArrayList<>();
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel listModel2 = new DefaultListModel();
    DefaultListModel listModel3 = new DefaultListModel();
    DefaultListModel listModel4 = new DefaultListModel();

    static String combovalue;
    private JComboBox comboBox1;
    private JPanel root;
    private JButton button1;
    private JList list1;
    private JTextArea textArea1;
    private JTextField sTextField;
    private JTextField textField1;
    private JButton removeButton;
    private JComboBox comboBox2;
    private JList list2;
    private JTextField textField2;
    private JButton remove2Button1;
    private JTextArea textArea2;
    private JTextField textField3;
    private JButton tradeToTeamButton;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextField textField4;
    private JTextField textField5;
    private JButton submitButton;
    private JButton teamBButton;
    private JButton teamCButton1;
    private JTextField textField6;
    private JButton teamCButton;
    private JTextField textField7;
    private JComboBox comboBox3;
    private JList list3;
    private JTextField textField8;
    private JButton removeButton1;
    private JButton teamAButton;
    private JButton teamBButton1;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JComboBox comboBox4;
    private JList list4;
    private JTextField textField12;
    private JButton removeButton2;
    private JButton teamAButton1;
    private JButton teamBButton2;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JButton teamDButton;
    private JButton teamDButton1;
    private JButton teamDButton2;
    private JButton teamCButton2;
    private JTextField textField16;
    private JButton addTeamButton;

    public Mainn()
    {
        comboBox1.addItem("");
        comboBox2.addItem("");
        comboBox3.addItem("");
        comboBox4.addItem("");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("csv","csv");
                fileChooser.setFileFilter(filter);
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));

                int result = fileChooser.showOpenDialog(root);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    pathh = selectedFile.getAbsolutePath();
                   /* Loadd l = new Loadd();
                    try {
                        l.lo(pathh);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }*/
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer sums = 0;
                combovalue = comboBox1.getSelectedItem().toString();
                Loadd l = new Loadd();
                try {
                    l.wstaw(combovalue,pathh);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                list1.clearSelection();
                listModel.removeAllElements();
                list1.setModel(listModel);
                StringBuilder builder = new StringBuilder();
                for(Integer value : l.myListS)
                {
                    sums = sums + value;
                }
                String number = String.valueOf(sums);
                double amount = Double.parseDouble(number);
                DecimalFormat formatter = new DecimalFormat("#,###");
                textField1.setFont(textField1.getFont().deriveFont(Font.BOLD,12f));
                textField1.setText(formatter.format(amount));
                for (String value : l.myList) {
                    builder.setLength(0);
                    builder.append(value);
                    String text = builder.toString();
                    listModel.addElement(text);
                }
              //  System.out.println(l.myListS.get(0));
                myListtS = l.myListS;
                sumss = 0;
                sumsso = 0;
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer sums = 0;
                combovalue = comboBox2.getSelectedItem().toString();
                Loadd l = new Loadd();
                try {
                    l.wstaw(combovalue,pathh);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                list2.clearSelection();
                listModel2.removeAllElements();
                list2.setModel(listModel2);
                StringBuilder builder = new StringBuilder();
                for(Integer value : l.myListS)
                {
                    sums = sums + value;
                }
                String number = String.valueOf(sums);
                double amount = Double.parseDouble(number);
                DecimalFormat formatter = new DecimalFormat("#,###");
                textField2.setFont(textField2.getFont().deriveFont(Font.BOLD,12f));
                textField2.setText(formatter.format(amount));
                for (String value : l.myList) {
                    builder.setLength(0);
                    builder.append(value);
                    String text = builder.toString();
                    listModel2.addElement(text);
                }
                //  System.out.println(l.myListS.get(0));
                myListtS1 = l.myListS;
                summs1 = 0;
                summso1 = 0;
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea1.getText();
                String selectedText = (String)list1.getSelectedValue();
                if(text.contains(selectedText))
                {
                int iin = list1.getSelectedIndex();
                sumss = sumss - myListtS.get(iin);
                String vaule = list1.getSelectedValue().toString();
                textArea1.setText(text.replaceAll(vaule,""));
                String texttt = textArea4.getText();
                textArea4.setText(texttt.replaceAll(vaule,""));
                String textt = textArea6.getText();
                textArea6.setText(textt.replaceAll(vaule,""));
                String textttt = textArea8.getText();
                textArea8.setText(textttt.replaceAll(vaule,""));
                String number = String.valueOf(sumss);
                double amount = Double.parseDouble(number);
                DecimalFormat formatter = new DecimalFormat("#,###");
                sTextField.setText(formatter.format(amount));
                sTextField.setFont(textField1.getFont().deriveFont(Font.BOLD,12f));
                if (texttt.contains(vaule)) {
                    summso1 = summso1 - myListtS.get(iin);
                    number = String.valueOf(summso1);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField4.setText(formatter.format(amount));
                    textField4.setFont(textField4.getFont().deriveFont(Font.BOLD,12f));
                }
                if (textt.contains(vaule)) {
                    summso3 = summso3 - myListtS.get(iin);
                    number = String.valueOf(summso3);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField10.setText(formatter.format(amount));
                    textField10.setFont(textField10.getFont().deriveFont(Font.BOLD,12f));
                }
                if (textttt.contains(vaule)) {
                    System.out.println(summso4);
                    summso4 = summso4 - myListtS.get(iin);
                    System.out.println(summso4);
                    number = String.valueOf(summso4);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField14.setText(formatter.format(amount));
                    textField14.setFont(textField14.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
                else {
                    JOptionPane.showMessageDialog(null, "You can't remove this player because he isn't added");

                }
            }
        });
        tradeToTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea2.getText();
                String selectedText = (String)list2.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list2.getSelectedIndex();
                    summs1 = summs1 + myListtS1.get(iin);
                    sumsso = sumsso + myListtS1.get(iin);
                    textArea3.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea3.append(selectedText + "\n");
                    text = textArea2.getText();
                    textArea2.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea2.append(selectedText + "\n");
                    String number = String.valueOf(summs1);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField3.setText(formatter.format(amount));
                    textField3.setFont(textField3.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(sumsso);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField5.setText(formatter.format(amount));
                    textField5.setFont(textField5.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        remove2Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea2.getText();
                String selectedText = (String)list2.getSelectedValue();
                if(text.contains(selectedText)) {
                    int iin = list2.getSelectedIndex();
                    summs1 = summs1 - myListtS1.get(iin);
                    String vaule = list2.getSelectedValue().toString();
                    textArea2.setText(text.replaceAll(vaule, ""));
                    String textt = textArea3.getText();
                    textArea3.setText(textt.replaceAll(vaule, ""));
                    String texttt = textArea6.getText();
                    textArea6.setText(texttt.replaceAll(vaule, ""));
                    String textttt = textArea8.getText();
                    textArea8.setText(textttt.replaceAll(vaule, ""));
                    String number = String.valueOf(summs1);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField3.setText(formatter.format(amount));
                    textField3.setFont(textField3.getFont().deriveFont(Font.BOLD, 12f));
                    if (textt.contains(vaule)) {
                        sumsso = sumsso - myListtS1.get(iin);
                        number = String.valueOf(sumsso);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField5.setText(formatter.format(amount));
                        textField5.setFont(textField5.getFont().deriveFont(Font.BOLD, 12f));
                    }
                    if (texttt.contains(vaule)) {
                        summso3 = summso3 - myListtS1.get(iin);
                        number = String.valueOf(summso3);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField10.setText(formatter.format(amount));
                        textField10.setFont(textField10.getFont().deriveFont(Font.BOLD, 12f));
                    }
                    if (textttt.contains(vaule)) {
                        summso4 = summso4 - myListtS1.get(iin);
                        number = String.valueOf(summso4);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField14.setText(formatter.format(amount));
                        textField14.setFont(textField14.getFont().deriveFont(Font.BOLD, 12f));
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You can't remove this player because he isn't added");
                }
            }
        });
        teamBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea1.getText();
                String selectedText = (String)list1.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list1.getSelectedIndex();
                    sumss = sumss + myListtS.get(iin);
                    summso1 = summso1 + myListtS.get(iin);
                    textArea1.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea1.append(selectedText + "\n");
                    text = textArea4.getText();
                    textArea4.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea4.append(selectedText + "\n");
                    String number = String.valueOf(sumss);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    sTextField.setText(formatter.format(amount));
                    sTextField.setFont(textField1.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso1);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField4.setText(formatter.format(amount));
                    textField4.setFont(textField4.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer sums = 0;
                combovalue = comboBox3.getSelectedItem().toString();
                Loadd l = new Loadd();
                try {
                    l.wstaw(combovalue,pathh);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                list3.clearSelection();
                listModel3.removeAllElements();
                list3.setModel(listModel3);
                StringBuilder builder = new StringBuilder();
                for(Integer value : l.myListS)
                {
                    sums = sums + value;
                }
                String number = String.valueOf(sums);
                double amount = Double.parseDouble(number);
                DecimalFormat formatter = new DecimalFormat("#,###");
                textField8.setFont(textField8.getFont().deriveFont(Font.BOLD,12f));
                textField8.setText(formatter.format(amount));
                for (String value : l.myList) {
                    builder.setLength(0);
                    builder.append(value);
                    String text = builder.toString();
                    listModel3.addElement(text);
                }
                //  System.out.println(l.myListS.get(0));
                myListtS3 = l.myListS;
                summs3 = 0;
                summso3 = 0;

            }
        });
        teamCButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea1.getText();
                String selectedText = (String)list1.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list1.getSelectedIndex();
                    sumss = sumss + myListtS.get(iin);
                    summso3 = summso3 + myListtS.get(iin);
                    textArea1.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea1.append(selectedText + "\n");
                    text = textArea6.getText();
                    textArea6.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea6.append(selectedText + "\n");
                    String number = String.valueOf(sumss);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    sTextField.setText(formatter.format(amount));
                    sTextField.setFont(textField1.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso3);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField10.setText(formatter.format(amount));
                    textField10.setFont(textField10.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        teamCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea2.getText();
                String selectedText = (String)list2.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list2.getSelectedIndex();
                    summs1 = summs1 + myListtS1.get(iin);
                    summso3 = summso3 + myListtS1.get(iin);
                    String textt = textArea6.getText();
                    textArea6.setText(textt.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea6.append(selectedText + "\n");
                    textArea2.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea2.append(selectedText + "\n");
                    String number = String.valueOf(summs1);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField3.setText(formatter.format(amount));
                    textField3.setFont(textField3.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso3);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField10.setText(formatter.format(amount));
                    textField10.setFont(textField10.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        teamAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea5.getText();
                String selectedText = (String)list3.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list3.getSelectedIndex();
                    summs3 = summs3 + myListtS3.get(iin);
                    sumsso = sumsso + myListtS3.get(iin);
                    String textt = textArea3.getText();
                    textArea3.setText(textt.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea3.append(selectedText + "\n");
                    textArea5.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea5.append(selectedText + "\n");
                    String number = String.valueOf(summs3);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField9.setText(formatter.format(amount));
                    textField9.setFont(textField9.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(sumsso);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField5.setText(formatter.format(amount));
                    textField5.setFont(textField5.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        teamBButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea5.getText();
                String selectedText = (String)list3.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list3.getSelectedIndex();
                    summs3 = summs3 + myListtS3.get(iin);
                    summso1 = summso1 + myListtS3.get(iin);
                    textArea5.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea5.append(selectedText + "\n");
                    text = textArea4.getText();
                    textArea4.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea4.append(selectedText + "\n");
                    String number = String.valueOf(summs3);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField9.setText(formatter.format(amount));
                    textField9.setFont(textField9.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso1);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField4.setText(formatter.format(amount));
                    textField4.setFont(textField4.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = sumss;
                int y = sumsso;
                int b = summs1;
                int bb = summso1;
                int c = summs3;
                int cc = summso3;
                int d = summs4;
                int dd = summso4;
                Scanner scanner = new Scanner(textField1.getText().trim());
                int jml = 0;
                if (scanner.hasNextInt()) {
                    jml =  scanner.nextInt();
                } else {
                    System.out.println("Error");
                }
                scanner = new Scanner(textField2.getText().trim());
                int jml1 = 0;
                if (scanner.hasNextInt()) {
                    jml1 =  scanner.nextInt();
                } else {
                    System.out.println("Error");
                }
                scanner = new Scanner(textField8.getText().trim());
                int jml3 = 0;
                if (scanner.hasNextInt()) {
                    jml3 =  scanner.nextInt();
                } else {
                    System.out.println("Error");
                }
                scanner = new Scanner(textField12.getText().trim());
                int jml4 = 0;
                if (scanner.hasNextInt()) {
                    jml4 =  scanner.nextInt();
                } else {
                    System.out.println("Error");
                }
                float z = x-y;
                float k = (x*(15.0f/100.0f));
                float o=x+k;
                float u=x-k;
                int afte = (int) (jml - z);
                float z1 = b-bb;
                float k1 = (b*(15.0f/100.0f));
                float o1=b+k1;
                float u1=b-k1;
                int afte1 = (int) (jml1 - z1);
                float z3 = c-cc;
                float k3 = (c*(15.0f/100.0f));
                float o3=c+k3;
                float u3=c-k3;
                int afte3 = (int) (jml3 - z3);
                float z4 = d-dd;
                float k4 = (d*(15.0f/100.0f));
                float o4=d+k4;
                float u4=d-k4;
                int afte4 = (int) (jml4 - z4);
                //System.out.println(afte1);
                double amount = Double.parseDouble(String.valueOf(z));
                DecimalFormat formatter = new DecimalFormat("#,###");
                String a = formatter.format(amount);
                textField6.setText(a);
                textField6.setFont(textField6.getFont().deriveFont(Font.BOLD,12f));
                amount = Double.parseDouble(String.valueOf(z1));
                formatter = new DecimalFormat("#,###");
                String a1 = formatter.format(amount);
                textField7.setText(a1);
                textField7.setFont(textField7.getFont().deriveFont(Font.BOLD,12f));
                amount = Double.parseDouble(String.valueOf(z3));
                formatter = new DecimalFormat("#,###");
                String a3 = formatter.format(amount);
                textField11.setText(a3);
                textField11.setFont(textField11.getFont().deriveFont(Font.BOLD,12f));
                amount = Double.parseDouble(String.valueOf(z4));
                formatter = new DecimalFormat("#,###");
                String a44 = formatter.format(amount);
                textField15.setText(a44);
                textField15.setFont(textField15.getFont().deriveFont(Font.BOLD,12f));
                if(y<=o && y>=u && bb<=o1 && bb>=u1 && cc<=o3 && cc>=u3 && dd<=o3 && dd>=u3) {
                    JOptionPane.showMessageDialog(null, "Yes");
                }
                else
                {
                    if(y>=o) {
                        float xx=y-o;
                        double amountt = Double.parseDouble(String.valueOf(xx));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String aa = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team A, cut "+aa+" in team A (in)");
                            }
                    if(y<=u) {
                        float xx=u-y;
                        double amountt = Double.parseDouble(String.valueOf(xx));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String aa = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team A, add "+aa+" in team A (in)");
                    }
                    if(bb>=o1) {
                        float x4=bb-o1;
                        double amountt = Double.parseDouble(String.valueOf(x4));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String a4 = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team B, cut "+a4+" in team B (in)");
                    }
                    if(bb<=u1) {
                        float x4=u1-bb;
                        double amountt = Double.parseDouble(String.valueOf(x4));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String a5 = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team B, add "+a5+" in team B (in)");
                    }
                    if(cc>=o3) {
                        float x6=cc-o3;
                        double amountt = Double.parseDouble(String.valueOf(x6));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String a6 = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team C, cut "+a6+" in team C (in)");
                    }
                    if(cc<=u3) {
                        float x6=u3-cc;
                        double amountt = Double.parseDouble(String.valueOf(x6));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String a8 = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team C, add "+a8+" in team C (in)");
                    }
                    if(dd>=o4) {
                        float x8=dd-o4;
                        double amountt = Double.parseDouble(String.valueOf(x8));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String a9 = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team D, cut "+a9+" in team D (in)");
                    }
                    if(dd<=u4) {
                        float x8=u4-dd;
                        double amountt = Double.parseDouble(String.valueOf(x8));
                        DecimalFormat formatterr = new DecimalFormat("#,###");
                        String a10 = formatterr.format(amountt);
                        JOptionPane.showMessageDialog(null, "No, too much difference in the team D, add "+a10+" in team D (in)");
                    }

                }
                if(afte > 80000000)
                {
                    // przetestować hardcap !!!!!
                    float xxx=afte-80000000;
                    double amountt = Double.parseDouble(String.valueOf(xxx));
                    DecimalFormat formatterr = new DecimalFormat("#,###");
                    String aa = formatterr.format(amountt);
                    JOptionPane.showMessageDialog(null, "Hardcap in the team A, cut "+aa+" in team A (in)");
                }
            }
        });
        removeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea5.getText();
                String selectedText = (String) list3.getSelectedValue();
                if (text.contains(selectedText)) {
                    int iin = list3.getSelectedIndex();
                    summs3 = summs3 - myListtS3.get(iin);
                    String vaule = list3.getSelectedValue().toString();
                    textArea5.setText(text.replaceAll(vaule, ""));
                    String textt = textArea3.getText();
                    textArea3.setText(textt.replaceAll(vaule, ""));
                    String texttt = textArea4.getText();
                    textArea4.setText(texttt.replaceAll(vaule, ""));
                    String textttt = textArea8.getText();
                    textArea8.setText(textttt.replaceAll(vaule, ""));
                    String number = String.valueOf(summs3);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField9.setText(formatter.format(amount));
                    textField9.setFont(textField9.getFont().deriveFont(Font.BOLD, 12f));
                    if (textt.contains(vaule)) {
                        sumsso = sumsso - myListtS3.get(iin);
                        number = String.valueOf(sumsso);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField5.setText(formatter.format(amount));
                        textField5.setFont(textField5.getFont().deriveFont(Font.BOLD, 12f));
                    }
                    if (texttt.contains(vaule)) {
                        summso1 = summso1 - myListtS3.get(iin);
                        number = String.valueOf(summso1);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField4.setText(formatter.format(amount));
                        textField4.setFont(textField4.getFont().deriveFont(Font.BOLD, 12f));
                    }
                    if (textttt.contains(vaule)) {
                        summso4 = summso4 - myListtS3.get(iin);
                        number = String.valueOf(summso4);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField14.setText(formatter.format(amount));
                        textField14.setFont(textField14.getFont().deriveFont(Font.BOLD, 12f));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You can't remove this player because he isn't added");
                }
            }
        });
        teamDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea1.getText();
                String selectedText = (String)list1.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list1.getSelectedIndex();
                    sumss = sumss + myListtS.get(iin);
                    summso4 = summso4 + myListtS.get(iin);
                    textArea1.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea1.append(selectedText + "\n");
                    text = textArea8.getText();
                    textArea8.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea8.append(selectedText + "\n");
                    String number = String.valueOf(sumss);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    sTextField.setText(formatter.format(amount));
                    sTextField.setFont(textField1.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso4);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField14.setText(formatter.format(amount));
                    textField14.setFont(textField14.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer sums = 0;
                combovalue = comboBox4.getSelectedItem().toString();
                Loadd l = new Loadd();
                try {
                    l.wstaw(combovalue,pathh);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                list4.clearSelection();
                listModel4.removeAllElements();
                list4.setModel(listModel4);
                StringBuilder builder = new StringBuilder();
                for(Integer value : l.myListS)
                {
                    sums = sums + value;
                }
                String number = String.valueOf(sums);
                double amount = Double.parseDouble(number);
                DecimalFormat formatter = new DecimalFormat("#,###");
                textField12.setFont(textField12.getFont().deriveFont(Font.BOLD,12f));
                textField12.setText(formatter.format(amount));
                for (String value : l.myList) {
                    builder.setLength(0);
                    builder.append(value);
                    String text = builder.toString();
                    listModel4.addElement(text);
                }
                //  System.out.println(l.myListS.get(0));
                myListtS4 = l.myListS;
                summs4 = 0;
                summso4 = 0;
            }
        });
        teamDButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea2.getText();
                String selectedText = (String)list2.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list2.getSelectedIndex();
                    summs1 = summs1 + myListtS1.get(iin);
                    summso4 = summso4 + myListtS1.get(iin);
                    String textt = textArea8.getText();
                    textArea8.setText(textt.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea8.append(selectedText + "\n");
                    textArea2.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea2.append(selectedText + "\n");
                    String number = String.valueOf(summs1);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField3.setText(formatter.format(amount));
                    textField3.setFont(textField3.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso4);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField14.setText(formatter.format(amount));
                    textField14.setFont(textField14.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        teamDButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea5.getText();
                String selectedText = (String)list3.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list3.getSelectedIndex();
                    summs3 = summs3 + myListtS3.get(iin);
                    summso4 = summso4 + myListtS3.get(iin);
                    textArea5.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea5.append(selectedText + "\n");
                    text = textArea8.getText();
                    textArea8.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea8.append(selectedText + "\n");
                    String number = String.valueOf(summs3);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField9.setText(formatter.format(amount));
                    textField9.setFont(textField9.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso4);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField14.setText(formatter.format(amount));
                    textField14.setFont(textField14.getFont().deriveFont(Font.BOLD, 12f));
                }
                }
        });
        removeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nam = textField16.getText();
                if(lii==0)
                {
                    comboBox1.addItem(nam);
                }
                if(lii==1)
                {
                    comboBox2.addItem(nam);
                }
                if(lii==2)
                {
                    comboBox3.addItem(nam);
                }
                if(lii==3)
                {
                    comboBox4.addItem(nam);
                }
                if(lii>=4)
                {
                    JOptionPane.showMessageDialog(null, "Too many teams ");

                }
                lii++;
            }
        });
        teamAButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea7.getText();
                String selectedText = (String)list4.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list4.getSelectedIndex();
                    summs4 = summs4 + myListtS4.get(iin);
                    sumsso = sumsso + myListtS4.get(iin);
                    String textt = textArea3.getText();
                    textArea3.setText(textt.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea3.append(selectedText + "\n");
                    textArea7.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea7.append(selectedText + "\n");
                    String number = String.valueOf(summs4);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField13.setText(formatter.format(amount));
                    textField13.setFont(textField13.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(sumsso);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField5.setText(formatter.format(amount));
                    textField5.setFont(textField5.getFont().deriveFont(Font.BOLD, 12f));
                }

            }
        });
        teamBButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea7.getText();
                String selectedText = (String)list4.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list4.getSelectedIndex();
                    summs4 = summs4 + myListtS4.get(iin);
                    summso1 = summso1 + myListtS4.get(iin);
                    textArea7.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea7.append(selectedText + "\n");
                    text = textArea4.getText();
                    textArea4.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea4.append(selectedText + "\n");
                    String number = String.valueOf(summs4);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField13.setText(formatter.format(amount));
                    textField13.setFont(textField13.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso1);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField4.setText(formatter.format(amount));
                    textField4.setFont(textField4.getFont().deriveFont(Font.BOLD, 12f));
                }
            }
        });
        teamCButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea7.getText();
                String selectedText = (String)list4.getSelectedValue();
                if(text.contains(selectedText))
                {
                    JOptionPane.showMessageDialog(null, "You selected this player yet, please remove him and after remove please use add");
                }
                else {
                    int iin = list4.getSelectedIndex();
                    summs4 = summs4 + myListtS4.get(iin);
                    System.out.println(summso3);
                    summso3 = summso3 + myListtS4.get(iin);
                    System.out.println(summso3);
                    String textt = textArea6.getText();
                    textArea6.setText(textt.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea6.append(selectedText + "\n");
                    textArea7.setText(text.replaceAll("(?m)^[ \t]*\r?\n", ""));
                    textArea7.append(selectedText + "\n");
                    String number = String.valueOf(summs4);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField13.setText(formatter.format(amount));
                    textField13.setFont(textField13.getFont().deriveFont(Font.BOLD, 12f));
                    number = String.valueOf(summso3);
                    amount = Double.parseDouble(number);
                    formatter = new DecimalFormat("#,###");
                    textField10.setText(formatter.format(amount));
                    textField10.setFont(textField10.getFont().deriveFont(Font.BOLD, 12f));
                }
            }
        });
        removeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea7.getText();
                String selectedText = (String) list4.getSelectedValue();
                if (text.contains(selectedText)) {
                    int iin = list4.getSelectedIndex();
                    summs4 = summs4 - myListtS4.get(iin);
                    String vaule = list4.getSelectedValue().toString();
                    textArea7.setText(text.replaceAll(vaule, ""));
                    String textt = textArea3.getText();
                    textArea3.setText(textt.replaceAll(vaule, ""));
                    String texttt = textArea4.getText();
                    textArea4.setText(texttt.replaceAll(vaule, ""));
                    String textttt = textArea6.getText();
                    textArea6.setText(textttt.replaceAll(vaule, ""));
                    String number = String.valueOf(summs4);
                    double amount = Double.parseDouble(number);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    textField13.setText(formatter.format(amount));
                    textField13.setFont(textField13.getFont().deriveFont(Font.BOLD, 12f));
                    if (textt.contains(vaule)) {
                        sumsso = sumsso - myListtS4.get(iin);
                        number = String.valueOf(sumsso);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField5.setText(formatter.format(amount));
                        textField5.setFont(textField5.getFont().deriveFont(Font.BOLD, 12f));
                    }
                    if (texttt.contains(vaule)) {
                        summso1 = summso1 - myListtS4.get(iin);
                        number = String.valueOf(summso1);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField4.setText(formatter.format(amount));
                        textField4.setFont(textField4.getFont().deriveFont(Font.BOLD, 12f));
                    }
                    if (textttt.contains(vaule)) {
                        summso3 = summso3 - myListtS4.get(iin);
                        number = String.valueOf(summso3);
                        amount = Double.parseDouble(number);
                        formatter = new DecimalFormat("#,###");
                        textField10.setText(formatter.format(amount));
                        textField10.setFont(textField10.getFont().deriveFont(Font.BOLD, 12f));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You can't remove this player because he isn't added");
                }
            }
        });
    }

    public static void main(String[] args)
    {
        Mainn m = new Mainn();
        m.setContentPane(m.root);
        m.setTitle("Trade Machine version beta");
        m.setSize(400,400);
        m.setVisible(true);
    }
}
