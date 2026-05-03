# ms-api-core-cards

Microservice core to flashcards.

> **Note:** This repository focuses exclusively on the **Flashcard Service** component of the broader study platform.
> **Database:** **H2 Database** will be used for local development and demonstrations.

## Project Overview
...

Build a platform that helps users study by allowing them to create and review personalized flashcards.

## Architecture

See [General Project Architecture](docs/general_project_architecture.md) for the system overview.

## MVP Requirements

### System Description
The system consists of a general platform with a main dashboard and user management features, including user profiles. It also provides a deck management section, where users can create and manage flashcards, and a review section dedicated to studying those flashcards.

### Functional Requirements

#### User Management
- Users must be able to sign up, log in, and securely access their own data.

#### Deck Management
- Users must be able to create, edit, and delete decks.
- Each user must have a main page displaying their own decks.

#### Flashcard Management
- Users must be able to create, edit, and delete flashcards within a deck.
- Each flashcard must include:
  - A front side (concept or question)
  - A back side (answer)

#### Review System
- Users must be able to start a review session for a selected deck.
- During the session:
  - A flashcard is displayed with the front side first.
  - The user can flip the card to view the answer.
- *Note: The platform should support additional review methods in the future, but only a basic review flow is required for the MVP.*
