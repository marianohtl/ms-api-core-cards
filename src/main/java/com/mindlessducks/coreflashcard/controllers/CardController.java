package com.mindlessducks.coreflashcard.controllers;

import com.mindlessducks.coreflashcard.dto.CreateCardRequest;
import com.mindlessducks.coreflashcard.dto.CardResponse;
import com.mindlessducks.coreflashcard.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponse> createCard(@RequestBody CreateCardRequest request) {
        return ResponseEntity.ok(cardService.createCard(request));
    }

    @GetMapping("/deck/{deckId}")
    public ResponseEntity<List<CardResponse>> getCardsByDeck(@PathVariable UUID deckId) {
        return ResponseEntity.ok(cardService.getCardsByDeck(deckId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getCard(@PathVariable UUID id) {
        cardService.getCard(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CardResponse> updateCard(
            @PathVariable UUID id,
            @RequestParam String front,
            @RequestParam String back) {
        return ResponseEntity.ok(cardService.updateCard(id, front, back));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable UUID id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}
