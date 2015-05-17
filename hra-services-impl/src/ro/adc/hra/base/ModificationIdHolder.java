package ro.adc.hra.base;

public class ModificationIdHolder {
    private final OperationInfo operationInfo;
    private final ModificationRepository modifRepo;
    private Long modificationId;

    public ModificationIdHolder(final OperationInfo operationInfo, final ModificationRepository modifRepo) {
        this.operationInfo = operationInfo;
        this.modifRepo = modifRepo;
    }

    public Long get() {
        final Modification modif;
        if (modificationId == null) {
            modif = new Modification();
            modif.setOperator(operationInfo.getOperator());
            modif.setTimestamp(operationInfo.getTimestamp());
            modifRepo.createModification(modif);
            modificationId = modif.getId();
        }
        return modificationId;
    }

}
