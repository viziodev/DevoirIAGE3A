import java.util.List;
import java.util.Scanner;

import entities.Bien;
import entities.Zone;
import services.BienService;
import services.ZoneService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ZoneService zoneService=new ZoneService();
        BienService bienService=new BienService();
       
        do {
            System.out.println("1-Ajouter une Zone");
            System.out.println("2-Lister Toutes Zone"); 
            System.out.println("3-Creer un  Bien"); 
            System.out.println("4-Lister les  Bien");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer le nom de la Zone");
                     String nomZone=sc.nextLine(); 
                     Zone zone=new Zone();
                     zone.setNomZone(nomZone);
                     zoneService.ajouterZone(zone);
                    break;
                case 2:
                    List<Zone> zones= zoneService.listerZone();
                    for (Zone zn : zones) {
                        System.out.println("ID : "+zn.getId() ); 
                        System.out.println("NOM : "+zn.getNomZone() );     
                    }
                  
                    break; 
                    
              case 3:
                     System.out.println("Entrer la Reference du Bien");
                     String reference=sc.nextLine(); 
                     System.out.println("Entrer le Prix du Bien");
                     double prix=sc.nextDouble(); 
                     zones= zoneService.listerZone(); 
                        for (Zone zn : zones) {
                            System.out.println(zn.getId()+"-"+zn.getNomZone());   
                        }
                       System.out.println("Entrer Id d'une Zone");
                       int idZone=sc.nextInt();
                       zone=new Zone();
                       zone.setId(idZone);
                       Bien bien=new Bien();
                       bien.setReference(reference);
                       bien.setPrix(prix);
                       bien.setZone(zone);;
                       bienService.ajouterBien(bien);
                   break;

                   case 4:
                   List<Bien> biens= bienService.listerBien();
                   for (Bien b : biens) {
                       System.out.println("ID : "+b.getId() ); 
                       System.out.println("Reference : "+b.getReference() ); 
                       System.out.println("Prix : "+b.getPrix() ); 
                       System.out.println("Date Creation : "+b.getDateCreation());   
                       System.out.println("Zone : "+b.getZone().getNomZone() ); 
                       System.out.println("------------------------------------");      
                   }
                 
                   break; 
                    
            }
          } while (choix!=5);
    }
}
