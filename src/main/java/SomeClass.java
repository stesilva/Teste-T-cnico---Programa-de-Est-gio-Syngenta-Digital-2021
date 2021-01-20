import java.util.*;

/**
 * Classe para calcular o hotel mais barato para um determinado cliente
 */
class hotelMaisBarato {
    Scanner sc = new Scanner(System.in);

    private String hotelMaisBarato;
    private String tipoCliente;
    private String[] datas;
    private int qtdDiasDeSemana, qtdDiasFinalDeSemana;
    private int lakewood, bridgewood, ridgewood;

    /**
     * Recupera a entrada e determina o tipo de cliente e os dias que o mesmo quer
     * se hospedar
     */
    void lerEntrada() {
        String entrada = sc.nextLine();
        if (entrada.contains("Regular")) {
            tipoCliente = "Regular";
        } else if (entrada.contains("Reward")) {
            tipoCliente = "Reward";
        } else {
            tipoCliente = "";
        }

        datas = entrada.split(",");

        qtdDiasDeSemana = qtdDiasFinalDeSemana = 0;

        for (int i = 0; i < datas.length; i++) {
            if ((datas[i].contains("sat")) || (datas[i].contains("sun"))) {
                qtdDiasFinalDeSemana += 1;
            } else {
                qtdDiasDeSemana += 1;
            }
        }
    }

    /**
     * Compara os hoteis com base no tipo do cliente
     */
    void compararHoteis() {
        switch (tipoCliente) {
            case "Regular":
                regularCliente();
                break;
            case "Reward":
                rewardCliente();
                break;
            default:
                hotelMaisBarato = "Tipo de cliente invalido.";
                break;
        }
    }

    /**
     * Calcula o valor da hospedagem dos tres hoteis para um cliente regular
     */
    void regularCliente() {
        lakewood = bridgewood = ridgewood = 0;
        lakewood = (110 * qtdDiasDeSemana) + (90 * qtdDiasFinalDeSemana);
        bridgewood = (160 * qtdDiasDeSemana) + (60 * qtdDiasFinalDeSemana);
        ridgewood = (220 * qtdDiasDeSemana) + (150 * qtdDiasFinalDeSemana);
        minimo(lakewood, bridgewood, ridgewood);
    }

    /**
     * Calcula o valor da hospedagem dos tres hoteis para um cliente reward
     */
    void rewardCliente() {
        lakewood = bridgewood = ridgewood = 0;
        lakewood = (80 * qtdDiasDeSemana) + (80 * qtdDiasFinalDeSemana);
        bridgewood = (110 * qtdDiasDeSemana) + (50 * qtdDiasFinalDeSemana);
        ridgewood = (100 * qtdDiasDeSemana) + (40 * qtdDiasFinalDeSemana);
        minimo(lakewood, bridgewood, ridgewood);
    }

    /**
     * Calcula o menor preço entre os tres hoteis, em caso de empate o hotel com
     * maior classificação é o indicado
     * 
     * @param int correspondem ao valor da hospedagem em cada hotel existente
     */
    void minimo(int hotel1, int hotel2, int hotel3) {
        int minimo = hotel1;
        hotelMaisBarato = "Lakewood";

        if (hotel2 <= minimo) {
            minimo = hotel2;
            hotelMaisBarato = "Bridgewood";
        } else if (hotel3 <= minimo) {
            minimo = hotel3;
            hotelMaisBarato = "Ridgewood";
        }
    }

    void printHotelMaisBarato() {
        System.out.println(hotelMaisBarato);
    }
}

/**
 * Classe principal para chamar os metodos da classe auxiliar hotelMaisBarato
 */
public class SomeClass {
    public static void main(String[] args) {
        hotelMaisBarato aux = new hotelMaisBarato();
        aux.lerEntrada();
        aux.compararHoteis();
        aux.printHotelMaisBarato();
    }
}
