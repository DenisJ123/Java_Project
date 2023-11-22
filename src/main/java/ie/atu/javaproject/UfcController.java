package ie.atu.javaproject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/fighters")
@RestController
public class UfcController {
    private final UfcService ufcService;

    public UfcController(UfcService ufcService) { this.ufcService = ufcService;}
    @GetMapping("/{fighterId}")
    public ResponseEntity<?> getFighters(@PathVariable String fighterId) {
        if (fighterId.length() > 5 || fighterId.isBlank()) {
            return ResponseEntity.badRequest().body("FighterId is invalid");
        }


        Fighters fighters = ufcService.getFightersByFightersId(fighterId);

        if (fighters == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fighters);
    }

    @PostMapping("/createFighter")
    public ResponseEntity<String> create(@Valid @RequestBody Fighters fighters){
        ufcService.saveFighters(fighters);
        return new ResponseEntity<>("Created new fighter", HttpStatus.OK);
    }


}