package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Bien;
import entities.Zone;

public class BienRepository  extends Database{
    private final  String SQL_SELECT_ALL="select * from bien b, zone z where b.zone_id=z.id_zone" ;
    private final  String SQL_INSERT="INSERT INTO `bien` (`reference`, `prix`, `date_creation`, `zone_id`) VALUES (?,?,?,?)";
    public void insertBien(Bien bien){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, bien.getReference());
                statement.setDouble(2, bien.getPrix());
                statement.setDate(3, new java.sql.Date(new Date().getTime()));
                statement.setInt(4, bien.getZone().getId());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<Bien> getAllBiens(){
            List<Bien> biens=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                     Zone zone=new Zone();
                     zone.setId(rs.getInt("id_zone"));
                     zone.setNomZone(rs.getString("nom_zone"));
                     
                     Bien bien=new Bien();
                     bien.setId(rs.getInt("id_bien"));
                     bien.setReference(rs.getString("reference"));
                     bien.setPrix(rs.getDouble("prix"));
                     bien.setZone(zone);
                   //  bien.setDescription(rs.getString("description"));
                     bien.setDateCreation(rs.getDate("date_creation"));
                     biens.add(bien);
             }
             rs.close();
            closeConnexion();
          }
          catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
         }
         return  biens;
       }
}
