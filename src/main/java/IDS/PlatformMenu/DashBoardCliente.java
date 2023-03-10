package IDS.PlatformMenu;

import IDS.DbManager.DbManagerCliente;
import IDS.PlatformData.Customer;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class DashBoardCliente {

    /**
     * Gestisce le opzioni che il cliente ha una volta che accede alla piattaforma
     */
    public static void azioneCliente() throws SQLException {
        int azioneCliente;
        Optional<Customer>  clienteLoggato = DashBoardCliente.mainMenu();
        if(clienteLoggato.isPresent()){
            do{
                azioneCliente = DashBoardCliente.sceltaAzioniUtente();
                switch (azioneCliente){
                    case 1 ->  DbManagerCliente.sceltaAziendaCampagneDisponibili(clienteLoggato.get());
                    case 2 ->  clienteLoggato.get().stampaCampagneAderite();
                    case 3 -> DbManagerCliente.lasciaRecensione(clienteLoggato.get());
                    case 4 -> DbManagerCliente.visualizzaRecensioni();
                    case 0 ->  {
                        clienteLoggato = Optional.empty();
                        System.out.println("LOGOUT EFFETTUATO");
                    }
                }
            }while (azioneCliente!=0);
        }
    }

    /**
     * Gestisce il login e registrazione di un cliente
     * @return il cliente loggato, o appena iscritto alla piattaforma
     */
    public static Optional<Customer> mainMenu() throws SQLException {
        return switch (sceltaMainMenu()) {
            case 1 -> DbManagerCliente.loginCliente();
            case 2 -> DbManagerCliente.registrazioneCliente();
            default -> Optional.empty();
        };
    }

    /**
     * Gestisce le opzioni che il cliente ha una volta che accede alla piattaforma
     * @return la scelta effettuata
     */
    public static int sceltaAzioniUtente(){
        int scelta;
        Scanner scr = new Scanner(System.in);
        System.out.println("\nDASHBOARD CLIENTE");
        do{
            System.out.println("1)ISCRIVITI AD UNA CAMPAGNA SCONTI");
            System.out.println("2)VISUALIZZA LE TUE CAMPAGNE SCONTI");
            System.out.println("3)LASCIA UNA RECENSIONE");
            System.out.println("4)VISUALIZZA RECENSIONI");
            System.out.println("0)LOGOUT");
            System.out.println("SCEGLI UN'OPZIONE: ");
            scelta=scr.nextInt();
        }while(scelta<0 || scelta>4);

        return scelta;
    }

    /**
     * Questa funzione gestisce il menu del cliente per
     * effettuare il login o la registrazione
     * @return la scelta effettuata dal cliente
     */
    private static int sceltaMainMenu(){
        int scelta;
        Scanner scr = new Scanner(System.in);
        System.out.println("\nDASHBOARD CLIENTE");
        do{
            System.out.println("1)LOGIN CLIENTE");
            System.out.println("2)REGISTRAZIONE CLIENTE");
            System.out.println("0)EXIT");
            System.out.println("SCEGLI UN'OPZIONE: ");
            scelta=scr.nextInt();
        }while(scelta<0 || scelta>3);

        return scelta;
    }
}