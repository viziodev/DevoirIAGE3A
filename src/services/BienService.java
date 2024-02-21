package services;
import java.util.List;
import entities.Bien;
import repositories.BienRepository;


public class BienService {
    private BienRepository bienRepository=new BienRepository();
    public void ajouterBien(Bien bien){
        bienRepository.insertBien(bien);
    }
    public List<Bien> listerBien(){
          return   bienRepository.getAllBiens();
    }
      
}
