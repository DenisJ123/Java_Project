package ie.atu.javaproject;

import org.springframework.stereotype.Service;
@Service
public class UfcService {

    public void saveFighters(Fighters fighters) {
        System.out.println("Fighter Saved: " + fighters);
    }
    public Fighters getFightersByFightersId(String fighterId){
        return new Fighters();
    }

}
