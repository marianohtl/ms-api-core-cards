package com.mindlessducks.coreflashcard.controllers;

import com.mindlessducks.coreflashcard.dto.CreateCardRequest;
import com.mindlessducks.coreflashcard.dto.CardResponse;
import com.mindlessducks.coreflashcard.entities.Card;
import com.mindlessducks.coreflashcard.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponse> create(@RequestBody CreateCardRequest request) {
        return ResponseEntity.ok(cardService.createCard(request));
    }

    @GetMapping("/deck/{deckId}")
    public ResponseEntity<List<CardResponse>> getByDeck(@PathVariable UUID deckId) {
        return ResponseEntity.ok(cardService.getCardsByDeck(deckId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(cardService.getCard(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponse> update(@PathVariable UUID id, @RequestBody String front, @RequestBody String back) {
        // This is tricky with standard @RequestBody for two strings, 
        // typically one would use a DTO. Using a placeholder for now.
        return ResponseEntity.ok(cardService.updateCard(id, front, back));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}
