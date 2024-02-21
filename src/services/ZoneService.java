package services;

import java.util.List;

import entities.Zone;
import repositories.ZoneRepository;

public class ZoneService {
    private ZoneRepository zoneRepository=new ZoneRepository();
    public void ajouterZone(Zone zone){
        zoneRepository.insertZone(zone);
    }
    public List<Zone> listerZone(){
          return zoneRepository.getAllZones();
    }
    
}
