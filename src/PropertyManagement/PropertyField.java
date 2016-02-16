package PropertyManagement;

public enum PropertyField{
    PSEUDO_ROOT_FOLDER_NAME("PSEUDO_ROOT_FOLDER_NAME"),
    LOCAL_FILE_HOLDER_DIRECTORY("LOCAL_FILE_HOLDER_DIRECTORY"),
    LOCAL_PSEUDO_DISC_PREFIX_NAME("LOCAL_PSEUDO_DISC_PREFIX_NAME")
    ;

    private final String text;

    /**
     * @param text
     */
    private PropertyField(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
