package com.example.battleship;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.http.HttpStatus;
// // import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.http.ResponseEntity;;

@RestController
public class HelloController {

  private List<Ship> ships = new ArrayList<Ship>();


  @GetMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @GetMapping("/ships")
  public List<Ship> allShips() {
    return ships;
  }

  @PostMapping("/ship")
  public Ship addShip(@RequestBody Ship ship) {
    ships.add(ship);
    return ship;
  }
}
