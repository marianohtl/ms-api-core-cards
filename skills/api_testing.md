# API Testing Skill

Use this skill when implementing or updating integration tests for REST API controllers.

## Guidelines

1. **Test Scope**: Use `@WebMvcTest` for controller-level integration tests to focus on web layer concerns (routing, serialization, status codes) while mocking services.
2. **Mocking**: Use `@MockBean` to provide mock implementations of service layers.
3. **Assertions**:
    - Verify HTTP status codes (e.g., `200 OK`, `201 Created`, `404 Not Found`).
    - Verify JSON response bodies using `jsonPath`.
    - Ensure proper handling of path variables and request bodies.
4. **Naming Convention**: Test methods should follow the `should_[action]_when_[condition]` pattern.
5. **Coverage**: Ensure all defined endpoints in the controller are covered by tests.

## Success Criteria

- Controller tests pass with `./mvnw test`.
- JSON response structure matches the defined DTOs.
- Error scenarios (e.g., resource not found) are explicitly tested.
