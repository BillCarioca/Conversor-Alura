package org.example;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {

    public static final String[] opcaoConversor = { "Convesor de Moeda", "Convesor de Temperatura" };

    public static void main(String[] args) {

        JFrame frame = new JFrame("InputDialog");
        do {
            String tipoConvesor = (String) JOptionPane.showInputDialog(
                    frame,
                    "Escolha uma Opção?",
                    "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcaoConversor,
                    opcaoConversor[0]
            );
            if (tipoConvesor == "Convesor de Moeda") {
                String moedaAConverter = MoedaAConverter();
                BigDecimal valorConvertido = ValorConvertido(moedaAConverter);
                if(valorConvertido!=null)
                JOptionPane.showMessageDialog(null, "O Valor Convertido é de $" + valorConvertido);
            }
            int continuar = JOptionPane.showConfirmDialog(
                    frame,
                    "Deseja continuar?",
                    "Continuar",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                    );
            if (continuar==JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null,"Programa Finalizado.");
                break;
            }else if (continuar==JOptionPane.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null,"Programa Concluído.");
                break;
            }
        }while (true);

        System.exit(0);
    }

    public static String MoedaAConverter(){

        String[] tipoDeConversao = {"De Real a Dollar","De Real a Euro","De Real a Libra",
                                    "De Dollar a Real","De Dollar a Euro","De Dollar a Libra"};

        JFrame frame = new JFrame("InputDialog");
        String moedaAConverter = (String) JOptionPane.showInputDialog(
                frame,
                "Escolha a Moeda a Qual Deseja Gira seu Dinheiro?",
                "Moedas",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipoDeConversao,
                tipoDeConversao[0]
        );
        return moedaAConverter;
    }

    public static BigDecimal ValorConvertido(String moedaAConverter){
        BigDecimal valorConvertido = null;
        Double valorInicial = null;
        JFrame frame = new JFrame("InputDialog");
        try {
            valorInicial = Double.valueOf(JOptionPane.showInputDialog(
                        frame,
                        "Insira um Valor",
                        "Valor Inicial",
                        JOptionPane.WARNING_MESSAGE
                ));
            } catch (Exception e){
                JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
            if (valorInicial!=null) {
                switch (moedaAConverter) {
                    case ("De Real a Dollar"): {
                        valorConvertido = BigDecimal.valueOf(valorInicial / 4.77);
                        break;
                    }
                    case ("De Real a Euro"): {
                        valorConvertido = BigDecimal.valueOf(valorInicial / 5.31);
                        break;
                    }
                    case ("De Real a Libra"): {
                        valorConvertido = BigDecimal.valueOf(valorInicial / 6.14);
                        break;
                    }
                    case ("De Dollar a Real"): {
                        valorConvertido = BigDecimal.valueOf(4.77 * valorInicial);
                        break;
                    }
                    case ("De Dollar a Euro"): {
                        valorConvertido = BigDecimal.valueOf(valorInicial / 1.11);
                        break;
                    }
                    case ("De Dollar a Libra"): {
                        valorConvertido = BigDecimal.valueOf(valorInicial / 1.28);
                        break;
                    }
                }
                valorConvertido = valorConvertido.setScale(2,BigDecimal.ROUND_HALF_DOWN);
            }
        return valorConvertido;
    }
}