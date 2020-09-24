package pro.bolshakov.geekbrains.springlevelone.lesson07.exception;

public class EntityNotFoundException extends RuntimeException {

    private String entityName;
    private Long entityId;

    public EntityNotFoundException(String entityName, Long entityId, String message) {
        super(message);
        this.entityName = entityName;
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public Long getEntityId() {
        return entityId;
    }
}
