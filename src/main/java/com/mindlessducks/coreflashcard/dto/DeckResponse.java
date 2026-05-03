package com.mindlessducks.coreflashcard.dto;
import java.util.UUID;
public record DeckResponse(UUID deckId, UUID collectionId, String deckName) {}