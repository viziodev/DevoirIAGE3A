package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Zone;

public class ZoneRepository extends Database {
        private final  String SQL_SELECT_ALL="select * from zone" ;
        private final  String SQL_INSERT="INSERT INTO zone (nom_zone) VALUES (?)";
        //select
       public void insertZone(Zone zone){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, zone.getNomZone());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<Zone> getAllZones(){
            List<Zone> zones=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                  Zone zone=new Zone();
                   zone.setId(rs.getInt("id_zone"));
                   zone.setNomZone(rs.getString("nom_zone"));
                   zones.add(zone);
             }
             rs.close();
           closeConnexion();
        }
         catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
        }
        return  zones;
       }
}
