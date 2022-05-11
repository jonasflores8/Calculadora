import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculadora extends Frame implements ActionListener {

    Label L1, L2, L3, L4, L5, L6;
    Button B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12;
    TextField T1, T2, T3, T4, T5, T6;

    public static void main(String args[])
    {
        Calculadora Janela=new Calculadora();
        //Janela.addWindowListener (new fechajanela());
        Janela.show();
    }

    Calculadora()
    {
        setTitle("Calculadora");
        setSize(200,300);
        setLocation(50,50);
        setBackground(new Color(1,10,50));
        setLayout(new GridLayout(12,2));

        L1 = new Label("num.1");
        L1.setForeground(Color.white);
        L2 = new Label("num.2");
        L2.setForeground(Color.white);
        L4 = new Label("sin");
        L4.setForeground(Color.white);
        L5 = new Label("cos");
        L5.setForeground(Color.white);
        L6 = new Label("tan");
        L6.setForeground(Color.white);
        L3 = new Label("Total");
        L3.setForeground(Color.white);

        L1.setFont(new Font("",Font.BOLD,14));
        L2.setFont(new Font("",Font.BOLD,14));
        L3.setFont(new Font("",Font.BOLD,14));
        L4.setFont(new Font("",Font.BOLD,14));
        L5.setFont(new Font("",Font.BOLD,14));
        L6.setFont(new Font("",Font.BOLD,14));

        B1 = new Button ("+"); B1.addActionListener(this);
        B2 = new Button ("-"); B2.addActionListener(this);
        B3 = new Button ("x"); B3.addActionListener(this);
        B4 = new Button ("/"); B4.addActionListener(this);
        B7 = new Button("^"); B7.addActionListener(this);
        B8 = new Button("sqrt"); B8.addActionListener(this);
        B9 = new Button("sin"); B9.addActionListener(this);
        B10 = new Button("cos"); B10.addActionListener(this);
        B11 = new Button ("tan"); B11.addActionListener(this);
        B12 = new Button ("%"); B12.addActionListener(this);
        B5 = new Button ("Limpar"); B5.addActionListener(this);
        B6 = new Button ("Sair"); B6.addActionListener(this);

        B5.setBackground(Color.black);
        B5.setForeground(Color.white);
        B6.setBackground(Color.gray);
        B6.setForeground(Color.white);

        T1 = new TextField();
        T2 = new TextField();
        T3 = new TextField();
        T4 = new TextField();
        T5 = new TextField();
        T6 = new TextField();

        T3.setEditable(false); //define que o textField como somente leitura
        T4.setEditable(false);
        T5.setEditable(false);
        T6.setEditable(false);

        add(L1); add(T1); add(L2); add(T2); add(L4); add(T4); add(L5); add(T5); add(L6); add(T6); add(L3); add(T3);
        add(B1); add(B2); add(B3); add(B4); add(B7); add(B8); add(B9); add(B10); add(B11); add (B12);
        add(B5); add(B6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==B5)
        {
            T1.setText("");
            T2.setText("");
            T4.setText("");
            T5.setText("");
            T6.setText("");
            T3.setText("");
            return;
        }

        if (e.getSource()==B6)
        {
            T1.setText("");
            T2.setText("");
            T4.setText("");
            T5.setText("");
            T6.setText("");
            T3.setText("");
            System.exit(0);
            return;
        }

        double N1, N2=0, result=0;


        try
        {
            N1 = Double.parseDouble(T1.getText());
            if (e.getSource()==B8 || e.getSource()==B9 || e.getSource()==B10 || e.getSource () == B11){
                N2 = 0;
            }else
                N2 = Double.parseDouble(T2.getText());
        }
        catch (NumberFormatException erro)
        {
            T3.setText("Erro");
            T4.setText("Erro");
            T5.setText("Erro");
            T5.setText("Erro");
            T6.setText("Erro");
            return;
        }

        if (e.getSource()==B1) {
            result = N1 + N2;
            T3.setText(""+result);
        }

        if (e.getSource()==B2) {
            result = N1 - N2;
            T3.setText(""+result);
        }

        if (e.getSource()==B3) {
            result = N1 * N2;
            T3.setText(""+result);
        }

        if (e.getSource()==B4) {
            result = N1 / N2;
            DecimalFormat deci = new DecimalFormat("0.00");
            T3.setText(""+ deci.format(result));
        }

        if (e.getSource()==B7) {
            result = Math.pow(N1, N2);
            T3.setText(""+result);
        }

        if (e.getSource()==B8) {
            result = Math.sqrt(N1);DecimalFormat deci = new DecimalFormat("0.00");
            T3.setText(""+deci.format(result));
        }

        if (e.getSource()==B9) {
            result = Math.sin(N1);
            DecimalFormat deci = new DecimalFormat("0.0000000");
            T4.setText(""+deci.format(result));
        }

        if (e.getSource()==B10) {
            result = Math.cos(N1);
            DecimalFormat deci = new DecimalFormat("0.0000000");
            T5.setText(""+deci.format(result));
        }

        if (e.getSource()==B11) {
            result = Math.tan(N1);
            DecimalFormat deci = new DecimalFormat("0.0000000");
            T6.setText(""+deci.format(result));
        }

        if (e.getSource()==B12) {
            result = N1 *(N2/100);
            T3.setText(""+result);
        }


    }
}

